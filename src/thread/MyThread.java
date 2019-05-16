package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangxiaolong
 * @date 2019/3/20 14:11
 * 原子类
 */
public class MyThread extends Thread {
  static  AtomicInteger count=new AtomicInteger(0);
    private static void addCount() {
      for (int i = 0; i < 100; i++) {
        count.incrementAndGet();
      }
      System.out.println(count.get());
    }

    @Override
    public void run() {
      addCount();
    }

  public static void main(String[] args) {
    for(int i =0;i<10;i++){
      new MyThread().start();
    }
    System.out.println(MyThread.count.get());
  }

  }

