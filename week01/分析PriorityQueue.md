## PriorityQueue介绍
PriorityQueue 并没有直接实现 Queue接口，而是通过继承 AbstractQueue 类来实现 Queue 接口一些方法，在 Java 定义中，PriorityQueue 是一个基于优先级的无界优先队列。

添加到 PriorityQueue 队列里面的元素都经过了排序处理，默认按照自然顺序，也可以通过 Comparator 接口进行自定义排序。

PriorityQueue 是采用树形结构来描述元素的存储，具体说是通过完全二叉树实现一个小顶堆，在物理存储方面，PriorityQueue 底层通过数组来实现元素的存储。

**使用heap （平衡二叉树)方式排序** 

## 源码分析
````

public class PriorityQueue<E> extends AbstractQueue<E>
    implements java.io.Serializable {
    
    /**默认容量为11*/
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
 
    /**队列容器*/
    transient Object[] queue;
 
    /**队列长度*/
    private int size = 0;
 
    /**比较器,为null使用自然排序*/
    private final Comparator<? super E> comparator;
 
    ......
}
````
### 属性
* queue 表示存放元素数组
* comparator 表示比较器
* size 长度

### 主要方法
* add offer 添加新元素 区别如果添加失败add抛出异常，offer不会。
````
public boolean offer(E e) {
    //不允许放入null元素
    if (e == null)
        throw new NullPointerException();
    modCount++;
    int i = size;
    if (i >= queue.length)
        //自动扩容
        grow(i + 1);
    size = i + 1;
    //队列原来为空，这是插入的第一个元素
    if (i == 0)
        queue[0] = e;
    else
        //调整
        siftUp(i, e);
    return true;
}
````
调整器
````
private void siftUpComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>) x;
    while (k > 0) {
        //parentNo = (nodeNo-1)/2
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        //默认自然排序，从小到大
        if (key.compareTo((E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = key;

````
* remote poll 删除。两者语义也完全相同，都是获取并删除队首元素，区别是当方法失败时前者抛出异常，后者返回null
````
public E poll() {
    if (size == 0)
        return null;
    int s = --size;
    modCount++;
    //0下标处的那个元素就是最小的那个
    E result = (E) queue[0];
    E x = (E) queue[s];
    queue[s] = null;
    if (s != 0)
        //调整
        siftDown(0, x);
    return result;
}
````
比较器
````
private void siftDownComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>)x;
    int half = size >>> 1;        // loop while a non-leaf
    while (k < half) {
        //首先找到左右孩子中较小的那个，记录到c里，并用child记录其下标
        int child = (k << 1) + 1;
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
            c = queue[child = right];
        if (key.compareTo((E) c) <= 0)
            break;
        queue[k] = c;//然后用c取代原来的值
        k = child;
    }
    queue[k] = key;
}

````
* peek 查看头部元素。实现和poll类似，但不删除元素。



