package netty.UserDemo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;
import netty.UserDemo.pojo.AckPojo;
import netty.UserDemo.pojo.SendPojo;

public class ClientHandler extends SimpleChannelInboundHandler<Object> {

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg)
      throws Exception {
    try {
      AckPojo ackPojo = (AckPojo) msg;
      System.out.println(ackPojo);
    } finally {
      ReferenceCountUtil.release(msg);
    }
  }
}
