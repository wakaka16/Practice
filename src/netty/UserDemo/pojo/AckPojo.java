package netty.UserDemo.pojo;

import java.io.Serializable;

/**
 * netty协议响应信息对象
 */
public class AckPojo implements Serializable {

  //类型（0=失败，1=成功）
  public static final int ACKTYPE_FAIL = 0;
  public static final int ACKTYPE_SUCCESS = 1;
  //返回ack的标记（0=服务器，1=客户端）
  public static final int ACKTAG_SERVER = 0;
  public static final int ACKTAG_CILIENT = 1;
  private static final long serialVersionUID = -5967464994080426579L;

  /**
   * 类型（0=失败，1=成功）
   */
  private int ackType;

  /**
   * 返回ack的标记（0=服务器，1=客户端）
   */
  private int ackTag;

  /**
   * ackMapping
   */
  private String ackMapping;

  /**
   * ack错误内容
   */
  private String errorMessage;

  /**
   * 发送用户
   */
  private String sendUser;

  /**
   * 发送设备
   */
  private String sendDevice;

  /**
   * 接收ack目标用户
   */
  private String targetUser;

  /**
   * 接收ack目标设备
   */
  private String targetDevice;

  public int getAckType() {
    return ackType;
  }

  public AckPojo setAckType(int ackType) {
    this.ackType = ackType;
    return this;
  }

  public int getAckTag() {
    return ackTag;
  }

  public AckPojo setAckTag(int ackTag) {
    this.ackTag = ackTag;
    return this;
  }

  public String getAckMapping() {
    return ackMapping;
  }

  public void setAckMapping(String ackMapping) {
    this.ackMapping = ackMapping;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getSendUser() {
    return sendUser;
  }

  public AckPojo setSendUser(String sendUser) {
    this.sendUser = sendUser;
    return this;
  }

  public String getSendDevice() {
    return sendDevice;
  }

  public AckPojo setSendDevice(String sendDevice) {
    this.sendDevice = sendDevice;
    return this;
  }

  public String getTargetUser() {
    return targetUser;
  }

  public AckPojo setTargetUser(String targetUser) {
    this.targetUser = targetUser;
    return this;
  }

  public String getTargetDevice() {
    return targetDevice;
  }

  public AckPojo setTargetDevice(String targetDevice) {
    this.targetDevice = targetDevice;
    return this;
  }

  @Override
  public String toString() {
    return "AckPojo{" +
        "ackType=" + ackType +
        ", ackTag=" + ackTag +
        ", ackMapping='" + ackMapping + '\'' +
        ", errorMessage='" + errorMessage + '\'' +
        ", sendUser='" + sendUser + '\'' +
        ", sendDevice='" + sendDevice + '\'' +
        ", targetUser='" + targetUser + '\'' +
        ", targetDevice='" + targetDevice + '\'' +
        '}';
  }
}
