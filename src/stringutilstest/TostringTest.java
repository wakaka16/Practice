package stringutilstest;

import java.util.HashMap;
import java.util.Map;

public class TostringTest {


  public static void main(String[] args) {
//    String name = "hello";
//    Map<String, Object> m = new HashMap<>();
//    m.put("name", name);
//    System.out.println(m.get("name").toString());//hello
//    System.out.println((Integer) m.get("age"));
    User user = new User();
    String str = "wangxiaolong44234342|wangxiaolong|device1";
    user.setName(str);
    String substring = user.getName().substring(0, str.lastIndexOf("|"));
    System.out.println(substring);
    System.out.println(user.getName());
  }

}
