//Sort a linked list using insertion sort.
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 11/9/14.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode runner = head;
        while(runner!=null && runner.next!=null){
            if(runner.next.val<runner.val){
                ListNode temp = runner.next;
                runner.next = temp.next;
                temp.next = null;
                //insert
                if(temp.val < head.val){
                    temp.next = head;
                    head = temp;
                    continue;
                }
                ListNode runner2 = head;
                while(runner2.next!=null && temp.val > runner2.next.val){
                    runner2 = runner2.next;
                }
                temp.next = runner2.next;
                runner2.next = temp;
            }else{
                runner = runner.next;
            }
        }
        return head;
    }
}
