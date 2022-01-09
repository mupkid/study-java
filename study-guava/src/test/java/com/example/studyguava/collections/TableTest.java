package com.example.studyguava.collections;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

/**
 * @author haoxian, ou
 * @date 2021/4/5 22:35
 */
public class TableTest {
    @Test
    void Test1() {
        // Map<K, Map<K,V>> => 行列值结构
        Table<String, String, Integer> table = HashBasedTable.create();
        table.put("a1", "c1", 23);
        table.put("a1", "c2", 77);
        table.put("a2", "c2", 44);
        System.out.println(table.row("a1"));
        System.out.println(table.column("c2"));
    }
}
