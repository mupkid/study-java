package com.example.studyguava.collections;

import com.google.common.collect.*;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author haoxian, ou
 * @date 2021/4/5 17:29
 */
public class MultisetTest {
    @Test
    void Test1() {
        long start = System.currentTimeMillis();
        List<String> list = Lists.newArrayList("a", "b", "c", "d", "e", "b", "b");
        Map<String, Integer> countMap = Maps.newHashMap();
        for (String s : list) {
            countMap.merge(s, 1, Integer::sum);
        }
        System.out.println(countMap);
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
    }

    @Test
    void Test2() {
        // Mutiset可以看成是ArrayList和Map的集合体
        // Mutiset是没有元素限制的ArrayList
        // Mutiset提供了键为元素，值为计数的Map
        long start = System.currentTimeMillis();

        HashMultiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("d");
        multiset.add("e");
        multiset.add("b");
        multiset.add("b");

        // 获取multiset所有元素的个数
        System.out.println("multiset size: " + multiset.size());
        // 获取元素"b"的计数
        System.out.println("count b: " + multiset.count("b"));
        // 返回去重后的set集合
        Set<String> set = multiset.elementSet();
        // 去重后的元素个数
        System.out.println("set size: " + set.size());
        // 有迭代器，可以使用增强for
        for (String s : multiset) {
            System.out.println(s);
        }
        System.out.println(multiset);

        // 可以通过设置元素的计数，求批量添加元素，当然能加也能减
        multiset.setCount("c", 5);
        // 将元素的计数设为0，就相当于移除所有该元素
        multiset.setCount("c", 0);
        // 移除一个元素
        multiset.remove("e");
        // 移除两个元素
        multiset.remove("b", 2);

        System.out.println(multiset);

        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
    }

    @Test
    void Test3() {
        // SortedMultiset支持高效地获取指定范围的子集
        // SortedMultiset默认是排好序的，是按元素来进行排序的而不是元素的个数
        SortedMultiset<String> sortedMultiset = TreeMultiset.create();
        sortedMultiset.setCount("c", 5);
        sortedMultiset.setCount("a", 3);
        sortedMultiset.setCount("b", 2);
        // 获取第一个元素
        sortedMultiset.firstEntry().getElement();
        // 获取最后一个元素
        sortedMultiset.lastEntry().getElement();
        // 获取子集
        SortedMultiset<String> subMultiset = sortedMultiset.subMultiset("a", BoundType.OPEN, "b", BoundType.CLOSED);
        System.out.println(sortedMultiset);
        System.out.println(subMultiset);
    }
}
