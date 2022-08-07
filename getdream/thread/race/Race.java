package com.getdream.thread.race;

//龟兔赛跑
public class Race implements Runnable {

    //胜利者
    public static String winner;

    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {

            //模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean flag = gameOver(i);
            if (flag) {
                break;
            }

            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }


    }

    /**
     * 判断比赛是否结束
     *
     * @param steps
     * @return
     */
    public boolean gameOver(int steps) {

        if (winner != null) {
            return true;
        }


        if (steps == 100) {
            //获取胜利者
            winner = Thread.currentThread().getName();
            System.out.println("胜利者是：" + winner);
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
