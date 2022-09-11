# Exchanger

类`Exchanger`的功能可以使2个线程之间传输数据，它比生产者/消费者模式使用的 wait/notify 要更加方便。所以在本节将介绍使用此类在2个线程之间传递任意数据类型的数据，Exchanger类的使用与结构相当简单，主要的学习点就是exchange（）方法。