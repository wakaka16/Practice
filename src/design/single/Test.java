package design.single;

import java.util.Date;

/**
 * 当一个线程获取到单例，另一个是否需要排队
 */
public class Test {

  public static void main(String[] args) throws InterruptedException {
    Date date = new Date(System.currentTimeMillis());
    /**
     * 这个单例就是类似我们的web项目
     */
    Threads thread = new Threads("1");
    /**
     * 多个线程就类似多个用户
     */
    for (int i = 1; i < 11; i++) {
      /**
       * 类似多个用户进入我们的web项目
       */
      new Thread(thread).start();
    }
    Thread.sleep(2000);
    Date date2 = new Date(System.currentTimeMillis());
    System.out.println("=============");
    System.out.println("总耗时：预计2s" + (date2.getTime() - date.getTime()));
    System.out.println("最终的i：" + Demo.getInstance().i);
  }

}
