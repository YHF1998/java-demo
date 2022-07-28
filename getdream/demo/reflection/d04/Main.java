package com.getdream.demo.reflection.d04;

public class Main {
    public static void main(String[] args) {
        Hello he = new HelloWorld();
        he.morning("黑恶");
    }
}


class HelloWorld implements Hello {
    public void morning(String name) {
        System.out.println("morning" + name);
    }
}

interface Hello {
    void morning(String name);
}
