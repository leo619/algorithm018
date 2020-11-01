package org.leetcode.question.week02;

public class TreeNode {

    public int val;

    public TreeNode left,right;

    public TreeNode(int val){
        this(val,null,null);
    }
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.right = right;
        this.left = left;
    }
}
