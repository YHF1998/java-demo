package com.getdream.demo.treeset.comparable;

import java.util.Comparator;

public class Student implements Comparable<Student> {

    Integer age;
    String name;

    public Student(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        int n1 = this.name.compareTo(o.name);
        int n2 = this.age - o.age;
        return n1 == 0 ? n2 : n1;
    }
}
