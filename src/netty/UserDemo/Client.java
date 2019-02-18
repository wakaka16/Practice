package netty.UserDemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import netty.UserDemo.pojo.SendPojo;

public class Client {

  public static void main(String[] args) throws InterruptedException {
    //
    String host = "ws://127.0.0.1";
    int port = 7879;

    //
    EventLoopGroup group = new NioEventLoopGroup();
    try {
      Bootstrap b = new Bootstrap();
      b.group(group)
          .channel(NioSocketChannel.class)
          // 保持连接
          .option(ChannelOption.SO_KEEPALIVE, true)
          .handler(new ClientInitializer());

      // 连接服务端

      Channel ch = b.connect(host, port).sync().channel();
      //发送消息1
      SendPojo sendPojo = new SendPojo();
      sendPojo.setMessage("3434242");
      sendPojo.setSendTag(SendPojo.SEND_TAG_SERVER);
      ch.writeAndFlush(sendPojo);
//      Thread.sleep(2000);
    } finally {
      // The connection is closed automatically on shutdown.
      group.shutdownGracefully();
    }
  }

}

/**
 * 通道处理
 */
class ClientInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    // 添加自定义的编码器和解码器
    // 添加POJO对象解码器 禁止缓存类加载器
    ch.pipeline().addLast(
        new ObjectDecoder(1024, ClassResolvers.cacheDisabled(this
            .getClass().getClassLoader())));
    // 设置发送消息编码器
    ch.pipeline().addLast(new ObjectEncoder());
    // 处理网络IO
    ch.pipeline().addLast(new ClientHandler());// 处理网络IO
  }


}