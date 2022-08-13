package com.getdream.thread.unsafe;

//非线程安全demo
public class Unsafe {
    public static void main(String[] args) {
        Ticket tic = new Ticket();
        Ticket tic2 = new Ticket();

        Thread t1 = new Thread(tic, "t1");
        Thread t2 = new Thread(tic, "t2");
        Thread t3 = new Thread(tic, "t3");
        Thread t4 = new Thread(tic, "t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


//非线程安全抢票
class Ticket implements Runnable {

    private int ticketNums = 20;//票数
    boolean flag = true;//是否有票

    @Override
    public void run() {

        while (flag) {
            buy();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //方法体加synchronized 锁的是this
    private synchronized void buy() {

        if (ticketNums <= 0) {
            flag = false;
            return;
        }

        //模拟延时
        //try {
        //    Thread.sleep(100);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}

        //买票
        System.out.println(Thread.currentThread().getName() + "拿到第" + ticketNums--);
    }
}