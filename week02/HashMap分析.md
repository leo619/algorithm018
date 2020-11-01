## Hash表
Hash表也称为散列表。 Hash表是一种根据关键字 key - value 而直接访问的数据结构。
也就是它通过把关键码值映射到表中的一个位置来访问记录，以此来加快查找速度。在链表、数组等数据结构中，查找某个关键字，通常都是遍历整个
数据结构，也就是O(N)的时间级，但是对于Hash表来说，只有O（1）的时间。

key值1、key值2.. ->散列函数 -> 散列表

## Hash碰撞（冲突）的解决办法

*   开放地址法
    
*   链地址法 （HashMap 采用这种）
    在相同的Hash散列表后添加子链表。  

## HashMap
HashMap 是一个利用Hash表原理来存储元素的集合。遇到Hash碰撞时，HashMap是采用链地址法来解决，在JDK1.7中，HashMap是数组+链表构成。但
JDK1.8开始，是由数组+链表+红黑树构成，新增了红黑树作为底层数据结构，结构变得复杂了，但是效率变得更加高效。

## HashMap 特点
* 基于JDK1.8的HashMap 是有数组 + 链表 + 红黑树组成，当链表长度超过8的时候会自动转成红黑树，当红黑树节点的个数小于6时，又会转化成链表。
* 非线程安全。 HashTable 是线程安全的。
* 无序
* 允许key和value都为null.

## HashMap 默认初始容量

DEFAULT_INITIAL_CAPACITY = 1 << 4 //16

## 默认填充因子

DEFAULT_LOAD_FACTOR = 0.75f;

## 当桶 上的节点大与这个值时会转成红黑树
TREEIFY_THRESHOLD = 8

## 确定Hash桶数组索引位置

````
  static final int hash(Object key){
    int h;
    return (key == null) ? 0 :(h = key.hashCode()) ^(h >>>16);
  }
````

## 添加元素
通过 put 方法添加元素。先通过hash方法计算key的hash值。
内部使用Node<K,V>数组进行存储。
在过程中需要判断数据是否需要初始化。是否需要扩容。如果存在hash碰撞。

## 查找元素
调用get方法，通过参数key 计算索引和桶的位置，先检查第一个节点，如果是key == node[key] 就返回，如果不是就遍历后面的数组或红黑树。







