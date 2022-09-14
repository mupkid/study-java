# Future 和 Callable

使用`Future`和`Callable`可以从线程中返回数据以便后续处理，但是`get()`方法本身是阻塞的。

为了不阻塞程序，我们会使用`while(isDone())`的方式去轮询，但这又会白白浪费 CPU 资源。

## CompletionService

使用`CompletionService`可以解决`Future`的问题。

咋一看好像解决了，但好像也没有。

## CompletableFuture

我们希望`Future`完成后，能够主动通知父线程，而不是父线程去检查——即回调通知。

JDK 1.8 中提供了新的`Future`——`CompletableFuture`。

`CompletableFuture`不仅可以实现回调

### Demo1 和 Demo2

这两个 Demo 分别使用`runAsync`和`supplyAsync`来创建`CompletableFuture`，注意两者的区别。

### Demo3 和 Demo4

这两个 Demo 说明了两件事。

一是，`CompletableFuture`默认使用`ForkJoinPool.commonPool()`作为线程池来执行异步代码，这个线程池中的线程都是守护线程。

如果不给`CompletableFuture`自定义线程池，当主线程运行过快而结束，那么异步任务就算没有执行完也会跟着结束。

所以应该让`CompletableFuture`使用自定义线程池并手动关闭。

二是，展示了`CompletableFuture`的回调通知和异常处理，是个典型的代码模板。

### Demo5

`get()` `join()` `complete()` 的使用

### Demo6

`thenApply()` `handle()` 的使用，这两方法的区别在于对异常的处理。

### Demo7

`thenAccept()` 的使用

### Demo8

`thenRun()` 的使用

### Demo9

`thenApplyAsync()` `thenAcceptAsync()` `thenRunAsync()` 的线程池问题

### Demo10

`applyToEither()`的使用

### Demo11

`thenCombine()` 的使用

### e-commerce

本 Demo 展示一个电商比价的场景。

