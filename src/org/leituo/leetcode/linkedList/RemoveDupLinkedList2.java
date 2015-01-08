//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
//For example,
//Given 1->2->3->3->4->4->5, return 1->2->5.
//Given 1->1->1->2->3, return 2->3.
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 1/7/15.
 */
public class RemoveDupLinkedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode prev = helper;
        ListNode runner = head;
        while(runner!=null){
            if(runner.next!=null && runner.val == runner.next.val){
                while(runner.next!=null && runner.val == runner.next.val){
                    runner = runner.next;
                }
                prev.next = runner.next;
                runner = prev.next;
            }else{
                prev = runner;
                runner = runner.next;
            }
        }
        return helper.next;
    }
}
