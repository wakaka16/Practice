package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author wxl
 * @Date 2018/11/20
 * 动态代理对象
 **/
public class DynamicProxy implements InvocationHandler {

  private Object target;

  public DynamicProxy(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("before");
    method.invoke(target, args);
    System.out.println("after");
    return null;
  }
}
