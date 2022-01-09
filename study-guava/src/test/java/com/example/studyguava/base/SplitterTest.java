package com.example.studyguava.base;

import com.google.common.base.Splitter;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/**
 * @author haoxian, ou
 * @date 2021/3/30 23:16
 */
public class SplitterTest {

    @Test
    void test1() {
        List<String> list = Splitter.on(",").splitToList("a,b,c,d");
        System.out.println(list);
    }

    @Test
    void test2() {
        Splitter.on(",").split("a,b,c,d").forEach(System.out::println);
    }

    @Test
    void test3() {
        // 过滤掉空字符串，但不包括空格
        List<String> list = Splitter.on(",").omitEmptyStrings().splitToList("a,b,, ,c,d");
        //输出：[a, b,  ,c, d]
        System.out.println("list:" + list);
    }

    @Test
    void test4() {
        //去掉字符串中的空格，再进行过滤空元素
        List<String> list = Splitter.on(",").omitEmptyStrings().trimResults().splitToList("a,b,, ,c,d");
        System.out.println("list:" + list); //输出 [a, b, c, d]
    }

    @Test
    void test5() {
        // limit表示最多把字符串分隔成多少份
        List<String> list = Splitter.on("#").omitEmptyStrings().trimResults().limit(2).splitToList("a#b#c#d");
        System.out.println("list:" + list);
    }

    @Test
    void test6() {
        //将字串还原成map，是Joiner的逆向操作，注意：字符串的格式必须满足“a:1#b:2”这种格式，格式不对会导致还原map失败
        Map<String,String> map = Splitter.on("#").omitEmptyStrings().trimResults().withKeyValueSeparator(":").split("a:1#b:2");
        System.out.println("map:" + map);
    }
}
