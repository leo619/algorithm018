package org.leetcode.question.week01;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * PriorityQueue 是一个实现优先级排序的Queue.
 * PriorityQueue -> AbstractQueue
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3);
        /**
         * element 与 peek 查看元素，但是如果没有元素，element 抛出NoSuchElement异常，peek 返回null
         */
        try {
            priorityQueue.element();
        }catch (NoSuchElementException ex){
            ex.printStackTrace();
        }

        /**
         * add 方法 == offer
         */
        priorityQueue.add(3);
        priorityQueue.add(10);
        priorityQueue.add(2);
        priorityQueue.add(32);
        priorityQueue.add(99);
        priorityQueue.add(1);
        priorityQueue.add(5);


        /**
         * 直接foreach打印，并不会完成排序
         */
        System.out.println("-----------------------------------------");
        priorityQueue.forEach(integer ->{System.out.println(integer);});
        System.out.println("-----------------------------------------");
        /**
         * 通过 peek poll remote 获取的才是排序的
         */
        Integer item = priorityQueue.poll();
        while (item != null){
            System.out.println("item == "+item);
            item = priorityQueue.poll();
        }

    }
}
