# synchronized 关键字的学习 Demo

## innerclassdemo1

本 Demo 测试同步代码块`synchronized(lock)`对 lock 上锁后，其他线程只能以同步的方式调用 lock 中的同步方法。

## syntwolock

本 Demo 验证 static synchronized 方法的锁和非 static synchronized 方法不是同一个锁。

## twoobjecttwolock

本 Demo 说明了

关键字`synchronized`取得的锁都是对象锁，而不是把一段代码或方法当作锁，哪个线程先执行带`synchronized`
关键字的方法，哪个线程就持有该方法所属对象的锁，那么其他线程只能处于等待状态，前提是多个线程访问的是同一个对象。但如果多个线程访问多个对象，也就是每个线程访问自己所属的业务对象（上面的示例就是这种情况），则JVM会创建多个锁，不存在锁争抢的情况。

另外，更具体地讲，由于本示例创建了两个业务对象，所以产生两份实例变量，每个线程访问自己的实例变量，所以加不加synchronized关键字都是线程安全的。

## synmoreobjectstaticonelock

验证class锁可以对类的所有对象实例起作用。

## synStaticMethod

静态同步方法与synchronized(class)代码块的使用

## synblockmoreobjectonelock

同步 synchronized(class) 代码块的作用其实和 synchronized static 方法的作用一样。

## sycblockstring

示例使用synchronized(非this对象)