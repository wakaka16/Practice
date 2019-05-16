package design.filterchain;

/**
 * @author wangxiaolong
 * @date 2019/3/11 10:10
 */
public class InterceptingFilterDemo {
  public static void main(String[] args) {
    FilterManager filterManager = new FilterManager(new Target());
    filterManager.setFilter(new AuthenticationFilter());
    filterManager.setFilter(new DebugFilter());

    Client client = new Client();
    client.setFilterManager(filterManager);
    client.sendRequest("HOME");
  }
}
