package com.getdream.demo.array.d02;

import java.util.*;

public class HashMap1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("aa", 11);
        map.put("cc", 33);
        map.put("dd", 44);
        map.put("bb", 22);
        // 1.键找值
        // 1.1 获取所有的键
        Set<String> keySet = map.keySet();
        // 1.2 遍历获取每个键
        for (String key : keySet) {
            Integer value = map.get(key);
            System.out.println(key + " :: " + value);
        }


        //Collection collection = new ArrayList();
        //
        //collection.add("苹果");
        //collection.add("草莓");
        //
        //
        //Iterator it = collection.iterator();
        //while (it.hasNext()) {
        //    String str = (String) it.next();
        //    System.out.println(str);
        //    it.remove();
        //}
        //
        //
        //System.out.println(collection.size());

        List<String> list = new ArrayList<>();

        list.add(0, "陈");
        list.add("陈1");
        list.add("陈2");
        list.add("陈3");

        ListIterator<String> itList = list.listIterator();
        while (itList.hasNext()) {
            System.out.println(itList.nextIndex() + ":" + itList.next());
        }

        itList = list.listIterator();

        while (itList.hasNext()) {
            System.out.println(itList.nextIndex() + ":" + itList.next());
        }

    }
}
