package com.getdream.annotation.element;

//元注解使用

//定义一个注解

import java.lang.annotation.*;

//Retention元注解：目前的参数RetentionPolicy.RUNTIME表示该Test注解的有效范围是运行时，也是最常用的参数值
@Retention(value = RetentionPolicy.RUNTIME)

//Target元注解：传递参数值，表示该注解作用在什么地方，目前是方法（method）和类（type）
@Target(value = {ElementType.METHOD, ElementType.TYPE})

//Documented：表示将注解生成到javadoc中
@Documented

//表示子类可以继承父类的Test注解
@Inherited
public @interface Test {
}
