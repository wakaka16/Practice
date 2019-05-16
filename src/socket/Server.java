package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author wangxiaolong
 * @date 2019/5/7 10:11
 * 当客户端和服务器建立通信时，只会存在一个线程，
 * 多个消息又线程内的输入流进行阻塞
 */
public class Server {

  /**
   * 通信处理类
   */
  static class Handler implements Runnable {

    private Socket socket;
    private BufferedReader br;

    public Handler(Socket socket) throws IOException {
      this.socket = socket;
      this.br= new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
    }

    @Override
    public void run() {
        try {
          br = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), StandardCharsets.UTF_8));
          String line;

          //这个线程会阻塞在这里，也就是打印了通话内容后，线程并不会结束
          //当管道内没有数据时，线程就会停留在这里，不会继续向下执行
//          while(true){
////            11111111111只打印了一遍
//            System.out.println("11111111111");
//            System.out.println(br.readLine());
//          }
          while ((line = br.readLine())!=null) {
            if("88".equals(line)){
              socket.close();
            }else{
              System.out.println(line);
            }
          }

        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          if (null != br) {
            try {
              br.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
            try {
              this.socket.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }


    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufReader = null;
    Socket client = null;
    try {
      //服务器地址
      ServerSocket server = new ServerSocket(7775);
      while (true) {
        //阻塞(如果accept未检测到连接，程序不会向下执行)
        client = server.accept();
        //如果就收到客户端请求就分配给一个处理器
        new Thread( new Handler(client)).start();

      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      client.close();
      bufReader.close();
    }


  }

}
