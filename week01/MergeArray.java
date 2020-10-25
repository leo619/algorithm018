package org.leetcode.question.week01;

import java.util.Arrays;

/**
 * [88] 合并两个有序数组
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 *
 *
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。
 * 你可以假设nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。
 *
 */
public class MergeArray {

    /**
     * 合并后再调用排序接口
     * 时间复杂度 : O((n + m)\log(n + m))O((n+m)log(n+m))。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
         System.arraycopy(nums2,0,nums1,m,n);
         Arrays.sort(nums1);
         for (int i : nums1){
             System.out.println(i);
         }
    }

    /**
     * 双指针 / 从后往前
     * 时间复杂度 : O(n + m)O(n+m)。
     * 空间复杂度 : O(1)O(1)。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n ){
        int p1 = m - 1;
        int p2 = n - 1;

        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }


    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] num2 = new int[]{2,5,6};
        int n= 3;

        MergeArray mergeArray = new MergeArray();
        mergeArray.merge1(num1,m, num2,n);
    }
}
