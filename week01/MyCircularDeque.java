package org.leetcode.question.week01;

/**
 * [641]设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 */

public class MyCircularDeque {
    int count;
    int capacity;
    MyCircularDequeNode head, tail;

    /** 构造函数初始化 k 容量的容器 */
    public MyCircularDeque(int k) {
        this.count = 0;
        this.capacity = k;
    }


    public boolean insertFront(int value) {
        if(this.count == this.capacity) {
            return false;
        }
        MyCircularDequeNode newNode = new MyCircularDequeNode(value);
        if(this.count == 0) {
            this.head = this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = this.head.prev;
        }
        this.count++;
        return true;
    }


    public boolean insertLast(int value) {
        if(this.count == this.capacity) {
            return false;
        }
        MyCircularDequeNode newNode = new MyCircularDequeNode(value);
        if(this.count == 0) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = this.tail.next;
        }
        this.count++;
        return true;
    }


    public boolean deleteFront() {
        if(this.count == 0) {
            return false;
        }
        if(this.count == 1) {
            this.head = this.tail = null;
        } else {
            MyCircularDequeNode newHead = this.head.next;
            this.head.next = null;
            this.head = newHead;
            this.head.prev = null;
        }
        this.count--;
        return true;
    }

    public int getRear() {
        return this.count > 0 ? this.tail.val : -1;
    }


    public boolean isEmpty() {
        return this.count == 0;
    }


    public boolean isFull() {
        return this.count == this.capacity;
    }


    public boolean deleteLast() {
        if(this.count == 0) {
            return false;
        }
        if(this.count == 1) {
            this.head = this.tail = null;
        } else {
            MyCircularDequeNode newTail = this.tail.prev;
            this.tail.prev = null;
            this.tail = newTail;
            this.tail.next = null;
        }
        this.count--;
        return true;
    }


    public int getFront() {
        return this.count > 0 ? this.head.val : -1;
    }




}
class MyCircularDequeNode{
    int val;
    MyCircularDequeNode prev, next;

    MyCircularDequeNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }


}
