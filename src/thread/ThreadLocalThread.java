package thread;


import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author wangxiaolong
 * @date 2019/3/20 17:10
 * 测试ThreadLocal
 * 主线程在ThreadLocal中放置了一个值，在其他线程中获取不到，但是主线程中能获取到，大家又共用的一个ThreadLocal变量
 */
public class ThreadLocalThread extends Thread
{

  public static void main(String[] args) throws InterruptedException {
    Tools.t1.set("hello main");
    Thread.sleep(2000);
    new Thread(new Runnable() {
      @Override
      public void run() {
        String s = Tools.t1.get();
        System.out.println(s);
      }
    }).start();
    String s = Tools.t1.get();
    System.out.println(s);
  }

}

