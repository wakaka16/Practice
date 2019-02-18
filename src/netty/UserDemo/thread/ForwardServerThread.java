package netty.UserDemo.thread;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ForwardServerThread implements Callable<Channel> {

  private String ip;
  private Integer port;
  private Object msg;

  public ForwardServerThread(String ip, Integer port, Object msg) {
    this.ip = ip;
    this.port = port;
    this.msg = msg;
  }

  @Override
  public Channel call() throws Exception {
    EventLoopGroup group = new NioEventLoopGroup();

    Bootstrap b = new Bootstrap();
    b.group(group)
        .channel(NioSocketChannel.class)
        // 保持连接
        .option(ChannelOption.SO_KEEPALIVE, true)
        .handler(new ForwardInitializer());
    // 连接服务端
    Channel ch = null;
    try {
      ch = b.connect(ip, port).sync().channel();
      //发送消息
      ch.writeAndFlush(msg);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      // The connection is closed automatically on shutdown.
      group.shutdownGracefully();
    }

    return ch;
  }

  /**
   * 转发通道，只是发送
   */
  private class ForwardInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
      // 添加自定义的编码器和解码器
      // 添加POJO对象解码器 禁止缓存类加载器
      ch.pipeline().addLast(
          new ObjectDecoder(1024, ClassResolvers.cacheDisabled(this
              .getClass().getClassLoader())));
      // 设置发送消息编码器
      ch.pipeline().addLast(new ObjectEncoder());

    }
  }

}
