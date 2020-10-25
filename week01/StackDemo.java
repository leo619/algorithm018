package org.leetcode.question.week01;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * stack 栈  先入后出，后入先出
 * 时间复杂度 插入、删除 o(1) 查找 o(n)
 * Stack 继承 Vector 是线程安全的。所以 stack 是线程安全的。
 * capacity 默认容量是 10
 *
 * 继承关系
 * Stack -> Vector -> AbstractList -> AbstractCollection ->Collection ->Iterable
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0 ; i < 5 ; i++){
            //add方法 实际是调用vector 的add方法
            integerStack.add(i);
        }
        System.out.println("--------------------------");
        integerStack.forEach(i -> {
            System.out.println(i);
        });
        /**
         * push 与 add 的区别
         * add 是Vector的方法。
         * add 返回添加是否成功。
         * push 方法调用Vector的 addElement方法。返回添加元素本身
         */
        integerStack.push(5);
        System.out.println("--------------------------");
        integerStack.forEach(i -> {
            System.out.println(i);
        });
        //peek 只看不拿
        int item = integerStack.peek();
        item = integerStack.peek();
        System.out.println("item == "+item);
        System.out.println("--------------------------");
        //pop 看并拿走
        /**
         * synchronized 方法 先 调用peek 去除结果，然后调用removeElementAt方法
         * 将数组中的elementCount  设置为null,并将 elementCount--
         * 当一个空数组的stack调用 pop方法是出产生 ArrayIndexOutOfBoundsException
         */
        item = integerStack.pop();
        System.out.println("item pop  == "+item);
        item = integerStack.pop();
        System.out.println("item pop == "+item);
        System.out.println("--------------------------");

        /**
         * add  与 addElement的区别
         * add 是 Vector 继承 List 的接口 有添加是否成功返回值
         * addElement 是 Vector 的自我实现，没有返回值
         */
        integerStack.addElement(6);

        // 调用vector clear 删除元素
        integerStack.clear();

        // 在元素为空的情况下，pop 和 peek 都会抛出 EmptyStackException
        try {
            integerStack.pop();
        }catch (EmptyStackException exception){
            exception.printStackTrace();
        }
        try {
            integerStack.peek();
        }catch (EmptyStackException exception){
            exception.printStackTrace();
        }





    }


}
