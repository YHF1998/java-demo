package com.getdream.demo.test.d03;

import java.util.Objects;

public class Student implements Cloneable {

    Integer age;
    String name;

    public Student(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age.equals(student.age) && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
