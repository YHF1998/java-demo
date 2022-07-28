package com.getdream.demo.test.d01;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
//import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void testNegative() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Factorial.fact(-1);
            }
        });
    }

    @org.junit.jupiter.api.Test
    void fact() {
    }
}