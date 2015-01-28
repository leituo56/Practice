//Sort a linked list in O(n log n) time using constant space complexity.
package org.leituo.leetcode.sort;

/**
 * Created by leituo56 on 1/7/15.
 */
public class SortList {
    class Solution{
        //Merge sorting
        //split the list by quick slow runner
        //sort(quick), sort(slow)
        //merge quick and slow
        public ListNode sortList(ListNode head) {
            ListNode quickRunner = head;
            ListNode slowRunner = head;
            ListNode divisor = head;

            while(quickRunner.next!=null && quickRunner.next.next!=null){
                divisor = slowRunner;
                slowRunner = slowRunner.next;
                quickRunner = quickRunner.next.next;
            }
            divisor.next = null;
            slowRunner = sortList(slowRunner);
            head = sortList(head);
            return merge(head, slowRunner);
        }
        private ListNode merge(ListNode left, ListNode right){
            ListNode helper = new ListNode(0);
            ListNode end = helper;
            while(left!=null && right!=null){
                if(left.val < right.val){
                    end.next = left;
                    left = left.next;
                }else{
                    end.next = right;
                    right = right.next;
                }
                end = end.next;
            }
            end.next = left==null?right:left;
            return helper.next;
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
}
