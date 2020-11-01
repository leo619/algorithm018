package org.leetcode.question.week02;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 */
public class Preorder {
    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;


    }
    public static void main(String[] args) {

    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
