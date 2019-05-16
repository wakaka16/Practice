package design.filterchain;

/**
 * @author wangxiaolong
 * @date 2019/3/11 10:06
 */
public class DebugFilter implements Filter {

  @Override
  public void execute(String request) {
    System.out.println("request log: " + request);
  }
}
