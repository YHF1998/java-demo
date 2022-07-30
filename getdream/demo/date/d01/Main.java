package com.getdream.demo.date.d01;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);
        dt = dt.withHour(22);
        System.out.println(dt);

    }
}
