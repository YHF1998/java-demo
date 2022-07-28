package com.getdream.demo.treeset.comparator;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        //创建集合，并指定比较规则
        TreeSet<Student> treeSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int n1 = o1.name.compareTo(o2.name);
                int n2 = o1.age - o2.age;
                return n1 == 0 ? n2 : n1;
            }
        });

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
