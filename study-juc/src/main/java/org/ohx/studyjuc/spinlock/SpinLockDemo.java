package org.ohx.studyjuc.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 根据CAS的思想自行实现一个自旋锁
 *
 * @author mudkip
 * @date 2022/7/7
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();


}
