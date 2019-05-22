package proxy.dynamic;

/**
 * @Author wxl
 * @Date 2018/11/20 测试动态(反射)代理 主要涉及：Proxy、InvocationHandler、ClassGenerator这三个类 主要技术：反射
 * 主要应用：AOP面向切面编程 说明：这是对切面编程的初步认识，未实现注解版 注解版都是利用了反射的原理
 **/
public class Test {

  public static void main(String[] args) throws IllegalAccessException, InstantiationException {
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

    //需要被增强对象
    SubjectImpl target = new SubjectImpl();
    System.out.println(target.toString());
    //接下来创建增强面（BeforeAdvancer、AfterReturnAdvancer、AfterThrowingAdvancer...）
    AfterAdvancer afterAdvancer = new AfterAdvancer(target);
    SubjectInterface proxy = (SubjectInterface) afterAdvancer.advance();
    //已增强
    proxy.method();
    //未增强
    proxy.test();

  }

}
