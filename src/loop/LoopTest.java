package loop;

public class LoopTest {

  public static void main(String[] args) {
    int i = 0;//增大i的作用域
    for(;i<5;i++){
      System.out.println(i);
    }
    System.out.println("增大i的作用域"+i);
  }

}
