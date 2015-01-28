//Merge two sorted linked lists and return it as a new list. The new list should
// be made by splicing together the nodes of the first two lists.
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 11/8/14.
 */
public class Merge2SortedLists {
    class Solution{
        //helper
        //brute force
        public ListNode mergeTwoLists(ListNode one, ListNode two) {
            ListNode helper = new ListNode(0);
            ListNode end = helper;
            while(one!=null && two!=null){
                if(one.val < two.val){
                    end.next = one;
                    one = one.next;
                }else{
                    end.next = two;
                    two = two.next;
                }
                end = end.next;
            }
            end.next = (one==null)?two:one;
            return helper.next;
        }
    }
}
