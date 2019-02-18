import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 测试构造器调用，作用避免相同的代码写两次，方便维护
 */
public class Test {

  private String age;
  private String name;

  public Test(String age) {
    this.age = age;
  }

  public Test(String age, String name) {
    this(age);
    this.name = name;
  }

  public static void main(String[] args) {
    for (String s : args
        ) {
      System.out.println(s);
    }
    System.out.println("hello");
  }
}
