package com.getdream.annotation.element;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Element {
    //注解可以显式赋值，如果没有默认值，我们就必须给注解赋值
    @Annotation1(name = "ceshi", schools = {"hhh"})
    public void test() {

    }

    //如果注解参数名是value并且只有一个参数，可以不用把参数名写出来就能赋值
    @Annotation2("sfdasdf")
    public void test2() {

    }
}

//定义注解在方法和类中使用
@Target({ElementType.TYPE, ElementType.METHOD})
//定义注解运行时有效
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation1 {
    //注解的参数：参数类型 + 参数名（）；
    String name() default "";

    int age() default 0;

    int id() default -1;//如果默认值如果为-1，代表不存在

    String[] schools() default {"测试1", "测试2"};
}

//定义注解在方法和类中使用
@Target({ElementType.TYPE, ElementType.METHOD})
//定义注解运行时有效
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation2 {
    //如果参数名是value并且只有一个参数，可以不用把参数名写出来就能赋值
    String value() default "";
}
