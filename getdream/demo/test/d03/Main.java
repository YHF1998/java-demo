package com.getdream.demo.test.d03;

public class Main {
    public static void main(String[] args) {
        Student p1 = new Student("张三", 20);
        Student p2 = null;
        try {
            p2 = (Student) p1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        p2.age = 33;

        System.out.println(p1.age);
    }
}
