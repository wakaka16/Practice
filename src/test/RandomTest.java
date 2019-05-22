package test;

/**
 * 随机数测试
 */
public class RandomTest {

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      int random = (int) (Math.random() * 21) + 1;
      System.out.println(random);
      if (random > 21 || random < 1) {
        System.out.println("******************************************");
      }
    }

  }
}
