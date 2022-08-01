package com.getdream.gui.lesson01;

import java.awt.*;

public class TestFrame {
    public static void main(String[] args) {
        //Frame f = new Frame("第一个窗口demo");
        //
        ////设置可见性
        //f.setVisible(true);
        //
        ////设置宽高
        //f.setSize(400, 400);
        //
        ////设置颜色
        //f.setBackground(new Color(19, 59, 20));
        //
        ////弹出的初始值
        //f.setLocation(200, 200);
        //
        ////设置不允许调整窗口大小
        //f.setResizable(false);


        MyFrame f1 = new MyFrame(100, 100, 200, 200, Color.BLUE);
        MyFrame f2 = new MyFrame(150, 150, 200, 200, Color.YELLOW);
        MyFrame f3 = new MyFrame(200, 200, 200, 200, Color.GREEN);
        MyFrame f4 = new MyFrame(250, 250, 200, 200, Color.PINK);
    }
}


class MyFrame extends Frame {
    static int id = 0;//可能存在多个窗口，用于计数

    public MyFrame(int x, int y, int w, int h, Color color) {
        super("MyFrame" + (++id));
        setBackground(color);
        setBounds(x, y, w, h);
        setVisible(true);
    }
}