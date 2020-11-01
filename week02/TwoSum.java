package org.leetcode.question.week02;

/**
 * 1 两数之和
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] result ;
        int[] intArgs = new int[]{2,7,11,15};
        int target = 9 ;
        org.leetcode.question.week01.TwoSum twoSum = new org.leetcode.question.week01.TwoSum();

//        result = twoSum.twoSum1(intArgs,target);
        result = twoSum.twoSum2(intArgs,target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
