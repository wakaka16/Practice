package netty.UserDemo.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * netty协议发送信息对象
 */
public class SendPojo implements Serializable {

  //消息类型
  public static final int MESSAGE_TYPE_HEART=-2;
  public static final int MESSAGE_TYPE_LOGIN=-1;
  public static final int MESSAGE_TYPE_FONT=0;
  public static final int MESSAGE_TYPE_ATTACHMENT=1;
  public static final int MESSAGE_TYPE_PIC=2;
  public static final int MESSAGE_TYPE_VOICE=3;
  public static final int MESSAGE_TYPE_VIDEO=4;
  public static final int MESSAGE_TYPE_CUSTOMTAG=5;

  //消息标签
  public static final int SEND_TAG_SERVER=0;
  public static final int SEND_TAG_CLIENT=1;
  private static final long serialVersionUID = 5661965082300331345L;

  /**
   * 一、发送
   */
  //发送服务IP地址
  private String sendServerIp;
  //发送服务端口
  private Integer sendServerPort;
  //发送时间
  private Date sendTime = new Date();
  //发送用户名称（唯一）
  private String sendUserName;
  //消息发送设备信息
  private String sendDevice;
  //发送标签(0=服务器，1=客户端)
  private int sendTag;

  /**
   * 二、消息
   */
  //消息类型(心跳=-2、登录=-1、文字=0、附件=1、图片=2、语音=3、短视频=4、自定义标记=5)
  private int messageType;
  //消息id
  private String messageId;
  //用户ack的映射,messageId+userName+device
  private String ackMapping;
  //消息内容
  private String message;


  /**
   * 接收
   */
  //房间id
  private String roomId;
  //接收人
  private String receiveUserName;
  //接收设备
  private String receiveDevice;

  /**
   * 转发（InstantServerNode）
   */
  //转发服务IP地址
  private String forwardingIp;
  //转发服务端口
  private Integer forwardingPort;
  //转发服务的名称
  private String forwardingName;

  public String getSendServerIp() {
    return sendServerIp;
  }

  public SendPojo setSendServerIp(String sendServerIp) {
    this.sendServerIp = sendServerIp;
    return this;
  }

  public Integer getSendServerPort() {
    return sendServerPort;
  }

  public SendPojo setSendServerPort(Integer sendServerPort) {
    this.sendServerPort = sendServerPort;
    return this;
  }

  public Date getSendTime() {
    return sendTime;
  }

  public SendPojo setSendTime(Date sendTime) {
    this.sendTime = sendTime;
    return this;
  }

  public String getSendUserName() {
    return sendUserName;
  }

  public SendPojo setSendUserName(String sendUserName) {
    this.sendUserName = sendUserName;
    return this;
  }

  public String getSendDevice() {
    return sendDevice;
  }

  public SendPojo setSendDevice(String sendDevice) {
    this.sendDevice = sendDevice;
    return this;
  }

  public int getMessageType() {
    return messageType;
  }

  public SendPojo setMessageType(int messageType) {
    this.messageType = messageType;
    return this;
  }

  public int getSendTag() {
    return sendTag;
  }

  public void setSendTag(int sendTag) {
    this.sendTag = sendTag;
  }

  public String getMessageId() {
    return messageId;
  }

  public SendPojo setMessageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public SendPojo setMessage(String message) {
    this.message = message;
    return this;
  }

  public String getRoomId() {
    return roomId;
  }

  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }

  public String getReceiveUserName() {
    return receiveUserName;
  }

  public void setReceiveUserName(String receiveUserName) {
    this.receiveUserName = receiveUserName;
  }

  public String getReceiveDevice() {
    return receiveDevice;
  }

  public void setReceiveDevice(String receiveDevice) {
    this.receiveDevice = receiveDevice;
  }

  public String getForwardingIp() {
    return forwardingIp;
  }

  public SendPojo setForwardingIp(String forwardingIp) {
    this.forwardingIp = forwardingIp;
    return this;
  }

  public Integer getForwardingPort() {
    return forwardingPort;
  }

  public SendPojo setForwardingPort(Integer forwardingPort) {
    this.forwardingPort = forwardingPort;
    return this;
  }

  public String getForwardingName() {
    return forwardingName;
  }

  public SendPojo setForwardingName(String forwardingName) {
    this.forwardingName = forwardingName;
    return this;
  }

  public String getAckMapping() {
    return ackMapping;
  }

  public void setAckMapping(String ackMapping) {
    this.ackMapping = ackMapping;
  }

  @Override
  public String toString() {
    return "SendPojo{" +
        ", sendTag=" + sendTag +

        '}';
  }
}
