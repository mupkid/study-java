package com.example.studyguava.collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author haoxian, ou
 * @date 2021/4/5 21:12
 */
public class MultimapTest {
    @Test
    void Test1() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("a", "123");
        multimap.put("a", "111");
        multimap.put("b", "456");
        multimap.put("b", "789");

        Multimap<String, String> multimap1 = LinkedListMultimap.create();
        multimap1.put("a", "a1_value");
        multimap1.put("k2", "k2_value");
        multimap.putAll(multimap1);

        List<String> list = Lists.newArrayList("a_value1", "a_value2", "a_value3");
        multimap.putAll("a", list);

        System.out.println(multimap);
        System.out.println(multimap.size());
        System.out.println(multimap.keySet().size());

        // 移除指定key的指定value
        multimap.remove("a", "111");
        System.out.println(multimap);
        // 移除整个key和所有value
        multimap.removeAll("a");
        System.out.println(multimap);

        // 是否包含指定的key
        System.out.println(multimap.containsKey("d"));
        // 是否包含指定的键值对
        System.out.println(multimap.containsEntry("d", "789"));
        // 获取multimap所有的value
        System.out.println(multimap.values());
        // 返回Multiset
        System.out.println(multimap.keys());
        // 返回Map类型
        Map<String, Collection<String>> map = multimap.asMap();
        System.out.println(map);

        // 清空集合
        multimap.clear();
        System.out.println(multimap);
    }
}
