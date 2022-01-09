package com.example.studyguava.collections;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

/**
 * @author haoxian, ou
 * @date 2021/4/6 21:39
 */
public class MapsTest {
    @Test
    public void createDemo(){
        Maps.newHashMap();
        Maps.newHashMapWithExpectedSize(10);
        //Maps.newEnumMap();
        Maps.newConcurrentMap();
        Maps.newIdentityHashMap();

        Maps.newLinkedHashMap();
        Maps.newLinkedHashMapWithExpectedSize(10);

        Maps.newTreeMap();
    }

    @Test
    public void asMapTest(){
        Set<String> set = Sets.newHashSet("a","b","c");
        //将set转成Map,key为set元素,value为每个元素的长度
        Map<String,Integer> map = Maps.asMap(set,String::length);
        System.out.println(map);
    }

    @Test
    public void differenceTest(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> map2 = Maps.newHashMap();
        map2.put("a","1");
        map2.put("e","5");
        map2.put("f","6");
        //mapDifference是将两个map相同的部分剔除
        MapDifference<String,String> mapDifference = Maps.difference(map1,map2);
        //两个Map相同的部分
        System.out.println(mapDifference.entriesInCommon());
        //左边集合剔除相同部分后的剩余
        System.out.println(mapDifference.entriesOnlyOnLeft());
        //右边集合剔除相同部分后的剩余
        System.out.println(mapDifference.entriesOnlyOnRight());
    }

    @Test
    public void filterEntriesTest(){
        Map<String,String> map = Maps.newHashMap();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        Map<String,String> result = Maps.filterEntries(map,item -> !item.getValue().equalsIgnoreCase("2"));
        System.out.println(result);

    }

    @Test
    public void filterKeysTest(){
        Map<String,String> map = Maps.newHashMap();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        Map<String,String> result = Maps.filterKeys(map, item -> !item.equalsIgnoreCase("b"));
        System.out.println(result);
    }

    @Test
    public void filterValuesTest(){
        Map<String,String> map = Maps.newHashMap();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        Map<String,String> result =  Maps.filterValues(map,item -> !item.equalsIgnoreCase("3"));
        System.out.println(result);
    }

    @Test
    public void transFormEntriesTest(){
        Map<String,String> map = Maps.newHashMap();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        Map<String,String> result = Maps.transformEntries(map,(k,v) -> k + v);
        System.out.println(result);
    }

    @Test
    public void transformValuesTest(){
        Map<String,String> map = Maps.newHashMap();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        Map<String,String> result = Maps.transformValues(map, value -> value + 10);
        System.out.println(result);
    }
}
