//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5.
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 1/3/15.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode leftEnd = left;
        ListNode right = new ListNode(0);
        ListNode rightEnd = right;

        ListNode runner = head;
        while(runner!=null){
            ListNode next = runner.next;
            if(runner.val < x){
                leftEnd.next = runner;
                leftEnd = runner;
            }else{
                rightEnd.next = runner;
                rightEnd = runner;
            }
            runner = next;
        }
        rightEnd.next = null;
        leftEnd.next = right.next;
        return left.next;
    }

    public static void main(String[] args) {
        PartitionList test = new PartitionList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        test.partition(head, 2);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
