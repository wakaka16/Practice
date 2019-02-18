package netty.demo2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 客户端处理类
 * 此处仅演示处理String类型
 */
public class HelloClientHandler extends SimpleChannelInboundHandler<String> {

  /**
   * 读取服务端返回的信息
   * @param ctx
   * @param msg
   * @throws Exception
   */
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    //服务器响应
    System.out.println("Server say : " + msg);
  }

  /**
   * 客户端连接上服务端激活执行此方法
   * @param ctx
   * @throws Exception
   */
  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    //通道激活
    System.out.println("The channelActive ");
    super.channelActive(ctx);
  }

  /**
   * 服务端关闭激活此方法
   * @param ctx
   * @throws Exception
   */
  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    //服务关闭、、
    System.out.println("channelInactive close");
    super.channelInactive(ctx);
  }
}