package com.getdream.thread.deadLock;

//死锁:多个线程互相锁着对方需要的资源，形成僵持状态
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "灰姑凉");
        Makeup g2 = new Makeup(1, "后妈");

        new Thread(g1, "t1").start();
        new Thread(g2, "t2").start();
    }
}


//口红
class Lipstick {

}

//镜子
class Mirror {

}


class Makeup implements Runnable {

    //需要的资源只有一份，用static保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;//使用化妆品的人


    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        //化妆

        //存在死锁问题
        //makeup();
        //解决了死锁问题
        makeup2();
    }


    //化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得了口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror) {
                    System.out.println(this.girlName + "获得了镜子的锁");
                }
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.girlName + "获得了镜子的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick) {
                    System.out.println(this.girlName + "获得了口红的锁");
                }
            }
        }
    }

    //只需要把资源竞争依赖部分，移出来，变成平级调用，就能解决死锁的问题
    private void makeup2() {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得了口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //这里就是重点，子级改同级
            synchronized (mirror) {
                System.out.println(this.girlName + "获得了镜子的锁");
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.girlName + "获得了镜子的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //这里就是重点，子级改同级
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得了口红的锁");
            }
        }
    }
}


