package com.example.studyguava.base;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author haoxian, ou
 * @date 2021/3/30 22:54
 */
public class JoinTest {

    @Test
    public void JoinTest1() {
        // Join可以连接list、数组中的元素
        String str = Joiner.on(",").join(Lists.newArrayList("a", "b", "c"));
        String str1 = Joiner.on("#").join(new String[]{"a", "b", "c"});

        System.out.println(str);
        System.out.println(str1);
    }

    @Test
    void JoinTest2() {
        // Join可以复用
        Joiner joiner = Joiner.on(",").skipNulls();
        String join = joiner.join(Lists.newArrayList("a", "b", "c"));
        String join1 = joiner.join(new String[]{"d", "e", "f"});

        System.out.println(join);
        System.out.println(join1);
    }

    @Test
    void JoinTest3() {
        // 指定第一个、第二个字符串，再跟list中的元素进行连接
        String str = Joiner.on("@").join("first", "second", Lists.newArrayList("a", "b", "c"));
        System.out.println(str);
    }

    @Test
    void JoinTest4() {
        // 跳过list中的空值，这里的空值是指null，并不包括空字符串
        String str = Joiner.on(",").skipNulls().join(Lists.newArrayList("a", "b", " ", null, "c", null));
        System.out.println(str);
    }

    @Test
    void JoinTest5() {
        // useForNull(str)用指定的字符串来替换空值
        String str = Joiner.on(",").useForNull("#").join(Lists.newArrayList("a", "b", " ", null, "c", null));
        System.out.println(str);
    }

    @Test
    void JoinTest6() {
        Map<String, String> map = Maps.newHashMap();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        // withKeyValueSeparator用:来连接map的key和value，再将连接好的key和value用逗号分隔
        String str = Joiner.on(",").withKeyValueSeparator(":").join(map);
        System.out.println(str);
    }

}
