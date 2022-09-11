# Object.wait() 与 Object.notify() 的学习 Demo

## waitnotifybase

Object.wait() 与 Object.notify() 的基本使用。

## waitold

在使用 wait/notify 模式时，还需要注意一种情况：如果 wait 条件发生变化，容易造成逻辑的混乱。

## oneproducerconsumer

使用wait/notify实现生产者/消费者模式：一生产一消费

## moreproducerconsumer

使用wait/notify实现生产者/消费者模式：多生产多消费

## moreproducerconsumercontinuousl

实现连续的生产或连续的消费

## crossinsert

实现创建20个线程，其中10个线程用于将数据备份到A数据库中，另外10个线程用于将数据备份到B数据库中，并且备份A数据库和B数据库是交叉的效果。
