package com.getdream.net.udpImThread;


//老师
public class Teacher {
    public static void main(String[] args) {
        new Thread(new Sender(5555, "127.0.0.1", 7777)).start();
        new Thread(new Receive(8888, "学生")).start();
    }
}
