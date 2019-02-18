package netty.UserDemo.thread;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 服务器
 */
public class HttpServerThread implements Runnable {

  /**
   * 服务端监听的端口地址
   */
  private Integer port;

  public HttpServerThread(Integer port) {
    this.port = port;
  }

  @Override
  public void run() {//netty非阻塞线程
    //事件触发监听线程
    EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    //事件处理线程
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap b = new ServerBootstrap();
      b.group(bossGroup, workerGroup);
      b.channel(NioServerSocketChannel.class);
      b.childHandler(new ServerInitializer());
      // 服务器绑定端口监听
      ChannelFuture f = null;
      f = b.bind(port).sync();
      // 监听服务器关闭监听
      f.channel().closeFuture().sync();
//       可以简写为
//      b.bind(port).sync().channel().closeFuture().sync();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
}


