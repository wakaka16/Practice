package synchronazied;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @Author wxl
 * @Date 2018/11/12
 **/
public class Joindemo {

  public static void main(String[] args) throws InterruptedException {
    //join线程
    Thread t = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("join线程");
      }
    });

    //运行线程
    Thread t1= new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("运行线程");
        try {
          t.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          t.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
     ReentrantLock objectLock = new ReentrantLock();



  }

}
