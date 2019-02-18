package design.single;

/**
 * 单例模式
 */
public class Demo {

  int i = 0;
  private static Demo demo = new Demo();

  private Demo() {
  }

  public static Demo getInstance() {
    return demo;
  }

}
