package netty.demo1;

/**
 * netty测试
 */
public class NettyTest {

  /**
   * 将规则跑起来
   */
  public static void main(String[] args) throws Exception {
    int port = 8080;
    if (args.length > 0) {
      port = Integer.parseInt(args[0]);
    }
    new DiscardServer(port).run();
    System.out.println("server:run()");
  }

}
