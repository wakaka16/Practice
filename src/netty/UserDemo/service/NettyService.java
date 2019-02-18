package netty.UserDemo.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import netty.UserDemo.thread.HttpServerThread;
import netty.UserDemo.thread.WebSocketServerThread;

public class NettyService {

  /**
   * 1、
   * 注入实时服务的properties
   * 获取各种协议的端口信息
   */

  /**
   * 2、 初始化各种协议的netty服务
   */
  public static void innitNettyServer() {
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    cachedThreadPool.execute(new HttpServerThread(7878));
    cachedThreadPool.execute(new WebSocketServerThread(7879));
//    cachedThreadPool.execute(new HttpsServerThread(7880));
//    cachedThreadPool.execute(new WebSocketServerThread(7881));

  }

  public static void main(String[] args) {
//    innitNettyServer();
    new Thread(new HttpServerThread(7878)).start();

  }

}
