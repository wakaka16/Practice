package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangxiaolong
 * @date 2019/3/13 16:54
 */
public class ExcutorsCache {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    for(int i = 0;i<10;i++){
      executorService.execute(new Runnable() {
        @Override
        public void run() {
          System.out.print("A");
        }
      });
      executorService.execute(new Runnable() {
        @Override
        public void run() {
          System.out.print("B");
        }
      });
      executorService.execute(new Runnable() {
        @Override
        public void run() {
          System.out.print("C");
        }
      });
      executorService.execute(new Runnable() {
        @Override
        public void run() {
          System.out.print("D");
        }
      });
    }
  }

}
