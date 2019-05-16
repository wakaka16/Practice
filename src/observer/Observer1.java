package observer;


public class Observer1 extends Observer {

  /**
   * 此观察者观察的科目
   * @param subject
   */
  public Observer1(Subject subject){
    this.subject = subject;
  }

  /**
   * 当被通知观察者观察时，获取到所观察到的科目事件
   */
  @Override
  public void update() {
    //业务
    //将获取到的科目事件取出
    //获取得到的科目事件


  }
}
