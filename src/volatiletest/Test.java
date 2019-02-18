package volatiletest;

/**
 * volatile变量–多线程间可见
 *
 * 由于每个线程都有自己的工作内存区，因此当一个线程改变自己的工作内存中的数据时，对其他线程来说，可能是不可见的。 为此，可以使用volatile关键字迫使所有线程均读写内存中的变量，从而使得volatile变量在多线程间可见。
 */
public class Test {


  public static void main(String[] args) throws InterruptedException {
    //一份资源
    Demo demo = new Demo();
    //一个线程对资源进行修改
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(5000);
          demo.i += 1;
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
    //一个线程服务查看资源有没有修改
    new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          if (demo.i == 2) {
            /**
             * 1、其他线程对变量的修改，可以及时反应在当前线程中；
             * 2、确保当前线程对volatile变量的修改，能及时写回到共享内存中，并被其他线程所见；
             * 3、使用volatile声明的变量，编译器会保证其有序性。
             */
            System.out.println("变了！");
          }
        }
      }
    }).start();

  }

}
