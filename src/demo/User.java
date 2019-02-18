package demo;

/**
 * @Author wxl
 * @Date 2018/11/28
 **/
public class User implements Cloneable {
  private Person person;

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
