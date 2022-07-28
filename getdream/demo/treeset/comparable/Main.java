package com.getdream.demo.treeset.comparable;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        //创建集合，并指定比较规则
        TreeSet<Student> treeSet = new TreeSet<>();

        Student p1 = new Student("张三", 10);
        treeSet.add(p1);
        treeSet.add(new Student("张三", 10));
        treeSet.add(new Student("李四", 20));

        System.out.println(treeSet.size());
        for (Student student : treeSet) {
            System.out.println(student.name + student.age);
        }
    }
}
