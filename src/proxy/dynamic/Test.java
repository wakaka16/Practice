package proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @Author wxl
 * @Date 2018/11/20
 * 测试动态(反射)代理
 * 主要涉及：Proxy、InvocationHandler这两个类
 * 主要技术：反射
 * 主要应用：AOP面向切面编程
 **/
public class Test {

  public static void main(String[] args) {
    //生成目标对象
    SubjectImpl target = new SubjectImpl();
    //接下来创建代理对象
    SubjectInterface proxy = (SubjectInterface) Proxy.newProxyInstance(
        target.getClass().getClassLoader(),
        target.getClass().getInterfaces(), new DynamicProxy(target));
    proxy.method();

    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
  }

}
