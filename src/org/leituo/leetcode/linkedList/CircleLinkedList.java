//Given a linked list, determine if it has a cycle in it.

//Follow up:
//        Can you solve it without using extra space?
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 11/3/14.
 */
public class CircleLinkedList {
    public boolean hasCycle(ListNode head) {
        ListNode runner1 = head;
        ListNode runner2 = head;
        while(true){
            if(runner2==null || runner2.next == null || runner2.next.next==null)
                return false;
            runner1 = runner1.next;
            runner2 = runner2.next.next;
            if(runner1==runner2)
                return true;
        }
    }
}
