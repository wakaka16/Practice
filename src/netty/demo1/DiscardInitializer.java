package netty.demo1;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import netty.demo2.HelloClientHandler;

/**
 * 客户端初始化内容
 */
public class DiscardInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
/**
 * 这个地方的 必须和服务端对应上。否则无法正常解码和编码
 * 解码和编码 我将会在下一张为大家详细的讲解。再次暂时不做详细的描述
 */
    ch.pipeline().addLast("http-codec", new HttpServerCodec());
    ch.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));
    ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
    ch.pipeline().addLast("handle", new DiscardServerHandler());
  }
}