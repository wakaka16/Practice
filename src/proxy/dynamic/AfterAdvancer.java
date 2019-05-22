package proxy.dynamic;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @Author wxl
 * @Date 2018/11/20 方法结束后增强器
 **/
public class AfterAdvancer extends Advancer {

  private static final Enhancer en = new Enhancer();


  /**
   * 增强类必须保证传入需要增强的类
   *
   * @param target 需要增强的类
   */
  public AfterAdvancer(Object target) {
    super(target);
  }

  /**
   * 增强方法，在这里细分（根据方法名进行增强，在注解版中当然是根据注解增强）
   * 方法头上有哪些注解就进行对应的增强
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if("method".equals(method.getName())){
      method.invoke(super.target, args);
      System.out.println("方法结束后增强");
    }else{
      method.invoke(super.target, args);
    }

    return null;
  }

  @Override
  public Object advance() {
    Class<?>[] interfaces = target.getClass().getInterfaces();
    Object proxy = null;
    //根据有无接口来确定使用jdk代理，还是cglib代理
    //jdk代理从参数上可以看出必须使用接口
    if (interfaces.length != 0) {
      proxy = getJdkProxy(target, interfaces);
    } else {
      proxy = getCglibProxy(target);
    }
    return proxy;
  }

  /**
   * 通过cglib代理
   *
   * @param target 被代理对象
   * @return 代理对象
   */
  public static <T> T getCglibProxy(Object target) {

    //进行代理
    en.setSuperclass(target.getClass());
    en.setCallback(new MethodInterceptor() {
      @Override
      public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy)
          throws Throwable {

        if (Object.class.equals(method.getDeclaringClass())) {
          return method.invoke(this, args);
        }
        Object result = null;
        result = methodProxy.invokeSuper(o, args);
        System.out.println(String.format("方法结束后增强"));
        return result;
      }
    });
    //生成代理实例
    return (T) en.create();
  }

  /**
   * 通过jdk代理
   *
   * @param target 被代理对象
   * @param interfaces 代理对象接口
   * @return 代理对象
   */
  public static <T> T getJdkProxy(Object target, Class<?>[] interfaces) {
    Object o = Proxy.newProxyInstance(
        target.getClass().getClassLoader(),
        interfaces, new AfterAdvancer(target));
    return (T) o;
  }
}
