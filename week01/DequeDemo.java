package org.leetcode.question.week01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Deque 双端队列 Deque是一个接口 Deque -> Queue  ->Collection
 * Deque 子类 ArrayDeque  LinkedBlockingDeque -> BlockingDeque -> Deque
 */
public class DequeDemo {
    public static void main(String[] args) {

        /**
         * 初始3个容量，但可以扩充
         */
        ArrayDeque<Integer> deque = new ArrayDeque<>(3);


        for (int i = 1 ; i <=5 ; i++){
            deque.add(i);
        }
        /**
         * 双端队列 新增了 addFirst addLast
         * remoteFirst remoteLast 方法
         * offerFirst   offerLast 方法
         * pollFirst   pollFirst 方法
         *
         */
        deque.addFirst(0);
        deque.addLast(6);
        deque.forEach(integer -> {
            System.out.println(integer);
        });
        /**
         * 因为是队列，所以peek 获取的是先入元素
         * peek == peekFirst
         */
        System.out.println("-------------------------");
        System.out.println("deque.peek() == "+ deque.peek());
        System.out.println("deque.peekFirst() == "+ deque.peekFirst());
        System.out.println("deque.peekLast() == "+ deque.peekLast());

        System.out.println("-------------------------");
        /**
         * linked 是有界的 超过就会DequeFull
         * 如果不设置capacity 就是Integer.MAX_VALUE
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque(3);
        for (int i = 1 ; i <=3 ; i++){
            linkedBlockingDeque.add(i);
        }
        boolean b = linkedBlockingDeque.offerLast(4);
        System.out.println("dequeFull 添加结果 == "+ b);

        /**
         * 与 ArrayDeque 相比 增加了take 等相关方法,并且是线程安全的
         */





    }
}
