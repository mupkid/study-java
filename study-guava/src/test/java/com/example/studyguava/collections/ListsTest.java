package com.example.studyguava.collections;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author haoxian, ou
 * @date 2021/4/6 21:27
 */
public class ListsTest {
    @Test
    void Test1() {
        // 将数组转成list,并在开头位置插入元素
        List<String> list = Lists.asList("a", new String[]{"b", "c", "d"});
        List<String> list1 = Lists.asList("a", "b", new String[]{"c", "d", "e"});

        // 直接创建ArrayList
        ArrayList<String> arrayList = Lists.newArrayList();
        // 创建ArrayList,并初始化
        ArrayList<String> arrayList1 = Lists.newArrayList("a", "b", "c");
        // 基于现有的arrayList,创建一个arrayList
        ArrayList<String> arrayList2 = Lists.newArrayList(arrayList1);
        // 初始化指定容量大小的ArrayList，其中容量指ArrayList底层依赖的数组的length属性值，常用于提前知道ArrayList大小的情况的初始化
        ArrayList<String> arrayList3 = Lists.newArrayListWithCapacity(10);
        // 初始化预定容量大小的ArrayList，返回的list的实际容量为5L + estimatedSize + (estimatedSize / 10)，常用于不确定ArrayList大小的情况的初始化
        ArrayList<String> arrayList4 = Lists.newArrayListWithExpectedSize(20);
        // 创建CopyOnWriteArrayList
        CopyOnWriteArrayList<String> copyOnWriteArrayList = Lists.newCopyOnWriteArrayList();
        // 创建linkedList
        LinkedList<String> linkedList = Lists.newLinkedList();
    }

    @Test
    public void partitionTest() {
        List<String> list = Lists.newArrayList("a", "b", "c", "d", "e");
        //将list按大小为2分隔成多个list
        List<List<String>> splitList = Lists.partition(list, 2);
        System.out.println(splitList);

    }

    @Test
    public void cartesianProcustTest() {
        List<String> list1 = Lists.newArrayList("a", "b", "c");
        List<String> list2 = Lists.newArrayList("d", "e", "f");
        List<String> list3 = Lists.newArrayList("1", "2", "3");
        //获取多个list的笛卡尔集
        List<List<String>> list = Lists.cartesianProduct(list1, list2, list3);
        System.out.println(list);
    }

    @Test
    public void charactersOfTest() {
        //将字符串转成字符集合
        ImmutableList<Character> list = Lists.charactersOf("ababcdfb");
        System.out.println(list);
    }

    @Test
    public void reverseTest() {
        List<String> list = Lists.newArrayList("a", "b", "c", "1", "2", "3");
        //反转list
        List<String> reverseList = Lists.reverse(list);
        System.out.println(reverseList);
    }

    @Test
    public void transFormTest() {
        List<String> list = Lists.newArrayList("a", "b", "c");
        //把list中的每个元素拼接一个1
        List<String> list1 = Lists.transform(list, str -> str + "1");
        // List<String> list1 = list.stream().map(str -> str + "1").collect(Collectors.toList());
        System.out.println(list1);
    }


    @Test
    public void transFormTest2() {
        People people1 = new People("a", 18);
        People people2 = new People("b", 12);
        List<People> lists = Lists.newArrayList(people1, people2);
        List<String> transform = Lists.transform(lists, new Function<People, String>() {
            @Override
            public @Nullable String apply(@Nullable People input) {
                assert input != null;
                return input.name;
            }
        });
//        List<String> transform = lists.stream().map(input -> input.name).collect(Collectors.toList());
        System.out.println(transform);
    }

    class People {
        String name;
        int age;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }
}
