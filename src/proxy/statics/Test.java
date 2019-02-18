package proxy.statics;

/**
 * @Author wxl
 * @Date 2018/11/12
 * 静态代理测试
 * 主要技术：面向接口编程
 **/
public class Test {

  public static void main(String[] args) {
    SubjectInterface subjectInterface = new StaticProxy();
    subjectInterface.method();
  }


}
