package com.getdream.gui.lesson01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Panel 可以看成是一个空间，但是不能单独存在
public class TestPanel {
    public static void main(String[] args) {
        Frame f = new Frame();

        //布局的概念
        Panel panel = new Panel();

        //设置布局
        f.setLayout(null);

        //设置坐标
        f.setBounds(300, 300, 500, 500);
        //设置背景色
        f.setBackground(Color.GREEN);

        //panel设置坐标，相当于frame 其实就是类似前端的div
        panel.setBounds(50, 50, 200, 200);
        panel.setBackground(new Color(0, 25, 254));

        //把panel加进去frame
        f.add(panel);

        //设置可见性
        f.setVisible(true);

        //监听事件，监听关闭窗口事件
        //使用适配器模式，选择性重写，这里选择性重写关闭窗口事件
        f.addWindowListener(new WindowAdapter() {
            //重写关闭事件
            @Override
            public void windowClosing(WindowEvent e) {
                //结束程序
                System.exit(0);
            }
        });
    }
}
