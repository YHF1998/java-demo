package com.getdream.demo.array.d01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 创建Map集合
        HashMap<String, String> map = new HashMap<>();

        // 添加数据
        map.put("邓超", "孙俪");
        map.put("李晨", "范冰冰");
        map.put("黄晓明", "杨颖");
        map.put("老干爹", "老干妈");

        // Map遍历方式一:键找值遍历
        // 1.获取所有的键
        Set<String> keySet = map.keySet();
        // 2.遍历获取每个键
        for (String key : keySet) {
            // 3.通过键获取值
            String value = map.get(key);
            System.out.println(key + " @@ " + value);
        }

        //
        //for (String value : map.values()) {
        //    System.out.println("值" + value);
        //}
        System.out.println(map.size());


        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}