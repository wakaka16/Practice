package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionTest {

  public static void main(String[] args) {
    List<User> userList = new ArrayList<>();
    User user1 = new User();
    user1.setName("zs");
    user1.setAge("3243");
    User user2 = new User();
    user2.setName("zs");
    user2.setAge("3243");
//    User user3 = new User();
//    user3.setName("zs");
//    user3.setAge("43243242");
    userList.add(user1);
//    userList.add(user2);
    System.out.println(userList.remove(user2));
//    System.out.println(userList.contains(user2));
//   ;
//    System.out.println( userList.remove(user3));
//    Object o = new User();
//    if(o instanceof Double){
//      System.out.println("11111");
//    }
//    String str = "/Group/Groupid/server";
//    System.out.println(str.substring(0,str.lastIndexOf("/") ));

//    Map<String,String> map = new HashMap<>();
//    System.out.println(map.get(null));

  }

}
