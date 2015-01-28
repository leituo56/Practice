package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 11/16/14.
 */
public class SwapNodesInPairs {
    class Solution{
        //encapsulate swap prev, first, second
        //then brute force. start with helper
        public ListNode swapPairs(ListNode head) {
            ListNode helper = new ListNode(0);
            ListNode result = helper;
            helper.next = head;
            while(!(helper==null || helper.next==null || helper.next.next == null)){
                swap(helper, helper.next, helper.next.next);
                helper = helper.next.next;
            }
            return result.next;
        }
        public void swap(ListNode helper, ListNode first, ListNode second){
            ListNode next = second.next;
            helper.next = second;
            second.next = first;
            first.next = next;
        }
    }

}
