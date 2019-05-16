package testinterface;

/**
 * @author wangxiaolong
 * @date 2019/5/9 11:07
 */
public class InterfaceA implements TestInterface {

  @Override
  public void login() {
    System.out.println("InterfaceA");
  }

  public static void main(String[] args) {

  }
}
