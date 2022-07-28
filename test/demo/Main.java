package com.test.demo;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //for (int i = 0; i < 100; i++) {
        //    System.out.println(Math.random());
        //}

        Random randX = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(randX.nextInt(100) + 10);
        }
    }
}
