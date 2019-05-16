package design.filterchain;

/**
 * @author wangxiaolong
 * @date 2019/3/11 10:09
 */
public class Client {
  FilterManager filterManager;

  public void setFilterManager(FilterManager filterManager){
    this.filterManager = filterManager;
  }

  public void sendRequest(String request){
    filterManager.filterRequest(request);
  }
}
