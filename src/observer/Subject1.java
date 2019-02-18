package observer;

public class Subject1 extends Subject {

  /**
   * 这个科目产生的事件
   */
  private String subjectState;

  public Subject1(String subjectState) {
    this.subjectState = subjectState;
  }

  @Override
  public Object getEvent() {
    return subjectState;
  }
}
