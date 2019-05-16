package thread;


/**
 * @author wangxiaolong
 * @date 2019/3/11 16:58
 */
public class Demo2 {
   static int j = 0;
   static String lock = new String();


  public synchronized void get(){
    System.out.println("get");
  }

  public synchronized void set(){
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("set");
  }

  public static void main(String[] args) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          synchronized (lock) {
            if (j != 5) {
              System.out.println("wait begin "
                  + System.currentTimeMillis());
              lock.wait();
              System.out.println("wait end  "
                  + System.currentTimeMillis());
            }
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          synchronized (lock) {
            for (int i = 0; i < 10; i++) {
              j++;
              if (j == 5) {
                lock.notify();
                System.out.println("已发出通知！");
              }
              System.out.println("添加了" + (i + 1) + "个元素!");
              Thread.sleep(1000);
            }
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

  }

}
