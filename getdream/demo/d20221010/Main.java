package com.getdream.demo.d20221010;

public class Main {
    public static void main(String[] args) {

        Integer a = 1;
        Integer b = 2;
        Integer c = 129;
        Integer d = 129;
        Integer e = 32;
        Integer f = 32;
        Long g = 3L;
        Long h = 2L;



        System.out.println(c==d);
        //128陷阱 -128~127是存在同一个地址，128开始是存在两个地址所以大于127 使用 == 时，根据赋值的自动装箱，是两个不相同的类，所以是不相等的
        System.out.println(e==f);
        System.out.println(e.equals(f));
        //System.out.println(c==(a+b));
        //System.out.println(c.equals(a+b));
        //System.out.println(g==(a+b));
        //a+b中a和b都是Integer类型，会先触发自动拆箱，变成int类型。然后触发自动装箱，变成Integer类型。类型不一样false
        //System.out.println(g.equals(a+b));
        //System.out.println(g.equals(a+h));
    }
}


class Test {
    public class TestA{
        public String name = "陈";
        final public static String name2 = "陈2";

        public TestA() {
        }
        
        public String getName(){
            return name;
        }
    }
}