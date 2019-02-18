package test;

import demo.FooTest;

import java.util.Date;

/**
 * @Description: 测试包的作用
 * @Author: wangXiaoLong
 * @CreateDate: 2018/9/7 19:00
 * @UpdateUser: wangXiaoLong
 * @UpdateDate: 2018/9/7 19:00
 * @UpdateRemark: 修改内容
 */
public class PackgeTest {

  private CharTest charTest;//同一个包引用，不需要导包
  private FooTest fooTest;//非同一个包引用，需要导包
}
