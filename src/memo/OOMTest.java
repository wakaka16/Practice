package memo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxiaolong
 * @date 2019/3/21 15:37
 * 堆溢出异常
 * 栈溢出异常：1、单线程局部变量太多（迭代）2、线程数量太多
 */
public class OOMTest {

  static class Obj{

  }

  public static void main(String[] args) {
    List<Obj> list = new ArrayList<>();
    while(true){
      list.add(new Obj());
    }
  }

}
