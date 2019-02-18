package enum_test;

/**
 * 枚举，定义测试
 *
 * 仅定义成功和失败两个结果，
 * code仅提供get方法，
 * message提供get、set方法
 * 构造默认私有
 * 不能对code和message进行设置
 */

/**
 * 枚举就是比普通类多一类成员
 * 并且一类成员通过构造函数复制
 * 一类成员可以调用二类成员（普通类通过实例、类名调用成员）
 * 枚举默认构造私有，所以不能实例化
 */
public enum EnumTest implements Des{

  //一类成员
  SUCCESS("000000", "操作正常"){
    //接口实现二
    public void info() {

  }},
  FAIL("0000001", "操作失败"){
    public void info() {

  }},
  _200("200", "操作成功"){
    public void info() {

    }
  };
//  public static  final EnumTest TE= new EnumTest("15156","4449");
  //二类成员
  private String code;
  private String message;
  //三类成员
  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  EnumTest(String code, String message){
    this.code = code;
    this.message = message;
  }
//实现接口方式一
//  @Override
//  public void info() {
//
//  }
}
