package proxy.dynamic;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author wxl
 * @Date 2018/11/20
 * 统一增强：例增强颜色
 **/
public class AfterThrowingAdvancer extends Advancer {



  /**
   * 增强类必须保证传入需要增强的类
   * @param target 需要增强的类
   */
  public AfterThrowingAdvancer(Object target) {
    super(target);
  }

  /**
   * 增强方法，在这里细分
   * @param proxy
   * @param method
   * @param args
   * @return
   * @throws Throwable
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    try{
      method.invoke(super.target, args);
    }catch (Exception e){
      System.out.println("方法异常增强");
    }
    return null;
  }

  @Override
  public Object advance() {
    Class<?>[] interfaces = target.getClass().getInterfaces();
    Object o = null;
    //根据有无接口来确定使用jdk代理，还是cglib代理
    if(interfaces.length!=0){
      o=Proxy.newProxyInstance(
          target.getClass().getClassLoader(),
          target.getClass().getInterfaces(), new AfterThrowingAdvancer(target));
    }else{

    }
    return o;
  }
}
