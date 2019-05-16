package design.filterchain;

/**
 * @author wangxiaolong
 * @date 2019/3/11 10:04
 * 过滤器
 */
public interface Filter {

  public void execute(String request);

}
