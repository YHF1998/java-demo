package com.getdream.demo.fanxing.d04;

public class Student implements Person<String> {

    @Override
    public void show(String s) {
        System.out.println(s);
    }


    public <E> E cece(E e) {
        System.out.println("泛型方法" + e);
        return e;
    }
}
