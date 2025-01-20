package com.studyDemo.thread.interruptThread;

/**
 * 停止线程的几种方式
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        // TODO: 2025/1/20  interrupt方式
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1);//暂停1毫秒
        //中断线程
        t.interrupt();
        


        // TODO: 2025/1/20 线程共享变量(volatile)方式 --实现Runnable接口 
        MyThread2 r = new MyThread2(); 
        Thread t2 = new Thread(r);
        Thread t4 = new Thread(r);
        t2.start();
        t4.start();
        Thread.sleep(10);//暂停10毫秒
        //停止线程
        r.running = false;

        // TODO: 2025/1/20 线程共享变量(volatile)方式 --继承Thread类
        MyThread3 t3 = new MyThread3();
        t3.start();
        Thread.sleep(1);//暂停
        t3.running = false; // 标志位置为false


        //等待线程结束
        t.join();
        t2.join();
        t3.join();
        t4.join();
    }
}



class MyThread extends Thread {
    public void run() {
        int n = 0;
        //isInterrupted方法是类Thread的方法，如果使用实现Runnable接口的方式写的类，是没有这个方法，需要注意
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " MyThread hello!");
        }
        System.out.println("MyThread 退出了!");
    }
}


class MyThread2 implements Runnable{
    
    //线程是否运行，默认运行。volatile 不限制是继承Thread还是实现Runnable接口，这两种方式都是能用volatile的
    //但是，其实用实现Runnable接口方式的话， 这个running参数，会控制所有用同一个实例拉起的线程,下面的结果会是两个线程一起停止的
    //        MyThread2 r = new MyThread2(); 
    //        Thread t2 = new Thread(r);
    //        Thread t4 = new Thread(r);
    //         r.running = false;
    public volatile  boolean running = true;
    
    @Override
    public void run() {
        int n = 0;
        while (this.running) {
            n ++;
            System.out.println(n + " MyThread2 hello!");
        }
        System.out.println("MyThread2 退出了!");
    }
}

class MyThread3 extends Thread {
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " MyThread3 hello!");
        }
        System.out.println("MyThread3 退出了!");
    }
}