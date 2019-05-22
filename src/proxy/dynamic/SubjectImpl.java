package proxy.dynamic;

/**
 * @Author wxl
 * @Date 2018/11/20
 **/
public class SubjectImpl implements SubjectInterface{

  @Override
  public void method() {
    System.out.println("业务");
  }

  @Override
  public void test() {
    System.out.println("TEST");
  }
}
