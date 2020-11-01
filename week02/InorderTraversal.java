package org.leetcode.question.week02;

import java.util.ArrayList;
import java.util.List;

/**
 * 94.二叉树的中序遍历
 */
public class InorderTraversal {

    /**
     * 递归方法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<>();
        inorder(root,res);
      return res;
    }
    public void inorder(TreeNode node,List<Integer> res){
        if(node == null) {
            return;
        }
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);
    }
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,null,2,3};

    }
}
