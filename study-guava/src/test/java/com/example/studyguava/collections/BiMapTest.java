package com.example.studyguava.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author haoxian, ou
 * @date 2021/4/5 22:21
 */
public class BiMapTest {
    @Test
    void Test1() {
        // BiMap双向Map
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("a", "123");
        System.out.println(biMap);

        // 对键值进行反转
        System.out.println(biMap.inverse());

        // 视图将一个key映射到已经存在的值上，会抛异常
//        biMap.put("b", "123");

        // 强行将一个key映射到已经存在的值上，会将原来的key覆盖掉
        biMap.forcePut("b", "123");
        System.out.println(biMap);
    }
}
