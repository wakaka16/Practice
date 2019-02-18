package enum_test;

import java.util.Calendar;

public class Test {

  public static void main(String[] args) {
    System.out.println(EnumTest.FAIL);
    System.out.println(EnumTest.FAIL.getCode());
    System.out.println(EnumTest.FAIL.getMessage());
    System.out.println(EnumTest.SUCCESS);
    EnumTest.FAIL.setMessage("hello");
    System.out.println(EnumTest._200);
//        new EnumTest("","");//私有private，不能访问，编译报错
    /**
     * FAIL：直接打印枚举名称
     * 0000001：打印code
     * 操作失败：打印message
     * SUCCESS：直接打印枚举名称
     * _200：直接打印枚举名称
     */
  }
}
