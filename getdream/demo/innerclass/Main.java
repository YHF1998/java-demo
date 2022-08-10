package com.getdream.demo.innerclass;


//内部类demo
public class Main {
    public static void main(String[] args) {
        new T().new T1().new T2().hh();
    }
    
    
  
}


class T{
    class T1{
        class T2{
            public void hh(){
                System.out.println("hhhh");
            }
        }
    }
}
