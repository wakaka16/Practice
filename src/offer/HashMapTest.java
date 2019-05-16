package offer;



/**
 * @author wangxiaolong
 * @date 2019/3/4 10:04
 * 主线程在main启动时开始，执行完main就结束
 * 主线程结束，子线程不一定结束
 * 主线程不能设置为守护线程
 */
public class HashMapTest {
  static class ChildThread implements Runnable {

    @Override
    public void run() {
      try {
        Thread.sleep(5000);
        System.out.println("子线程开始执行");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  public static void main(String[] args) {
    System.out.println("main线程开始");
    ChildThread childThread = new ChildThread();
    new Thread(childThread).start();
    System.out.println("main线程结束");
  }


}
