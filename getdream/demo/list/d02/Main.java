package com.getdream.demo.list.d02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 洗牌算法suffle可以随机交换List中的元素位置:
        Collections.shuffle(list);
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    /**
     * TODO: 找出从start到end的缺失的数字并返回
     */
    static int findMissingNumber(int start, int end, List<Integer> list) {
        for (int i2 = start; i2 <= end; i2++) {
            //boolean flag = true;
            //for (Integer integer : list) {
            //    if (integer.equals(i2)) {
            //        flag = false;
            //        break;
            //    }
            //}

            if (!list.contains(i2)){
                return i2;
            }

            //if (flag) {
            //    return i2;
            //}


        }

        return 0;

    }
}
