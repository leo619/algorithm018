package org.leetcode.question.week01;

/**
 * [21] 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class MergeTwoLists {

    /**
     * 迭代法
     * 交替对比2个队列取最小值
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
       ListNode prehead = new ListNode(-1);
       ListNode prev = prehead;
       while(l1!=null && l2!=null){
           if(l1.val <= l2.val){
               prev.next = l1;
               l1 = l1.next;
           }else{
               prev.next = l2;
               l2 = l2.next;
           }
           prev = prev.next;
       }
       prev.next = l1 == null ? l2 : l1;
       return prehead.next;
    }

    /**
     * 递归法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       if( l1 == null) return  l2;
       if( l2 == null) return  l1;
       if( l1.val < l2.val){
           l1.next = mergeTwoLists(l1.next,l2);
           return l1;
       }else{
           l2.next = mergeTwoLists(l1,l2.next);
           return l2;
       }
    }



    public static void main(String[] args) {
        ListNode l1 =  new ListNode(1);
        l1.next= new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 =  new ListNode(1);
        l2.next= new ListNode(3);
        l2.next.next = new ListNode(4);

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        System.out.println(mergeTwoLists.mergeTwoLists01(l1,l2));
//        System.out.println(mergeTwoLists.mergeTwoLists(l1,l2));
    }


}
