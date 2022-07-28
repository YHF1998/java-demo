//通过反射 执行方法
package com.getdream.demo.reflection.d03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        //声明字符串
        String s = "sadfasdfsa sadfasdfa";
        //s.substring();
        //获取class
        Class sc = s.getClass();
        try {
            //获取方法
            Method m = sc.getMethod("substring", int.class, int.class);

            //在s对象上调用该方法并获取结果
            String r = (String) m.invoke(s, 6, s.length());
            //打印调用结果
            System.out.println(r);
        } catch (Exception e) {
            System.out.println("报错");
            System.out.println(e.getMessage());
        }


        //反射射获取构造方法
        try {
            Constructor obj = String.class.getConstructor(String.class);
            //实例化
            String ss = (String) obj.newInstance("测试");
            System.out.println(ss);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //通过反射获取父类
        Class i = Integer.class;
        Class n = i.getSuperclass();
        System.out.println(n);
        //再次获取n的父类
        Class o = n.getSuperclass();
        System.out.println(o);
        //再获取o的父类
        System.out.println(o.getSuperclass());

        CharSequence cs = new StringBuilder();

    }
}
