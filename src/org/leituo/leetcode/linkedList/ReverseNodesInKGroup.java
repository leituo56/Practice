//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
//If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//You may not alter the values in the nodes, only nodes itself may be changed.
//
//Only constant memory is allowed.
//
//For example,
//Given this linked list: 1->2->3->4->5
//
//For k = 2, you should return: 2->1->4->3->5
//
//For k = 3, you should return: 3->2->1->4->5
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 1/12/15.
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode helper = new ListNode(0);
        ListNode end = helper;
        ListNode temp = null;
        ListNode runner = head;
        boolean finished = false;
        while(!finished){
            ListNode tempEnd = runner;
            for(int i = 0; i < k; i++){
                if(runner==null){
                    finished = true;
                    break;
                }
                ListNode next = runner.next;
                runner.next = temp;
                temp = runner;
                runner = next;
            }
            if(finished){
                end.next = reverse(temp);
            }else{
                end.next = temp;
                end = tempEnd;
                temp = null;
            }
        }
        return helper.next;
    }
    private ListNode reverse(ListNode head){
        ListNode result = null;
        while(head != null){
            ListNode next= head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return result;
    }
}
