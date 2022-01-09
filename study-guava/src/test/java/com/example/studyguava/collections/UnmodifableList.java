package com.example.studyguava.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author haoxian, ou
 * @date 2021/4/4 22:38
 */
public class UnmodifableList {

    @Test
    void Test1() {
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        // JDK提供的不可变集合
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        // guava的不可变集合
        ImmutableList<String> immutableList = ImmutableList.copyOf(list);
        list.add("d");
        // 报错UnsupportedOperationException
//        immutableList.add("d");
        System.out.println(list);
        System.out.println(unmodifiableList);
        System.out.println(immutableList);
    }

    @Test
    void Test2() {
        ImmutableList<String> immutableList = ImmutableList.of("a", "b", "c");
    }

    @Test
    void Test3() {
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        ImmutableList<String> immutableList = ImmutableList.<String>builder().addAll(list).add("d").build();
        System.out.println(immutableList);
    }

    @Test
    void Test4() {
        Set<String> immutableSortedSet = ImmutableSortedSet.of("d", "a", "c", "b", "d", "b");
        System.out.println(immutableSortedSet);
    }


}
