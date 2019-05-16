package classloader;

/**
 * @author wangxiaolong
 * @date 2019/4/25 15:11
 */
public class Test4 {
  static{

    System.out.println("静态代码块");
  }
  {
    System.out.println("动态代码块");
  }
  //静态变量
  private static String staticFiled = "1";

  //赋值静态变量的静态方法
  public static String staticMethod(){
    staticFiled="2";
    return "给静态字段赋值了";
  }

  public Test4(){
    System.out.println("构造方法调用");
  }


}
