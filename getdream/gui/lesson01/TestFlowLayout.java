package com.getdream.gui.lesson01;

import java.awt.*;

public class TestFlowLayout {
    public static void main(String[] args) {
        Frame f = new Frame();


        //组件-按钮
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");


        //设置布局为流式布局
        //f.setLayout(new FlowLayout());
        //设置布局为流式布局-左浮动
        f.setLayout(new FlowLayout(FlowLayout.LEFT));

        f.add(button1);
        f.add(button2);
        f.add(button3);

        f.setBackground(Color.GREEN);
        f.setBounds(200, 200, 200, 200);
        f.setVisible(true);


    }
}
