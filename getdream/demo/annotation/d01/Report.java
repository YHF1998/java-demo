package com.getdream.demo.annotation.d01;


import java.lang.annotation.*;

@Target(ElementType.METHOD)//定义使用的地方
@Retention(RetentionPolicy.RUNTIME)//定义注解的声明周期，当前选项是运行期 ，SOURCE是编译期，CLASS是仅在class文件
//@Repeatable(Person) //定义是否能在一个地方调用多次注解，修饰后即是允许
public @interface Report {
    int type() default 0;

    String level() default "info";

    String value() default "";
}
