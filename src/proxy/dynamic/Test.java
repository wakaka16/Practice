package proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @Author wxl
 * @Date 2018/11/20
 * 测试动态代理
 * 主要涉及：Proxy、InvocationHandler这两个类
 * 主要技术：反射
 * 主要应用：AOP现象切面编程
 **/
public class Test {

  public static void main(String[] args) {
    SubjectInterface target = new SubjectImpl();//生成目标对象
    //接下来创建代理对象
    SubjectInterface proxy = (SubjectInterface) Proxy.newProxyInstance(
        target.getClass().getClassLoader(),
        target.getClass().getInterfaces(), new DynamicProxy(target));
    proxy.method();
  }

}
