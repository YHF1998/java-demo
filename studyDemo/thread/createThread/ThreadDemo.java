package com.studyDemo.thread.createThread;


/**
 * 两种创建线程方式
 * 1.继承Thread类
 * 2.实现Runnable接口
 * 
 * 两种方式都是需要重写 run方法
 * 
 * 两种方法的启动方式是不同的，1可以直接start(),2则是new Thread(类).start();
 * 
 * 但是还是推荐使用Runnable方式，因为这种更好
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new StudentThread();
        Runnable t2 = new StudentRunnableThread();
        
       
        
        //设置最高优先级（实际是否生效得看操作系统了，优先级参数，感觉没什么太大的用处）
        Thread t2Thread = new Thread(t2);
        t2Thread.setPriority(10);
       
        //不设置优先级直接运行
        //new Thread(t2).start();


        t1.start();
        t2Thread.start();
        
        //lambda 方式
        new Thread(()->{
            System.out.println("这是一个lambda方式线程");
        }).start();
        
        
    }
}


class StudentThread extends Thread{

    @Override
    public void run() {
        System.out.println("这是一个学生类继承方式线程");
    }
}

class StudentRunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("这是一个学生类实现接口方式线程");
    }
}
