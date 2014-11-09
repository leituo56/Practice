//Merge two sorted linked lists and return it as a new list. The new list should
// be made by splicing together the nodes of the first two lists.
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 11/8/14.
 */
public class Merge2SortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(l1!=null || l2!=null){
            if(l2==null || (l1!=null && l2!=null && l1.val < l2.val)){
                temp.next = new ListNode(l1.val);
                temp = temp.next;
                l1 = l1.next;
            }else{
                temp.next = new ListNode(l2.val);
                temp = temp.next;
                l2 = l2.next;
            }
        }
        result = result.next;
        return result;
    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(l1!=null || l2!=null){
            if(l2==null || (l1!=null && l2!=null && l1.val < l2.val)){
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
                temp.next = null;
            }else{
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
                temp.next = null;
            }
        }
        result = result.next;
        return result;
    }
}
