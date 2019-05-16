package memo.cglb;

import annotationTest.Test;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author wangxiaolong
 * @date 2019/3/22 9:23
 */
public class CglibTest {
  public void testCglib() {
    DaoProxy daoProxy = new DaoProxy();

    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(Dao.class);
    enhancer.setCallback(daoProxy);

    Dao dao = (Dao)enhancer.create();
    dao.update();
    dao.select();
  }

  public int  test(int i ,CglibTest cglibTest){
    return i;
  }

  public int  test2(int i){
    return i;
  }
  public static void main(String[] args) {
    CglibTest cglibTest = new CglibTest();
    cglibTest.testCglib();

    int test = cglibTest.test(1, new CglibTest() {
      @Override
      public int test2(int i) {
        return 4;
      }
    });
    System.out.println(test);
  }


}
