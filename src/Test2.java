/**
 * @author wangxiaolong
 * @date 2019/3/22 14:32
 * Class.forName的查找过程：
 * 1、ClassLoader会先尝试在已经load的里面找、
 * 2、找不到的时候，才会去加载class文件
 * 因此如果程序没有停止运行的情况下，第二次会从方法区类进行查找
 */
public class Test2 {
  static String num = "hello";
  public static void main(String[] args) {
    try {
      System.out.println("first find");
      System.out.println("Test3 has found");
      Thread.sleep(10000);
      //由于程序没有停止，第二次会从方法区进行获取类信息
      System.out.println("After 5s：second find");
      Class.forName("Test3");
      System.out.println("Test3 has found");
    } catch (ClassNotFoundException e) {
      System.out.println("Test3 not found");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
