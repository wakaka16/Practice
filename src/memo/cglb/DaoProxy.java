package memo.cglb;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author wangxiaolong
 * @date 2019/3/21 18:02
 */
public class DaoProxy implements MethodInterceptor {

  @Override
  public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
    System.out.println("Before Method Invoke");
    proxy.invokeSuper(object, objects);
    System.out.println("After Method Invoke");
    return object;
  }

}