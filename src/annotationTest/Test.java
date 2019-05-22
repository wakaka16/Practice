package annotationTest;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解测试
 */
@Documented//是否生成javadoc文档
@Retention(RetentionPolicy.RUNTIME)//注解生命周期:source编译时有效，class编译后有效，RUNTIME运行时有效
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Test {

  //只能是基本类型、枚举、String
  @AliasFor("value")
  String name() default "";

  @AliasFor("value")
  String value() default "";
}
