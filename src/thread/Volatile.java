package thread;

/**
 * @author wangxiaolong
 * @date 2019/3/18 9:48
 */
public class Volatile {

  volatile boolean flag;

  public void login(){
    System.out.println("我是张三，我上线了！");
    flag=true;
  }

  public void listener(){
    if(flag){
      System.out.println("有人上线了！");
    }

  }

  public static void main(String[] args) {
    Volatile volilatile = new Volatile();
    Thread listener = new Thread(new Runnable() {
      @Override
      public void run() {
        while(true) {
          volilatile.listener();
        }
      }
    });
    listener.start();

//    主线程在启动时休眠会影响后面的线程启动，但是如果后面的线程已经启动了，就不会影响了
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Thread login = new Thread(new Runnable() {
      @Override
      public void run() {
        volilatile.login();
      }
    });
    login.start();


  }

}
