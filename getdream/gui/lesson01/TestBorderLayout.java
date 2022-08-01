package com.getdream.gui.lesson01;

import java.awt.*;

public class TestBorderLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("TestBorderLayout");


        Button button = new Button("dong");
        Button button2 = new Button("xi");
        Button button3 = new Button("nan");
        Button button4 = new Button("bei");
        Button button5 = new Button("zhong");


        frame.setBackground(Color.GREEN);
        frame.setBounds(300, 400, 400, 400);
        frame.setVisible(true);

        //设置布局
        frame.setLayout(new BorderLayout());

        //设置布局
        frame.add(button, BorderLayout.EAST);
        frame.add(button2, BorderLayout.WEST);
        frame.add(button3, BorderLayout.SOUTH);
        frame.add(button4, BorderLayout.NORTH);
        frame.add(button5, BorderLayout.CENTER);

    }
}
