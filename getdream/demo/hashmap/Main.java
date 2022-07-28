package com.getdream.demo.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashMap<Student, String> stus = new HashMap<>();
        Student p1 = new Student("A", 18);
        Student p2 = new Student("B", 18);
        Student p3 = new Student("C", 18);
        stus.put(p1, "AVal");
        stus.put(p2, "BVal");
        stus.put(p3, "CVal");

        //看这行，在没用重写hashcode和equals，是不会认为是同一个key的
        stus.put(new Student("A", 18), "Asdfasdf");

        System.out.println(stus.size());

        //方式一
        for (Student student : stus.keySet()) {
            System.out.println(student.name + "======" + stus.get(student));
        }
        System.out.println("分割线=========================");
        //方式二
        for (Map.Entry<Student, String> studentStringEntry : stus.entrySet()) {
            System.out.println(studentStringEntry.getKey().name + "======" + studentStringEntry.getValue());
        }
    }
}
