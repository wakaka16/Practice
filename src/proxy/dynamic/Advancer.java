package proxy.dynamic;


import java.lang.reflect.InvocationHandler;

/**
 * @author wangxiaolong
 * @date 2019/5/16 17:26
 * 增强器
 */
public abstract class Advancer implements InvocationHandler {

  /**
   * 被增强对象
   */
  protected Object target;

  public Advancer(Object target){
    this.target = target;
  }

  /**
   * 增强
   * @return 增强后对象
   */
  protected abstract Object advance();

}
