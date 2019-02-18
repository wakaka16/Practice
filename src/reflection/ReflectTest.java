package reflection;

/**
 * 关于反射的理解：
 * 一个dog类:具有跑、吃、叫等功能，具有年龄、性别、名称等属性字段
 * 任何一个类的类模板:具有获取注解、获取属性字段、获取父类注解等功能
 */
public class ReflectTest {

  public static void main(String[] args) {
    try {
      //加载这个类，单不进行new创建实例，在加载类的时候，会加载类成员
      Class.forName("reflection.A");
      //hello
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
