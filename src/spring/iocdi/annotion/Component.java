package spring.iocdi.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangxiaolong
 * @date 2019/5/16 15:10
 * 组件注解
 * 凡是有此注解就注入BeanFactory中
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
  String value() default "";

}
