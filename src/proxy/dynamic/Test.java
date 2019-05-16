package proxy.dynamic;

/**
 * @Author wxl
 * @Date 2018/11/20
 * 测试动态(反射)代理
 * 主要涉及：Proxy、InvocationHandler、ClassGenerator这三个类
 * 主要技术：反射
 * 主要应用：AOP面向切面编程
 **/
public class Test {

  public static void main(String[] args) {
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    //需要被增强对象
    SubjectImpl target = new SubjectImpl();
    //接下来创建增强面（BeforeAdvancer、AfterReturnAdvancer、AfterThrowingAdvancer）
    AfterReturnAdvancer afterReturnAdvancer = new AfterReturnAdvancer(target);
    SubjectInterface proxy = (SubjectInterface)afterReturnAdvancer.advance();
    BeforeAdvancer beforeAdvancer = new BeforeAdvancer(proxy);
    proxy = (SubjectInterface) beforeAdvancer.advance();
    AfterThrowingAdvancer afterThrowingAdvancer = new AfterThrowingAdvancer(proxy);
    proxy = (SubjectInterface)afterThrowingAdvancer.advance();
    proxy.method();


  }

}
