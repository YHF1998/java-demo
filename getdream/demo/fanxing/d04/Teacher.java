package com.getdream.demo.fanxing.d04;

public class Teacher<T> implements Person<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
