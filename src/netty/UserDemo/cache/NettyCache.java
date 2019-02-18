package netty.UserDemo.cache;

import io.netty.channel.Channel;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存
 */
//@Service
public class NettyCache {

  /**
   * channel通道映射
   * channelId->channel
   * 建立通道关系
   */
  private static Map<String,Channel> channelMap = new ConcurrentHashMap<>();

  /**
   * 用户设备对应channelId映射
   * 用户名|设备->channelId
   * 作用：通过用户名和设备查询到channelId，再通过channelId获得channel
   */
  private static Map<String,String> deviceMap = new ConcurrentHashMap<>();

  /**
   * 用户设备登录状态映射心跳
   * 用户名|设备->时间
   * 作用：通过定时器检查，时间到期的用户设备（没有心跳），到deviceMap获取channelId并清除，
   * 到channelMap根据channelId进行清除
   */
  private static Map<String,Date> deviceHeartMap = new ConcurrentHashMap<>();

  /**
   * 服务器之间的通道映射
   * 服务名->channelId
   * 作用：
   */
  private static Map<String,String> serverMap = new ConcurrentHashMap<>();

  /**
   * 新增通道
   */
  public static void addChannelMap(String channelId,Channel channel){
    channelMap.put(channelId, channel);
  }

  /**
   * 删除通道
   */
  public static void deleteChannelMap(String channelId){
    channelMap.remove(channelId);
  }

  /**
   * 删除服务器与channelId的映射
   * 1、删除ServerMap
   * 2、删除channelMap
   */
  public static void deleteServerMapAndChannelMap(String channelId){
    Set<String> keys = serverMap.keySet();
    String serverName = null;
    String value = null;
    for (String key:keys) {
      value = serverMap.get(key);
      if(null!=value&&value.equals(channelId)){
        serverName=key;
      }
    }
    if(null!=serverName){
      serverMap.remove(serverName);
      channelMap.remove(channelId);
    }

  }


}
