package netty.UserDemo.thread;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import netty.UserDemo.cache.NettyCache;
import netty.UserDemo.pojo.AckPojo;
import netty.UserDemo.pojo.SendPojo;

/**
 * 公共的处理通道 公共的处理方式
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    // 添加对象解码器 负责对序列化POJO对象进行解码 设置对象序列化最大长度为1M 防止内存溢出
    // 设置线程安全的WeakReferenceMap对类加载器进行缓存 支持多线程并发访问 防止内存溢出
    ch.pipeline().addLast(
        new ObjectDecoder(1024*1024*10000,ClassResolvers
            .weakCachingConcurrentResolver(this.getClass()
                .getClassLoader())));
    // 添加对象编码器 在服务器对外发送消息的时候自动将实现序列化的POJO对象编码
    ch.pipeline().addLast(new ObjectEncoder());
    // 处理网络IO
    ch.pipeline().addLast(new ServerHandler());



//    ch.pipeline().addLast("http-codec", new HttpServerCodec());
//    ch.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));
//    ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
//    ch.pipeline().addLast("handle", headler);
  }

  /**
   * 服务器处理
   */
  private class ServerHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg)
        throws Exception {
      System.out.println(ctx.channel().id());
      /**
       *
       * 协议处理
       *
       */

      /**
       * 一、发送处理（SendPojo）
       * 0、建立通道，已经在channelActive处理
       * 1、登录
       * 2、心跳
       * 3、发送信息
       * 3.1、客户端发送（以下先暂时不考虑）
       * ----3.1.1、发送文本信息
       * ----3.1.2、发送语音信息
       * ----3.1.3、发送。。。。
       * 3.2、服务端发送(以下先暂时不考虑）
       * ----3.2.1、发送文本信息
       * ----3.2.2、发送语音信息
       * ----3.2.3、发送。。。。
       * 二、回执处理（AckPojo）
       * 1、客户端回执
       * 2、服务端回执
       */

      //一
      if (msg instanceof SendPojo) {
        SendPojo sendPojo = (SendPojo) msg;
        if (sendPojo.getMessageType() == SendPojo.MESSAGE_TYPE_LOGIN) {
          /**
           * 1、登录条件（移动端和PC端只能各有一台设备）
           * 2、建立映射关系:用户名|设备->channelId
           * 3、数据库写入用户登录
           */

        } else if (sendPojo.getMessageType() == SendPojo.MESSAGE_TYPE_HEART) {
          /**
           * 1、建立/更新心跳 channelId->dataTime
           * 2、向客户端发送心跳包（）
           */
        } else {//消息类型（暂时统一处理所有类型的消息消息）
          switch (sendPojo.getSendTag()) {
            case SendPojo.SEND_TAG_SERVER:
              /**
               * 0、serverMap判断没有，保存sendServerName->channelId到serverMap
               * 0.1、获取接收用户的用户名，判断是否是自己为该用户提供服务，通过用户名|设备获得channel
               * 1、【处理信息-->forwardServerHandleSendPojo--返回的list不为空】
               * 1.1、根据用户名获取该用户名的设备在线情况deviceMap
               * 1.2、都不在线，通过sendServerName获取channel返回ack【createForwardServerAckPojo】
               * 1.3、设备在线，建立映射关系，更新sendPojo返回
               * 2、发送信息
               * 2.1、通过用户名|设备获得channel进行发送
               */
              break;
            case SendPojo.SEND_TAG_CLIENT:
              /**
               * 1、【处理信息-->sendServerHandleSendPojo--返回list】
               * 2、发送信息forwardingName，根据服务名->serverMap获取到channel
               * 2.1、没有就创建channel，本地保存channelMap、serverMap（forwardingName）
               * 2.2、有就放入sendPojo
               */
              break;
          }
        }

      }
      //二
      if (msg instanceof AckPojo) {
        AckPojo ackPojo = (AckPojo) msg;
        switch (ackPojo.getAckTag()) {
          case AckPojo.ACKTAG_SERVER:
            /**
             * 1、通过target用户名|设备判断用户是否在线
             * 2、通过target用户名|设备获取channel
             * 3、【修改映射，删除映射检查映射是否完成hasCompleteUserMapping】
             * 4、更新ack【updateAckPojo】
             * 5、channel发送
             */
            break;
          case AckPojo.ACKTAG_CILIENT:
            /**
             * 1、【修改映射，检查映射是否完成hasCompleteDeviceMapping】
             * 2、通过forwardServerName获取通道channel
             * 3、更新数据（映射、server）【updateAckPojo】
             * 4、channel发送
             */
            break;
        }
      }

    }

    /**
     * 客户端与服务端连接时调用
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
      /**
       * 1、客户端连接服务器，建立映射关系，channelId->channel
       * 2、服务端连接服务器，建立映射关系，，channelId->channel
       */
      NettyCache.addChannelMap(ctx.channel().id().toString(), ctx.channel());
    }

    /**
     * 客户端（服务端）与服务端断开连接时调用
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
      /**
       * 1、客户端由心跳进行删除工作
       * 2、服务端如果断开连接就要在这里进行删除工作
       */
      String channelId = ctx.channel().id().toString();
      NettyCache.deleteServerMapAndChannelMap(channelId);

    }


  }
}