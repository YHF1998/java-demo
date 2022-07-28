package com.getdream.demo.scanner.d01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //创建一个scanner对象
        Scanner scanner = new Scanner(System.in);

        System.out.println("使用next方式接收");

        //判断用户有没有输入字符串
        if (scanner.hasNext()) {
            //使用next方式接收，如果存在空格，空格后面的内容会被过滤
            String str = scanner.next();
            System.out.println("输出的内容为：" + str);
        }

        //关闭资源，不然导致资源占用
        scanner.close();
    }
}
