package com.example.studyguava.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author haoxian, ou
 * @date 2021/4/6 21:34
 */
public class SetsTest {
    @Test
    public void setsCreate() {
        HashSet<String> set = Sets.newHashSet();
        Sets.newLinkedHashSet();
        Sets.newHashSetWithExpectedSize(10);
        Sets.newTreeSet();
        Sets.newConcurrentHashSet();
    }

    @Test
    public void cartesianProduct() {
        Set<String> set1 = Sets.newHashSet("a", "b", "c");
        Set<String> set2 = Sets.newHashSet("1", "2", "3");
        Set<String> set3 = Sets.newHashSet("@", "#", "&");
        //多个Set的笛卡尔集，参数接收多个set集合
        Set<List<String>> sets = Sets.cartesianProduct(set1, set2, set3);
        System.out.println(sets);

        List<Set<String>> list = Lists.newArrayList(set1, set2, set3);
        //也可以把多个Set集合，放到一个list中，再计算笛卡尔集
        Set<List<String>> sets1 = Sets.cartesianProduct(list);
        System.out.println(sets1);
    }

    @Test
    public void combinationsTest(){
        //Set<String> set = Sets.new("a","b","c","d");
        //
        //ImmutableSet immutableSet = ImmutableSet.of("a","b","c","d");
        //将集合中的元素按指定的大小分隔，指定大小的所有组合
        Set<String> set1 = Sets.newHashSet("a","b","c","d");
        Set<Set<String>> sets = Sets.combinations(set1,3);
        for(Set<String> set : sets){
            System.out.println(set);
        }
    }

    @Test
    public void differenceTest(){
        Set<String> set1 = Sets.newHashSet("a","b","d");
        Set<String> set2 = Sets.newHashSet("d","e","f");
        //difference返回：从set1中剔除两个set公共的元素
        System.out.println(Sets.difference(set1,set2));
        //symmetricDifference返回：剔除两个set公共的元素，再取两个集合的并集
        System.out.println(Sets.symmetricDifference(set1,set2));
    }

    @Test
    public void intersectionTest(){
        Set<String> set1 = Sets.newHashSet("a","b","c");
        Set<String> set2 = Sets.newHashSet("a","b","f");
        //取两个集合的交集
        System.out.println(Sets.intersection(set1,set2));
    }

    @Test
    public void filterTest(){
        Set<String> set1 = Sets.newHashSet("a","b","c");
        //建议可以直接使用java8的过滤，比较方便
        Set<String> set2 = Sets.filter(set1,str -> str.equalsIgnoreCase("b"));
        System.out.println(set2);
    }

    @Test
    public void powerSetTest(){
        Set<String> set1 = Sets.newHashSet("a","b","c");
        //获取set可分隔成的所有子集
        Set<Set<String>> allSet = Sets.powerSet(set1);
        for(Set<String> set : allSet){
            System.out.println(set);
        }
    }

    @Test
    public void unionTest(){
        Set<String> set1 = Sets.newHashSet("a","b","c");
        Set<String> set2 = Sets.newHashSet("1","2","3");
        //取两个集合的并集
        System.out.println(Sets.union(set1,set2));
    }
}
