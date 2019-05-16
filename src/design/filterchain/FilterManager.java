package design.filterchain;

/**
 * @author wangxiaolong
 * @date 2019/3/11 10:08
 */
public class FilterManager {
  FilterChain filterChain;

  public FilterManager(Target target){
    filterChain = new FilterChain();
    filterChain.setTarget(target);
  }
  public void setFilter(Filter filter){
    filterChain.addFilter(filter);
  }

  public void filterRequest(String request){
    filterChain.execute(request);
  }
}
