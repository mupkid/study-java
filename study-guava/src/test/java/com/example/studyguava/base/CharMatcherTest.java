package com.example.studyguava.base;

import com.google.common.base.CharMatcher;
import org.junit.jupiter.api.Test;

/**
 * @author haoxian, ou
 * @date 2021/3/30 23:30
 */
public class CharMatcherTest {

    @Test
    void Test1() {
        String s = "er 3j6o  3k  ,)$ wt@ wr4576je  ow3453535345irjew jwfel ";
        // 返回只保留a-z的字母的字符中
        String str = CharMatcher.inRange('a','z').retainFrom(s);
        System.out.println(str);
    }

    @Test
    void Test2() {
        String s = "er 3j6o  3k  ,)$ wt@ wr4576je  ow3453535345irjew jwfel ";
        // 去掉字符串中数字
        // String str = CharMatcher.digit().removeFrom(s);
        String str = CharMatcher.inRange('1', '9').removeFrom(s);
        System.out.println(str);
    }
}
