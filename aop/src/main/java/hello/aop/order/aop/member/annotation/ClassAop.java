package hello.aop.order.aop.member.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // class에 붙이는 annotation
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassAop {
}
