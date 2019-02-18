package netty.UserDemo.thread;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketServerInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel socketChannel) throws Exception {
    ChannelPipeline p = socketChannel.pipeline();

    //HttpServerCodec: 针对http协议进行编解码
    p.addLast("http-codec", new HttpServerCodec());
    /**
     * 作用是将一个Http的消息组装成一个完成的HttpRequest或者HttpResponse，那么具体的是什么
     * 取决于是请求还是响应, 该Handler必须放在HttpServerCodec后的后面
     */
    p.addLast("aggregator", new HttpObjectAggregator(65536));
    //ChunkedWriteHandler分块写处理，文件过大会将内存撑爆
    p.addLast("http-chunked", new ChunkedWriteHandler());
    //请求处理
//    p.addLast("inboundHandler", webSocketChannelHandlerFactory.newWSInboundHandler());
    //关闭处理
    p.addLast(new WebSocketServerHandler());

  }
  private class WebSocketServerHandler  extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg)
        throws Exception {

      System.out.println(msg);

    }
  }
}
