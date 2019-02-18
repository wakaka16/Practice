package proxy.statics;

/**
 * @Author wxl
 * @Date 2018/11/20
 * 静态代理对象
 **/
public class StaticProxy implements SubjectInterface{
  private SubjectImpl subject;

  public StaticProxy() {
    this.subject = new SubjectImpl();
  }

  @Override
  public void method() {
    System.out.println("真是业务执行前");
    subject.method();
    System.out.println("真实业务执行后");
  }
}
