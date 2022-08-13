package com.getdream.thread.daemon;

//守护线程
public class Daemon {

    public static void main(String[] args) {
        Thread t1 = new Thread(new God());
        Thread t2 = new Thread(new My());

        //t1 设置守护进程 t2用户进程
        t1.setDaemon(true);


        t1.start();
        t2.start();

    }
}


class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            //如果没有用户线程执行了，也就比用户线程多活一点点时间
            System.out.println("God 被设置为了守护线程，jvm不死，我即永生");
        }
    }
}


class My implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("user=>" + i);
        }
    }
}