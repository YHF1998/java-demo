package com.getdream.gui.lesson01;

import java.awt.*;

public class TestGridLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        Button btn4 = new Button("btn4");
        Button btn5 = new Button("btn5");

        frame.setBounds(400, 400, 400, 400);
        frame.setBackground(Color.GREEN);
        frame.setVisible(true);

        //表格布局 3行两列
        frame.setLayout(new GridLayout(3, 2));

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);

        //自动填充，会按表格方式的顺序进行排列
        frame.pack();
    }
}
