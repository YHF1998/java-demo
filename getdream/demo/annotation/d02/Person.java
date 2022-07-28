package com.getdream.demo.annotation.d02;

import java.lang.reflect.Field;

public class Person {
    @Range(min = 1, max = 20)
    public String name;
    @Range(max = 10)
    public String city;

    public Person() {
        this.name = "张三";
        this.city = "广东";
    }

    public static void main(String[] args) {
        Person p = new Person();
        try {
            p.check(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
        // 遍历所有Field:
        for (Field field : person.getClass().getFields()) {
            // 获取Field定义的@Range:
            Range range = field.getAnnotation(Range.class);
            //System.out.println(range);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                Object value = field.get(person);
                //System.out.println(value);
                // 如果值是String:
                if (value instanceof String) {
                    //System.out.println(value);
                    String s = (String) value;
                    // 判断值是否满足@Range的min/max:
                    System.out.println(s.length());
                    System.out.println(range.min());
                    System.out.println(range.max());
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }
}
