package thread;

public class ThreadTest {
  int a = 1;
  boolean status = false;

  /**
   * 状态切换为true
   */
  public void changeStatus(){
    a = 2;//1
    status = true;//2
  }

  /**
   * 若状态为true，则running。
   */
  public void run(){
    if(status){//3
      int b = a+1;//4
      System.out.println(b);
    }
  }

  public static void main(String[] args) {
    ThreadTest threadTest = new ThreadTest();
    //在多线程环境下
    //线程1
    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        threadTest.changeStatus();
      }
    });
    thread1.start();


    //线程2
    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        threadTest.run();
      }
    });
    thread2.start();



  }

}
