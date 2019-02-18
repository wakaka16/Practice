package classload;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @Author wxl
 * @Date 2018/11/9
 **/
public class Demo {

  public static void main(String[] args) throws IOException {
    InputStream resourceAsStream = Demo.class.getClassLoader().getResourceAsStream("classload/1.properties");
    Properties properties=new Properties();
    properties.load(resourceAsStream);
    String name = properties.getProperty("name");
    System.out.println(name);
    System.out.println("====================");
    URL resource = Demo.class.getResource("/classload/1.properties");
    System.out.println(resource.toString());
    String protocol = resource.getProtocol();
    System.out.println(resource.getProtocol());
    System.out.println(+resource.getPort());
    System.out.println("====================");
    InputStream resourceAsStream1 = Class.class.getResourceAsStream("/classload/1.properties");
    Properties properties2=new Properties();
    properties2.load(resourceAsStream1);
    String name2 = properties2.getProperty("name");
    System.out.println(name2);


  }

}
