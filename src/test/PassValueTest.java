package test;

/**
 * 值传递测试 结论： 基本类型和String是值传递 其他引用类型为地址传递
 */
public class PassValueTest {

  String name = "wxl";
  int age = 10;

  public static void changeNum(int num) {
    num += 1;
  }

  public static void changeStr(String str) {
    str += "world";
  }

  public static void changeSb(StringBuffer sb) {
    sb.append("world");
  }

  public static void changeTest(PassValueTest test) {
    test.age = 1000;
  }

  public static void main(String[] args) {
    PassValueTest passValueTest = new PassValueTest();
    StringBuffer sb = new StringBuffer();
    sb.append("sb");
    int a = 10;
    String str = "hello";
    System.out.println(a);
    System.out.println(str);
    System.out.println(passValueTest.name);
    System.out.println(sb);
    System.out.println(passValueTest.age);
    System.out.println("======================");
    changeNum(a);
    changeStr(str);
    changeStr(passValueTest.name);
    changeSb(sb);
    changeNum(passValueTest.age);
    changeTest(passValueTest);
    System.out.println(a);
    System.out.println(str);
    System.out.println(passValueTest.name);
    System.out.println(sb);
    System.out.println(passValueTest.age);

  }
}
