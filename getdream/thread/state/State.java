package com.getdream.thread.state;

public class State {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i % 10 == 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        System.out.println(t1.getState());


        t1.start();

        Thread.State status = t1.getState();

        System.out.println(status);


        while (status != Thread.State.TERMINATED) {//只要线程不终止，就一直输出状态
            Thread.sleep(100);
            status = t1.getState();//获取线程最新状态

            System.out.println(status);//输出状态
        }

    }
}
