package com.getdream.thread.consumer02;


//测试生产者消费者问题：信号灯法，标志位解决


public class Test {
    public static void main(String[] args) {
        //创建缓冲区
        TV tv = new TV();

        //生产者
        Producer producer = new Producer(tv);
        //消费者
        Consumer consumer = new Consumer(tv);

        producer.start();
        consumer.start();
    }
}


//生产者-》电视台
class Producer extends Thread {
    TV tv;

    public Producer(TV tv) {
        this.tv = tv;
    }

    //生产
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("日本涩涩");
            } else {
                this.tv.play("国产涩涩");
            }
        }
    }
}

//消费者-》观众
class Consumer extends Thread {
    TV tv;

    public Consumer(TV tv) {
        this.tv = tv;
    }

    //消费
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            this.tv.watch();
        }
    }
}


//产品-》电视节目
class TV {
    //演员表演，观众等待
    //观众观看，演员等待
    String voice;//表演的节目
    boolean flag = true;

    //表演
    public synchronized void play(String voice) {
        if (!this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了：" + voice);
        //通知关注观看
        this.voice = voice;
        this.flag = !this.flag;
        this.notifyAll();
    }

    //观看
    public synchronized void watch() {
        if (this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //看完了，通知演员表演
        System.out.println("观看了：" + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }
}
