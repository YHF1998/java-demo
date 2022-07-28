package com.getdream.demo.fanxing.d03;

class Student<T> {
    T name;

    public void show(T name) {
        System.out.println(name);
        System.out.println(this.name);
    }

    public void getName() {
        System.out.println(name);
    }
}
