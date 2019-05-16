package thread;

/**
 * @author wangxiaolong
 * @date 2019/3/11 17:00
 */
public class Demo2Test {
  static int  foo = 10;
  volatile static int a = 1;
  public static void main(String[] args) {
      a = 2;
      a = foo + 10;
      int b = a + 20;
    System.out.println(b);
  }

}
