//Given a list, rotate the list to the right by k places, where k is non-negative.
//
//For example:
//Given 1->2->3->4->5->NULL and k = 2,
//return 4->5->1->2->3->NULL.
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 1/9/15.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || head.next == null || n < 1)
            return head;
        ListNode runner = head;
        int len = 1;
        while(runner.next!=null){
            len++;
            runner = runner.next;
        }
        runner.next = head;
        n = n % len;//if n > len, start over
        runner = head;//reset
        for(int i = 0; i < len - n - 1; i++){
            runner = runner.next;
        }
        head = runner.next;
        runner.next = null;
        return head;
    }
}
