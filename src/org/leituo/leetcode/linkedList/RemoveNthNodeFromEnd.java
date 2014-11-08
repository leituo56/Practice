//Given a linked list, remove the nth node from the end of list and return its head.

//For example,
//
//        Given linked list: 1->2->3->4->5, and n = 2.
//
//        After removing the second node from the end, the linked list becomes 1->2->3->5.
//        Note:
//        Given n will always be valid.
//        Try to do this in one pass.
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 11/7/14.
 */
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode runner1 = head;
        ListNode runner2 = head;
        for(int i=0; i< n; i++){
            runner1 = runner1.next;
            if(runner1==null){
                head = head.next;
                return head;
            }
        }
        while(runner1.next!=null){
            runner1 = runner1.next;
            runner2 = runner2.next;
        }
        runner2.next = runner2.next.next;
        return head;
    }
}
