package com.getdream.demo.d2022052302;

public class Main {
    public static void main(String[] args) {
        Class cls1 = String.class;
        String s = "Hello";
        Class cls2 = s.getClass();
        boolean sameClass = cls1 == cls2; // true
        System.out.println(sameClass);
    }
}
