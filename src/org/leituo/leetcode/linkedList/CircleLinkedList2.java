//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//        Follow up:
//        Can you solve it without using extra space?
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 12/18/14.
 */
public class CircleLinkedList2 {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode runner1 = head;
        ListNode runner2 = head;
        ListNode joint = null;
        while(runner2.next!=null && runner2.next.next!=null ){
            runner1 = runner1.next;
            runner2 = runner2.next.next;
            if(runner1==runner2){
                joint = runner1;
                break;
            }
        }
        if(joint==null)
            return null;
        runner1 = head;
        while(joint != runner1){
            joint = joint.next;
            runner1 = runner1.next;
        }
        return joint;
    }
}
