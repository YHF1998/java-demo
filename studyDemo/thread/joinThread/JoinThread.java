package com.studyDemo.thread.joinThread;


/**
 * 等待某个线程结束才继续运行
 */
public class JoinThread {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("main主线程开始");
        Thread t1 = new Thread(() -> {
            int num = 0;
            while (true) {
                num++;
                if (num < 100) {
                    System.out.println("这是线程内部" + num);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        });

        System.out.println("子线程启动");
        //启动线程
        t1.start();
        
        //等待线程结束
        // 此处main线程会等待t结束
        //t1.join();
        //如果添加参数，那么会等待这么长时间（子线程还在继续运行，没有停止的情况下），然后继续向下执行
        t1.join(100);
        
        System.out.println("即将结束main主线程");
    }
}


