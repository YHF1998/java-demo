package com.getdream.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Lock {
    public static void main(String[] args) {
        TestLock tLock = new TestLock();


        new Thread(tLock).start();
        new Thread(tLock).start();
        new Thread(tLock).start();
        new Thread(tLock).start();
    }
}


class TestLock implements Runnable {


    int tickNums = 10;

    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            //加锁
            try {
                lock.lock();
                if (tickNums > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(tickNums--);
                } else {
                    break;
                }
            } finally {
                //解锁
                lock.unlock();
            }
        }
    }
}
