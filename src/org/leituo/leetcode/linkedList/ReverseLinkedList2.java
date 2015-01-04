//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//return 1->4->3->2->5->NULL.
//
//Note:
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 1/3/15.
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        int curIndex = 0;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode start = helper, end = helper, runner = helper;
        while(curIndex <= n){
            ListNode next = runner.next;
            if(curIndex + 1 == m){
                start = runner;
                end = runner.next;
                start.next = null;
            }
            if(m <= curIndex && curIndex <= n){
                runner.next = start.next;
                start.next = runner;
            }
            curIndex++;
            runner = next;
        }
        end.next = runner;
        return helper.next;
    }

    public static void main(String[] args) {
        ReverseLinkedList2 test = new ReverseLinkedList2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = test.reverseBetween(head, 1, 3);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
