//Sort a linked list using insertion sort.
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 11/9/14.
 */
public class InsertionSortList {
    class Solution {
        //track the insert position, insert to the next of position
        public ListNode insertionSortList(ListNode head) {
            ListNode helper = new ListNode(0);
            ListNode insertPos;
            ListNode runner = head;
            while (runner != null) {
                insertPos = helper;
                while (insertPos.next != null && insertPos.next.val < runner.val) {
                    insertPos = insertPos.next;
                }
                ListNode next = runner.next;
                runner.next = insertPos.next;
                insertPos.next = runner;
                runner = next;
            }
            return helper.next;
        }
    }

    class SolutionEncapsulate {
        //same idea using encapsulation
        public ListNode insertionSortList(ListNode head) {
            ListNode helper = new ListNode(0);
            ListNode runner = head;
            while(runner != null){
                ListNode next = runner.next;
                insert(helper, runner);
                runner = next;
            }
            return helper.next;
        }
        private void insert(ListNode helper, ListNode node){
            ListNode runner = helper;
            while(runner.next != null && runner.next.val < node.val){
                runner = runner.next;
            }
            node.next = runner.next;
            runner.next = node;
        }
    }
}
