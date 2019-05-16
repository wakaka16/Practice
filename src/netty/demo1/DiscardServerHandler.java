package netty.demo1;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

/**
 * 服务端处理通道.这里只是打印一下请求的内容，并不对请求进行任何的响应 DiscardServerHandler 继承自 ChannelHandlerAdapter，
 * 这个类实现了ChannelHandler接口， ChannelHandler提供了许多事件处理的接口方法， 然后你可以覆盖这些方法。
 * 现在仅仅只需要继承ChannelHandlerAdapter类而不是你自己去实现接口方法。
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
  protected WebSocketServerHandshaker handshaker;

  /**
   * 这里我们覆盖了chanelRead()事件处理方法。 每当从客户端收到新的数据时， 这个方法会在收到消息时被调用， 这个例子中，收到的消息的类型是ByteBuf
   *
   * @param ctx 通道处理的上下文信息
   * @param msg 接收的消息
   */
  public void channelRead(ChannelHandlerContext ctx, Object msg)  throws Exception {
    //1.websoket连接第一次发送的是握手消息，服务器返回握手消息
    if (msg instanceof FullHttpRequest) {
      System.out.println("websoket连接握手");
      this.handleHttpRequest(ctx, (FullHttpRequest) msg);
    //2.之后发送的就是具体消息了，根据消息内容做业务
    }else if (msg instanceof WebSocketFrame) {
      System.out.println("WebSocketFrame消息");
      this.handleWebSocketFrame(ctx, (WebSocketFrame) msg);
    }

  }

  /***
   * 这个方法会在发生异常时触发
   *
   * @param ctx
   * @param cause
   */
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    /**
     * exceptionCaught() 事件处理方法是当出现 Throwable 对象才会被调用，即当 Netty 由于 IO
     * 错误或者处理器在处理事件时抛出的异常时。在大部分情况下，捕获的异常应该被记录下来 并且把关联的 channel
     * 给关闭掉。然而这个方法的处理方式会在遇到不同异常的情况下有不 同的实现，比如你可能想在关闭连接之前发送一个错误码的响应消息。
     */
    // 出现异常就关闭
    cause.printStackTrace();
    ctx.close();
  }


  /**
   *处理websocket的http握手消息
   * @param ctx
   * @param req
   * @throws Exception
   */
  protected void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
    // 如果HTTP解码失败，返回Http异常
    if (!req.decoderResult().isSuccess() || (!"websocket".equals(req.headers().get("Upgrade")))) {
      // 返回应答给客户端
      ByteBuf buf = Unpooled.copiedBuffer(req.toString(), CharsetUtil.UTF_8);
      req.content().writeBytes(buf);
      buf.release();
      return;
    }
    // 构造握手响应返回，本机测试
    String socketUrl = "ws://127.0.0.1:8080/websocket";
    System.out.println("netty server[web socket] :" + socketUrl);
    WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(socketUrl, null, false);
    this.handshaker = wsFactory.newHandshaker(req);
    if (this.handshaker == null) {
      WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
    } else {
      this.handshaker.handshake(ctx.channel(), req);
    }
  }

  /**
   * 处理websocket的消息
   * @param ctx
   * @param frame
   */
  private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
    // 是否是关闭链路的指令
    // 如果是正常终止，则直接关闭，在channelInactive(ChannelHandlerContext)方法中处理可能的登出业务
    if (frame instanceof CloseWebSocketFrame) {
      this.handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
      return;
    }
    // 是否是Ping消息
    if (frame instanceof PingWebSocketFrame) {
      ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
      return;
    }
    // 读取本次内容传输的信息
    if (!(frame instanceof TextWebSocketFrame)) {
      throw new UnsupportedOperationException(String.format("%s frame types not supported", frame.getClass().getName()));
    }

    /*
     * 当读取内容成功有，将进行如下处理：
     * 1、已读取的内容是一个json格式字符串（Message对象），如果不能转换成json对象，则放弃本次信息
     * 如果没有messageid，也放弃本次信息
     * 2、根据Message对象所携带的事件类型，执行不同的业务方法
     *    2.1、messageType=1，消息接收任务
     *    2.2、messageType=2，消息接收后确认任务（没有分布式服务节点的情况下，服务器不会接收这种类型的消息）
     *    2.3、messageType=3，消息发送任务（没有分布式服务节点的情况下，服务器不会接收这种类型的消息）
     *    2.4、messageType=4，消息发送后确认任务
     *    2.5、messageType=5，用户登录任务
     *    2.6、messageType=6，用户登出任务
     *    2.7、messageType=7，视频语音呼叫任务
     *    2.8、messageType=8，语音呼叫任务
     *    2.9、messageType=9，视频/语音应答任务
     *    2.10、messageType=10，视频/语音呼叫取消任务
     *    2.11、messageType=-99，心跳回执任务
     * */
    // 返回应答消息
    String context = ((TextWebSocketFrame) frame).text();
//    LOGGER.info("acceptor client context: " + context);
    // 1、===================
    JSONObject messageObject = null;
    int messageType = 0;
    String messageId = "";
    try {
      messageObject = JSONObject.parseObject(context);
//      Validate.notNull(context , "必须传递json形式的message信息!");
      messageType = messageObject.getInteger("messageType");
      messageId = messageObject.getString("messageId");
//      Validate.notBlank(messageId , "message id必须传递!!");
    } catch (Exception e) {
//      LOGGER.error(e.getMessage() , e);
      return;
    }

    // 2、==================
    this.switchMessageType(messageObject, ctx, messageType);
  }

  /**
   * 根据消息内容做业务
   * @param messageObject
   * @param ctx
   * @param messageType
   */
  protected void switchMessageType(JSONObject messageObject , ChannelHandlerContext ctx , int messageType) {
    switch (messageType) {
      // 连接于com.vanda.im2.core.netty.WebSocketInboundServerHandler.handleWebSocketFrame
      // 2.1 ======
      case 1:
//        handleAcceptMessage(messageObject);
        break;
      // 2.2 =====
      case 2:
        // TODO 没有分布式服务节点的情况下，服务器不会接收这种类型的消息
        break;
      // 2.3 =====
      case 3:
        // TODO 没有分布式服务节点的情况下，服务器不会接收这种类型的消息
        break;
      // 2.4 =====
      case 4:
//        handleSendAckMessage(messageObject);
        break;
      // 2.5 =====
      case 5:
//        handleSignInMessage(messageObject , ctx);
        break;
      // 2.6 =====
      case 6:
//        handleSignOutMessage(messageObject , ctx);
        break;
      // 2.7 =====
      case 7:
//        this.handleVoiceCallTask(messageObject);
        break;
      // 2.8 =====
      case 8:
//        this.handleVoiceCallTask(messageObject);
        break;
      // 2.9 =====
      case 9:
//        this.handleVoiceResponseTask(messageObject);
        break;
      // 2.10 =====
      case 10:
//        this.handleVoiceCancelledTask(messageObject);
        break;
      // 2.11 =====
      case -99:
//        handleSendHeartbeatAckMessage(messageObject);
      default:
        break;
    }
  }

}
