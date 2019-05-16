package classloader;

import sun.misc.Launcher;
import sun.misc.ProxyGenerator;

/**
 * @author wangxiaolong
 * @date 2019/4/25 15:17
 */
public class Test44 {

  public static void main(String[] args) throws ClassNotFoundException {
    /**
     * 创建一个类实例
     * 1、jvm中有该类的二进制字节流：直接调用
     * 2、jvm中没有，就按以下3方式进行类初始化
     */
//    Test4 t =new Test4();//1、构造+静态+成员变量
    Class<?> aClass1 = ClassLoader.getSystemClassLoader().getParent().loadClass("classloader.Test4");
    System.out.println(aClass1.getClassLoader());
//
//    Launcher
    String propertys = System.getProperty("java.class.path");
    String[] split = propertys.split(";");
    for (String str:split) {
      System.out.println(str);
    }


//动态代理类生成器
//    ProxyGenerator.
  }
}
