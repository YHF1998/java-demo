package com.getdream.demo.list.d01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(null);
        list.add(3);
        //list.remove(2);

        System.out.println(list.get(2));
        System.out.println(list);

        for (Integer integer : list) {
            System.out.println(integer);
        }

        String[] list2 = {"arfassdfads", "sdafsadfasd"};
        for (String s : list2) {
            System.out.println(s);
        }
    }
}
