package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * @author wangxiaolong
 * @date 2019/5/7 10:44
 */
public class Client {
  private static PrintWriter out;

  public static void main(String[] args) throws IOException {
    Socket client = new Socket();
    //连接服务器
    SocketAddress address  = new InetSocketAddress(7775);
    client.connect(address);
    //发送消息
    OutputStream os = client.getOutputStream();
    Scanner sc = new Scanner(System.in);
    String s;
    while(true){
      s = sc.next();
      out = new PrintWriter(os,true);
      out.println(s);
    }
  }

}
