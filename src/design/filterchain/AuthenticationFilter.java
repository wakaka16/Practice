package design.filterchain;

/**
 * @author wangxiaolong
 * @date 2019/3/11 10:05
 */
public class AuthenticationFilter implements Filter {

  @Override
  public void execute(String request) {
    System.out.println("Authenticating request: " + request);
  }
}
