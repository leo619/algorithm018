## Queue介绍
基本上，一个队列就是一个先入先出（FIFO）的数据结构
Queue接口与List、Set同一级别，都是继承了Collection接口。LinkedList实现了Deque接口。
### 实现阻塞接口的
java.util.concurrent 中加入了 BlockingQueue 接口和五个阻塞队列类。它实质上就是一种带有一点扭曲的 FIFO 数据结构。不是立即从队列中添加或者删除元素，线程执行操作阻塞，直到有空间或者元素可用。
五个队列所提供的各有不同：
* ArrayBlockingQueue ：一个由数组支持的有界队列。
* LinkedBlockingQueue ：一个由链接节点支持的可选有界队列。
* PriorityBlockingQueue ：一个由优先级堆支持的无界优先级队列。
* DelayQueue ：一个由优先级堆支持的、基于时间的调度队列。
* SynchronousQueue ：一个利用 BlockingQueue 接口的简单聚集（rendezvous）机制。

### 主要方法
* add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
* remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
* element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
* offer       添加一个元素并返回true       如果队列已满，则返回false
* poll         移除并返问队列头部的元素    如果队列为空，则返回null
* peek       返回队列头部的元素             如果队列为空，则返回null
* put         添加一个元素                      如果队列满，则阻塞
* take        移除并返回队列头部的元素     如果队列为空，则阻塞

* remove、element、offer 、poll、peek 其实是属于Queue接口。 