package zk;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author wangxiaolong
 * @date 2019/3/7 9:33
 */
public class Test {
//  public static void main(String[] args) {
//    ExecutorService service = Executors.newCachedThreadPool();
//    Semaphore semaphore = new Semaphore(10);
//    for (int i = 0; i < 10; i++) {
//      final int idx = i;
//      Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//          try {
//            semaphore.acquire();
//            //初始化一个zkclient的连接
//            ZkClient zk = new ZkClient(CONNECTION_STRING,
//                SESSION_TIMEOUT, SESSION_TIMEOUT,
//                new SerializableSerializer());
//            //定义一台争抢master节点的服务器
//            ServerData serverData = new ServerData();
//            serverData.setServerId(idx);
//            serverData.setServerName("#server-" + idx);
//            //初始化一个争抢master节点的服务
//            MasterServer ms = new MasterServer(zk, serverData);
//            ms.start();
//            semaphore.release();
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
//        }
//      };
//      service.execute(runnable);
//    }
//    service.shutdown();
//  }


}
