package com.getdream.demo.thread.d01;

public class Main {
    public static void main(String[] args) {
        System.out.println("main start...");
        Thread t = new Thread(() -> {
            System.out.println("thread run...");
            System.out.println("thread end.");
        });
        t.start();
        System.out.println("main end...");
    }
}
