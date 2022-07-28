package com.getdream.demo.fanxing.d01;

import java.util.Arrays;

public class ArrayHelper {
    public static void main(String[] args) {
        String[] ss = ArrayHelper.asArray("a", "b", "c");
        Integer[] ns = ArrayHelper.asArray(1, 2, 3);
        System.out.println(Arrays.toString(ss));
        System.out.println(Arrays.toString(ns));
    }

    @SafeVarargs
    static <T> T[] asArray(T... objs) {
        return objs;
    }
}
