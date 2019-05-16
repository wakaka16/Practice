package spring.annotion;

/**
 * @author wangxiaolong
 * @date 2019/5/16 15:14
 */
@Component
public class Test {

  @Autowired
  private  User user;

  public void test(){
    user.say();
  }

  public static void main(String[] args) throws ClassNotFoundException {
    Test test = (Test)BeanFactory.getBean("test");
    test.test();
  }

}
