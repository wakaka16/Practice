package synchronazied;

/**
 * 1、同步代码块比同步方法更高效，因为同步的代码块之外的代码执行为并发执行 2、同步实例针对一个对象进行同步，和同步静态资源针对类模板进行同步（所有对象），的区别是同步的范围不同
 */
public class Demo {

  /**
   * 生成零长度的byte[]对象只需3条操作码，而Object lock= new Object()则需要7行操作码。
   */
  //被同步对象必须私用，防止被更改，导致同步对象的变化，同步失效
  private byte[] lock = new byte[0]; // 特殊的instance变量
  private final static Object obj = new Object();//静态资源属于类模板

  /**
   * 1、同步类模板,
   */
  public void method1() {
    synchronized (obj) {
      System.out.println("hello1");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 2、同步类实例
   */
  public void method2() {
    synchronized (this) {
      System.out.println("hello2");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 锁定类模板
   */
  public void method3(){
    synchronized (Demo.class) {
      System.out.println("hello3");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  //3、public synchronized static void methodAAA()   // 同步的static 函数
  //4、 synchronized(Foo.class)   // class literal(类名称字面常量)
}

