package netty.demo2;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
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
import java.net.InetAddress;

public class HelloServerHandler extends SimpleChannelInboundHandler<Object> {

  protected WebSocketServerHandshaker handshaker;

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
    //处理1
// websocket第一次握手，使用http方式进行承载
    System.out.println("server:receive "+msg.toString());
    if (msg instanceof FullHttpRequest) {
      handleHttpRequest(ctx, (FullHttpRequest) msg);
    }
//     WebSocket接入
    else if (msg instanceof WebSocketFrame) {
      handleWebSocketFrame(ctx, (WebSocketFrame) msg);
    }
  }

  /**
   * 覆盖 channelActive 方法 在channel被启用的时候触发 (在建立连接的时候) channelActive 和 channelInActive
   * 在后面的内容中讲述，这里先不做详细的描述
   */
  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    //RemoteAddress : /127.0.0.1:62406 active !
    System.out.println("RemoteAddress : " + ctx.channel().remoteAddress() + " active !");

    ctx.writeAndFlush("Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");

    super.channelActive(ctx);
  }

  /**
   * @param ctx
   * @param req
   * @throws Exception
   */
  protected void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
    // 如果HTTP解码失败，返回Http异常
    if (!req.decoderResult().isSuccess() || (!"websocket".equals(req.headers().get("Upgrade")))) {
      sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
      return;
    }
    // 构造握手响应返回，本机测试
    String socketUrl = "ws://127.0.0.1:7878/websocket";
    System.out.println("netty server[web socket] :"+ socketUrl);
    WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(socketUrl, null, false);
    this.handshaker = wsFactory.newHandshaker(req);
    if (this.handshaker == null) {
      WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
    } else {
      this.handshaker.handshake(ctx.channel(), req);
    }
  }

  /**
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
    System.out.println("acceptor client context: " + context);
    // 1、===================
    JSONObject messageObject = null;
    int messageType = 0;
    String messageId = "";
    try {
      messageObject = JSONObject.parseObject(context);
      messageType = messageObject.getInteger("messageType");
      messageId = messageObject.getString("messageId");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }

    // 2、==================
//    this.switchMessageType(messageObject, ctx, messageType);
  }

  private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse res) {
    // 返回应答给客户端
    ByteBuf buf = Unpooled.copiedBuffer(res.toString(), CharsetUtil.UTF_8);
    res.content().writeBytes(buf);
    buf.release();
  }
}
