package org.leetcode.question.week01;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        ListNode listNode = this;
        while(listNode!=null){
            stringBuffer.append(listNode.val + "\t");
            listNode = listNode.next;
        }

        return stringBuffer.toString();
    }
}
