package com.studyDemo.thread.daemon;

/**
 * 守护线程
 */
public class DaemonThread {
    public static void main(String[] args) {
        // 创建一个守护线程
        Thread daemonThread = new Thread(new DaemonTask());
        // 将线程设置为守护线程
        daemonThread.setDaemon(true);
        // 启动守护线程
        daemonThread.start();

        // 主线程执行一段时间后结束
        try {
            Thread.sleep(5000); // 主线程休眠5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread is finished.");
    
    }
}
class DaemonTask implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Daemon thread is running.");
            try {
                Thread.sleep(1000); // 守护线程休眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}