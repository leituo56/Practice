//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order
// and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 11/9/14.
 */
public class Add2Numbers {
    class Solution{
        //Go from left to right
        //sum and carry, carry = sum/10; sum = sum % 10,
        //Notice if there's a final carry
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            ListNode runner = result;
            int sum=0, carry=0;
            while(l1!=null || l2!=null){
                if(l1!=null && l2!=null){
                    sum = l1.val + l2.val + carry;
                    l1 = l1.next;
                    l2 = l2.next;
                }else if(l1==null){
                    sum = l2.val + carry;
                    l2 = l2.next;
                }else{
                    sum = l1.val + carry;
                    l1 = l1.next;
                }
                carry = sum/10;
                sum = sum % 10;
                runner.next = new ListNode(sum);
                runner = runner.next;
            }
            if(carry>0)
                runner.next = new ListNode(carry);
            return result.next;
        }
    }

}
