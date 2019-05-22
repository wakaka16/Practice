package observer;

public class Test {

  public static void main(String[] args) {
    //创建科目
    Subject1 subject1 = new Subject1("今天星期二");
    //创建观察者
    Observer1 observer1 = new Observer1(subject1);
    // 科目注册观察者

    subject1.register(observer1);
    // 观察者观察科目并给出科目事件
    subject1.post();//观察者更新
    //注销观察者1
    subject1.unregister(observer1);

    // 观察者观察科目并给出科目事件
    subject1.post();//观察者更新
  }

}
