package com.getdream.gui.lesson01;

import java.awt.*;

public class ExDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setBounds(300, 400, 400, 300);
        frame.setBackground(Color.GREEN);

        //弄个表格布局,2行一列
        frame.setLayout(new GridLayout(2, 1));

        //四个面板
        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new GridLayout(2, 1));
        Panel p3 = new Panel(new BorderLayout());
        Panel p4 = new Panel(new GridLayout(2, 2));

        //上半部分
        p1.add(new Button("East-1"), BorderLayout.EAST);
        p1.add(new Button("West-1"), BorderLayout.WEST);
        p2.add(new Button("p2-btn-1"));
        p2.add(new Button("p2-btn-2"));
        p1.add(p2, BorderLayout.CENTER);

        frame.add(p1);

        //下半部分
        p3.add(new Button("East-1"), BorderLayout.EAST);
        p3.add(new Button("West-1"), BorderLayout.WEST);
        for (int i = 0; i < 4; i++) {
            p4.add(new Button("for-" + i));
        }
        p3.add(p4, BorderLayout.CENTER);

        frame.add(p3);


    }
}
