# suspend() 和 resume() 的 Demo

## suspendresumedeallock

本 Demo 使用`suspend()`与`resume()`造成死锁。

如果`suspend()`与`resume()`使用不当，极易造成公共同步对象被独占，其他线程无法访问公共同步对象的结果。

## suspendresumenosamevalue

在使用`suspend()`与`resume()`时也容易出现线程暂停，进而导致数据不完整的情况。