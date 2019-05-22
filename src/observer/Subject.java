package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 科目的统一管理类
 */
public abstract class Subject {

  /**
   * 此科目的所有观察者
   */
  private List<Observer> observerList = new ArrayList<>();

  /**
   * 注册观察者
   */
  public void register(Observer observer) {
    observerList.add(observer);
  }

  /**
   * 注销观察者
   */
  public void unregister(Observer observer) {
    observerList.remove(observer);
  }

  /**
   * 通知观察者更新
   */
  public void post() {
    for (Observer observer : observerList) {
      observer.update();
    }
  }

  /**
   * 获取被通知事件
   */
  public abstract Object getEvent();

}
