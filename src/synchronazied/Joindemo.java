package synchronazied;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @Author wxl
 * @Date 2018/11/12
 **/
public class Joindemo implements Runnable{


  public static void main(String[] args) throws InterruptedException {
    Long start = System.currentTimeMillis();
    Joindemo joindemo = new Joindemo();
    Thread joinThread = new Thread(joindemo);
    joinThread.start();
    System.out.println("Main begin");

//    joinThread.join();
    System.out.println("Main finish "+(System.currentTimeMillis()-start));


  }

  @Override
  public void run() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("join");

  }
}
