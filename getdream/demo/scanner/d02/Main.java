package com.getdream.demo.scanner.d02;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("内容接收");

        if (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            System.out.println("内容：" + str);
        }


    }
}
