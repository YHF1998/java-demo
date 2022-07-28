package com.getdream.demo.match.d01;

public class Main {
    public static void main(String[] args) {
        //String re1 = "abc";
        String re2 = "java.*";
        //String ma = "a&&c";
        System.out.println("javac".matches(re2));
        System.out.println("java8".matches(re2));
        System.out.println("java88".matches(re2));
        System.out.println("java_".matches(re2));
        System.out.println("java".matches(re2));
    }
}
