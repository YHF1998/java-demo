package com.getdream.thread.priority;


//优先级
public class Priority {
    public static void main(String[] args) {

        MyPriority my = new MyPriority();

        Thread t1 = new Thread(my, "t1");
        Thread t2 = new Thread(my, "t2");
        Thread t3 = new Thread(my, "t3");
        Thread t4 = new Thread(my, "t4");


        //输出主线程名字和线程优先级
        System.out.println(Thread.currentThread().getName() + "====" + Thread.currentThread().getPriority());


        //设置启动优先级，数字越大，优先级越高 范围1-10
        t1.setPriority(1);
        t1.start();

        t2.setPriority(4);
        t2.start();

        t3.setPriority(8);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

        //一般设置优先级高的会先跑，但不是一定的
    }
}


class MyPriority implements Runnable {

    @Override
    public void run() {
        //输出线程名字和线程优先级
        System.out.println(Thread.currentThread().getName() + "====" + Thread.currentThread().getPriority());
    }
}