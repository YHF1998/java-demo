package com.getdream.lambda.demo;

public class Demo {
    public static void main(String[] args) {
        ILike like = () -> {
            System.out.println("dfasdf");
        };

        like.lambda();
    }
}


interface ILike {
    void lambda();
}

class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}