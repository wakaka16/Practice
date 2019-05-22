package proxy.cglib;


import java.lang.reflect.Method;
import java.util.Arrays;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author wangxiaolong
 * @date 2019/5/17 10:51 CgLib动态代理实现
 */
public class CgLibProxyFactory  {

  private final Enhancer en = new Enhancer();

  public <T> T getProxy(Object target) {

    //进行代理
    en.setSuperclass(target.getClass());
    en.setCallback(new MethodInterceptor() {
      @Override
      public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy)
          throws Throwable {

        if (Object.class.equals(method.getDeclaringClass())) {
          return method.invoke(this, args);
        }
        String methodName = method.getName();

        Object result = null;
        try {
          //前置通知
          result = methodProxy.invokeSuper(o, args);
          //返回通知, 可以访问到方法的返回值
          System.out.println(String.format("after method:%s execute", method.getName()));
        } catch (Exception e) {
          e.printStackTrace();
          //异常通知, 可以访问到方法出现的异常
        }finally {

        }
        //后置通知. 因为方法可以能会出异常, 所以访问不到方法的返回值
        return result;
      }
    });
    //生成代理实例
    return (T) en.create();
  }
}