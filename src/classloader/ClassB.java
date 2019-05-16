package classloader;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangxiaolong
 * @date 2019/5/8 16:46
 * 类A依赖类B，类B又依赖类A
 * 会导致死锁
 */
public class ClassB {
  private CalssA  a= new CalssA();

  public static void main(String[] args) {
    AtomicInteger i = new AtomicInteger(0);

    CalssA aa = new CalssA();
  }

}
