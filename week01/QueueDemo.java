package org.leetcode.question.week01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * queue 队列，先进先出 .
 * Queue 是接口 实现类有 ArrayBlockingQueue  AbstractQueue  PriorityQueue
 * Deque 是继承 Queue的接口，用于实现双端队列
 */
public class QueueDemo {
    public static void main(String[] args) {


        /*new ArrayBlockingQueue(10,false)  默认为false, 非公平的
          非公平是指并不按入队顺序执行
        * 是一个用数组实现的有界阻塞队列
        * */

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(10,false);
        /**
         * add 方法超过容量会报错，offer 方法超过容量不会报错
         * put 方法超过容量就阻塞等待
         */
        for(int i = 0 ; i < 20 ; i ++){

            queue.offer(i);
        }
//        for(int i = 0 ; i < 5 ; i ++){
//            try {
//                queue.put(i);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        for (int i = 0 ; i < 5 ; i ++){
            new Thread(()->{
                Integer integer = queue.poll();
                while (integer != null){
                    System.out.println(integer);
                    integer= queue.poll();

                }
            }).start();
        }
        //take 与  poll 的区别
        /**
         * 下面代码会持续占有 cpu
         */
//        new Thread(()->{
//            while (true){
//
//                queue.poll();
//            }
//        }).start();
        new Thread(()->{
            while (true){

                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
