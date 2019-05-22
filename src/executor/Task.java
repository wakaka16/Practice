package executor;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

  @Override
  public String call() {
    //1、要执行的任务
    for(int i = 0;i<3;i++){
      System.out.println("任务："+i);
    }
//    try {
//      Thread.sleep(5000L);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    int i= 1/0;
    //1、任务执行完后的回调
    return "回调成功";
  }
}
