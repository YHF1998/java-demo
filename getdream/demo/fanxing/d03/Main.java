package com.getdream.demo.fanxing.d03;

public class Main {
    public static void main(String[] args) {
        Student<String> str = new Student<>();

        str.name = "人人人";
        str.show("测试一下");
        str.getName();


        Integer i = 111;
        //Integer i = Integer.valueOf(111);

        System.out.println(i.equals(111));
    }
}


