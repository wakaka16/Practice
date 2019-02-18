package collection;

import java.util.Objects;

public class User {

  private String name;
  private String age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(name, user.name) &&
        Objects.equals(age, user.age);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, age);
  }
}
