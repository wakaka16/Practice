package zk;

/**
 * @author wangxiaolong
 * @date 2019/3/7 9:31
 */

import java.io.Serializable;

/**
 * 每台服务器自身属性
 *@author hao.wang
 *@date 2017/1/20 15:37
 */
public class ServerData implements Serializable {

  private static final long serialVersionUID = -3424176231655657827L;
  private int serverId;

  private String serverName;

  public int getServerId() {
    return serverId;
  }

  public void setServerId(int serverId) {
    this.serverId = serverId;
  }

  public String getServerName() {
    return serverName;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }
}
