package com.getdream.demo.map.d02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        //添加元素
        map.put("A", new Student("张三", 20));
        map.put("B", new Student("李四", 18));
        map.put("C", new Student("测试", 20));
        map.put("A", new Student("张三", 20));

        System.out.println(map.size());

        //使用keySet()获取map的key的set集合，进行遍历
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + "----------" + map.get(key).name);

        }

        System.out.println("分割线============================================");

        //使用entrySet()获取它的包含键值对的item
        Set<Map.Entry<String, Student>> entryItemList = map.entrySet();
        for (Map.Entry<String, Student> studentMap : entryItemList) {
            System.out.println(studentMap.getKey() + "----------" + studentMap.getValue().name);
        }

    }
}
