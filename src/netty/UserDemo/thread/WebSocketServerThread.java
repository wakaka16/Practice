package netty.UserDemo.thread;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class WebSocketServerThread implements Runnable {

  /**
   * 服务端监听的端口地址
   */
  private Integer port;

  public WebSocketServerThread(Integer port) {
    this.port = port;
  }

  @Override
  public void run() {
    EventLoopGroup boss = new NioEventLoopGroup();
    EventLoopGroup worker = new NioEventLoopGroup();
    try {
      ServerBootstrap bootstrap = new ServerBootstrap();
      bootstrap.group(boss, worker);
      bootstrap.channel(NioServerSocketChannel.class);
      bootstrap.option(ChannelOption.TCP_NODELAY, true);  //不延迟，消息立即发送
      bootstrap.childHandler(new WebSocketServerInitializer());
      ChannelFuture f = bootstrap.bind(port).sync();
      if (f.isSuccess()) {
      }
      f.channel().closeFuture().sync();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      boss.shutdownGracefully();
      worker.shutdownGracefully();
    }
  }
}
