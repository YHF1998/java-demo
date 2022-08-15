package com.getdream.reflection.dynamic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态构建对象，通过反射实现/调用 类/方法/属性
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class cls = Class.forName("com.getdream.reflection.dynamic.User");

        //创建类的对象：调用Class对象的newInstance()方法
        //1)类必须有一个无参数的构造器
        //2)类构造器访问权限需要足够
        User user = (User) cls.newInstance();
        System.out.println(user);


        System.out.println("------------------分割线-------------------");
        //那如果没有建立无参的构造器呢？这时候用getDeclaredConstructor()
        Constructor constructor = cls.getDeclaredConstructor(String.class, Integer.class);
        User user2 = (User) constructor.newInstance("李磊", 19);
        System.out.println(user2);


        System.out.println("------------------分割线-------------------");
        User user3 = (User) constructor.newInstance("李磊02", 19);
        //通过反射获取一个方法
        Method method = cls.getDeclaredMethod("setName", String.class);
        //激活执行方法
        method.invoke(user3, "涩涩");
        System.out.println(user3.getName());

        //通过反射调用私有方法
        Method method1 = cls.getDeclaredMethod("say", String.class);
        //设置权限，允许调用
        method1.setAccessible(true);
        method1.invoke(user3, "通过私有方法说话了");


        System.out.println("------------------分割线-------------------");
        User user4 = (User) constructor.newInstance("李磊03", 19);
        //通过反射操作属性
        Field field = cls.getDeclaredField("age");
        //赋值
        field.set(user4, 20);
        System.out.println(user4.age);

        //通过反射操作私有属性
        Field field1 = cls.getDeclaredField("name");
        //设置权限，允许修改
        field1.setAccessible(true);
        //赋值
        field1.set(user4, "张亮");
        System.out.println(user4.getName());
    }

}


class Parent {
    public String sex;

    public Parent() {

    }
}

class User extends Parent {

    public Integer age;
    private String name;

    private User(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void say(String content) {
        System.out.println(this.name + content);
    }
}
