package thread;

/**
 * @Author wxl
 * @Date 2018/11/12
 **/
class Demo{
  public void method(){
    System.out.println("hello");
  }
}
public class WaitTest {

  public static void main(String[] args) {
    Demo demo = new Demo();
    //线程1:进入运行method，然后进行wait 5s释放钥匙
    new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (demo){
          demo.method();
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("线程1：后运行完毕");
        }
      }
    }).start();
    //线程2：
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.yield();
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (demo){
          demo.method();
          System.out.println("线程2：先运行完毕");
        }
      }
    }).start();


  }
}
