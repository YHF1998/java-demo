package com.getdream.demo.test.d01;

import org.junit.jupiter.api.*;

public class AAATest {


    void assertEquals(int i, int val) {
        if (i == val) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }


    @Test
    void fact() {
        assertEquals(1, AAA.fact(1));
        assertEquals(2, AAA.fact(2));
        assertEquals(3, AAA.fact(3));
        assertEquals(10, AAA.fact(10));
        assertEquals(20, AAA.fact(20));
    }
}
