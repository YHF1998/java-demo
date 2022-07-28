package com.getdream.demo.list.d03;

import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C");
        System.out.println(list.contains("C"));
        System.out.println(list.contains(new String("C")));
        System.out.println(list.indexOf("C"));
        System.out.println(list.indexOf(new String("C")));


        List<Person> list2 = List.of(new Person("A"), new Person("B"), new Person("C"));
        System.out.println(list2.contains(new Person("C")));
    }


}


class Person {
    public String name;

    public int age;

    public Person(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;

            return Objects.equals(this.name, p.name) && this.age == p.age;
        }
        return false;
    }
}
