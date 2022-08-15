package com.getdream.reflection.runtimeClass;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//获取运行时类的结构
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //获取对象的Class
        Class cls = Class.forName("com.getdream.reflection.runtimeClass.User");

        //获得类的名字-长名称（包+类名）
        System.out.println(cls.getName());
        //获得类的名字-短名称（类名）
        System.out.println(cls.getSimpleName());

        System.out.println("------------------分割线-------------------");
        //获取类(包含父类)属性-所有的public属性
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }


        System.out.println("------------------分割线-------------------");
        //获取类属性-当前类(不包括父类)的private/protected/public
        Field[] fields2 = cls.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field);
        }

        System.out.println("------------------分割线-------------------");
        //获取类(包含父类)方法-所有的public
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("------------------分割线-------------------");
        //获取类(不包含父类)方法-所有的private/protected/public
        Method[] methods2 = cls.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }


        System.out.println("------------------分割线-------------------");
        //获取指定的方法
        Method setNameMethod = cls.getMethod("setName", String.class);
        Method getNameMethod = cls.getMethod("getName");
        System.out.println(setNameMethod);
        System.out.println(getNameMethod);


        System.out.println("------------------分割线-------------------");
        //获取类的构造器(不包含父类)-所有的public构造器
        Constructor[] constructors = cls.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("------------------分割线-------------------");
        //获取类的构造器(不包含父类)-所有的private/protected/public构造器
        Constructor[] constructors2 = cls.getDeclaredConstructors();
        for (Constructor constructor : constructors2) {
            System.out.println(constructor);
        }

        System.out.println("------------------分割线-------------------");
        //获取指定构造器-方面里面的参数类型，匹配对应的构造器
        Constructor constructor = cls.getDeclaredConstructor(String.class, Integer.class);
        System.out.println(constructor);

        System.out.println("------------------分割线-------------------");
        //实例化类
        User user = (User) constructor.newInstance("李明", 10);
        System.out.println(user);

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
}
