package synchronazied;

public class SynchronizedTest {

  public static void main(String[] args) throws IllegalAccessException, InstantiationException {
    Demo d1 = new Demo();
    Demo d2 = new Demo();
    Demo d3 = Demo.class.newInstance();
    /**
     * 锁定类模板，不同对象，也会阻塞????
     */
//    Thread t1 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        d1.method1();
//      }
//    },"t1");
//    Thread t2 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        d2.method1();
//
//      }
//    },"t2");
//    t1.start();
//    t2.start();

    /**
     * 锁定类实例，不同对象不会阻塞
     //     */
//    Thread t1 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        d1.method2();
//      }
//    },"t1");
//    Thread t2 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        d2.method2();
//      }
//    },"t2");
//    t1.start();
//    t2.start();

    /**
     * 锁定类实例，相同对象会阻塞
     */
//    Thread t1 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        d1.method2();
//      }
//    },"t1");
//    Thread t2 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        d1.method2();
//      }
//    },"t2");
//    t1.start();
//    t2.start();

    /**
     * 同一个对象，访问两种不同方式同步的方法，不会同步执行，因为锁不同
     */
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        d1.method3();
      }
    }, "t1");
    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        d2.method3();
      }
    }, "t2");
    Thread t3 = new Thread(new Runnable() {
      @Override
      public void run() {
        d3.method3();
      }
    }, "t3");
    t1.start();
    t2.start();
    t3.start();

  }

}
