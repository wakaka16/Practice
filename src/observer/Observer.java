package observer;

/**
 * 观察者统一管理类
 */
public abstract class Observer {

  /**
   * 用于观察者获取被通知的事件
   */
  protected Subject subject;

  /**
   * 用于给Subject通知时调用的更新方法
   */
  public abstract void update();
}
