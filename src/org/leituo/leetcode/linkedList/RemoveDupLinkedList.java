//Given a sorted linked list, delete all duplicates such that each element appear only once.

//For example,
//        Given 1->1->2, return 1->2.
//        Given 1->1->2->3->3, return 1->2->3.
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 11/3/14.
 */
public class RemoveDupLinkedList {
    class Solution{
        //brute force
        public ListNode deleteDuplicates(ListNode head) {
            ListNode runner = head;
            while(runner!=null){
                while(runner.next!=null && runner.val == runner.next.val){
                    runner.next = runner.next.next;
                }
                runner = runner.next;
            }
            return head;
        }
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
         val = x;
         next = null;
    }
}
