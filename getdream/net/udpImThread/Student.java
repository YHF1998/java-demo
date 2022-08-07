package com.getdream.net.udpImThread;

//学生
public class Student {
    public static void main(String[] args) {
        new Thread(new Sender(6666, "127.0.0.1", 8888)).start();
        new Thread(new Receive(7777, "老师")).start();
    }
}
