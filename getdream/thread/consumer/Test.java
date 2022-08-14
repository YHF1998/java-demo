package com.getdream.thread.consumer;


//生产者消费者模型--》利用缓冲区解决：管程法


import java.util.zip.CheckedInputStream;

public class Test {
    public static void main(String[] args) {
        //创建缓冲区
        SynContainer synContainer = new SynContainer();

        //生产者
        Producer producer = new Producer(synContainer);
        //消费者
        Consumer consumer = new Consumer(synContainer);

        producer.start();
        consumer.start();
    }
}


//生产者
class Producer extends Thread {
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    //生产
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                container.push(new Chicken(i));
                System.out.println("生产了" + i + "只鸡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    //消费
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("消费了-->" + container.pop().id + "只鸡");

        }
    }
}

//产品
class Chicken {
    int id;//产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer {

    //需要一个容器大小
    Chicken[] chickens = new Chicken[10];

    //容器计数器
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken) throws InterruptedException {
        //如果容器满了，需要等待消费者进行消费
        if (count == chickens.length) {
            //通知消费者消费，生产者等待
            this.wait();

        }

        //如果没有满，就继续增加产品
        chickens[count] = chicken;
        count++;

        //可以通知消费者消费了
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken pop() {
        //判断能否消费
        if (count == 0) {
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果可以消费
        count--;

        //吃完了通知生产者生产
        this.notifyAll();

        return chickens[count];
    }


}
