package executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    //从线程池获取线程对象
    ExecutorService service = Executors.newCachedThreadPool();

    //执行任务
    Future<String> submit = service.submit(new Task());
    System.out.println(submit.isDone() + "==" + submit.isCancelled());//false==false
    //获取回调
    int i = 0;
    while (i < 10) {
      if (submit.isDone() && !submit.isCancelled()) {
        System.out
            .println(submit.isDone() + "+++" + submit.isCancelled());//true+++false,加上循环后就是true
        System.out.println(submit.get() + i);//回调成功
        i++;
      }
    }
  }

}
