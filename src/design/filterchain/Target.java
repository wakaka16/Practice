package design.filterchain;

/**
 * @author wangxiaolong
 * @date 2019/3/11 10:06
 */
public class Target {
  public void execute(String request){
    System.out.println("Executing request: " + request);
  }
}
