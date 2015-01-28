//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//You must do this in-place without altering the nodes' values.
//
//For example,
//Given {1,2,3,4}, reorder it to {1,4,2,3}.
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 1/8/15.
 */
public class ReorderList {
    class Solution{
        /**
         * 分割链表
         * 反转后半部
         * 前半部后半部MERGE
        */
        //Use quick and slow runner to split the list
        //reverse slow runner
        //merge head and slow runner
        public void reorderList(ListNode head) {
            if(head == null || head.next==null || head.next.next==null)
                return;
            ListNode quickRunner = head;
            ListNode slowRunner = head;
            ListNode prev = null;
            while(quickRunner!=null && quickRunner.next != null){
                prev = slowRunner;
                slowRunner = slowRunner.next;
                quickRunner = quickRunner.next.next;
            }
            prev.next = null;
            slowRunner = reverseList(slowRunner);
            mergeList(head, slowRunner);
        }
        private ListNode reverseList(ListNode head){
            ListNode helper = new ListNode(0);
            ListNode end = helper;
            ListNode runner = head;
            while(runner!=null){
                ListNode next = runner.next;
                runner.next = helper.next;
                helper.next = runner;
                runner = next;
            }
            return helper.next;
        }
        private void mergeList(ListNode left, ListNode right){
            ListNode end = new ListNode(0);
            boolean addLeft = true;
            while(left!=null && right!=null){
                if(addLeft){
                    end.next = left;
                    left = left.next;
                    addLeft = false;
                }else{
                    end.next = right;
                    right = right.next;
                    addLeft = true;
                }
                end = end.next;
            }
            end.next = left==null?right:left;
        }
    }

}
