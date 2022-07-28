package com.getdream.demo.list;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "测试");
        map1.put("b", "测试2");
        map1.put("c", "测试3");

        for (String k : map1.keySet()) {
            String val = map1.get(k);
            System.out.println(val);
        }

        for (String value : map1.values()) {
            System.out.println(value);
        }

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String val2 = entry.getValue();
            System.out.println(key + "=" + val2);
        }
    }
}
