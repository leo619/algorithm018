package org.leetcode.question.week01;

//[206]反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
public class ReverseList {

    /**
     * 迭代方式
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null,temp = null;
        ListNode cur = head;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;

    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next =head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode pre = head;
        for (int i = 2 ; i <= 5 ; i++){
            ListNode item = new ListNode(i);
            pre.next = item;
            pre = item;
        }
        ReverseList reverseList = new ReverseList();
        ListNode result = reverseList.reverseList1(head);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
