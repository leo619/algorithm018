package org.leetcode.question.week01;

//[283]给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 777 👎 0


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

//leetcode submit region begin(Prohibit modification and deletion)
 public class MoveZero {

  
    public static int[] movezero(int[] nums){
        if(nums == null ){
            return new int[0];
        }
        int j = 0 ;
        for(int i = 0 ; i < nums.length ;i++){
            if (nums[i] != 0 ){
                nums[j++] = nums[i];
            }
        }
        for (int i = j ; i < nums.length;i++){
            nums[i] = 0;
        }
        return nums;
    }

    public static int[] movezero1(int[] nums){
       if(nums == null  ){
         return new int[0];
       }
       int j = 0 ;
       int temp = 0 ;
       for (int i = 0 ; i < nums.length ; i++){
           if(nums[i]!=0 ){
               temp = nums[i];
               nums[i] = nums[j];
               nums[j++] = temp;
           }
       }
       return  nums;
    }

    public static int[] movezero2(int[] nums){
        if(nums == null  ){
            return new int[0];
        }
        int j = 0 ;
        for (int i = 0 ; i < nums.length; i++){
            if( nums[i] != 0 ){
                if(i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;

            }

        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0,8,0,7,0};
        nums = movezero2(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
