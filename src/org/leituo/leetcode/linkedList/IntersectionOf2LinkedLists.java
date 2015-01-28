//Write a program to find the node at which the intersection of two singly linked lists begins.
//
//
//For example, the following two linked lists:
//
//A:          a1 → a2
//↘
//c1 → c2 → c3
//↗
//B:     b1 → b2 → b3
//begin to intersect at node c1.
//
//
//Notes:
//
//If the two linked lists have no intersection at all, return null.
//The linked lists must retain their original structure after the function returns.
//You may assume there are no cycles anywhere in the entire linked structure.
//Your code should preferably run in O(n) time and use only O(1) memory.
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 1/2/15.
 */
public class IntersectionOf2LinkedLists {
    class Solution{
        // because lenA + lenB == lenB + lenA
        // traverse A->B and B->A
        // when they're same, return
        // note that if there's no intersection, they will rich null at the same time
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode runnerA = headA;
            ListNode runnerB = headB;
            if(runnerA == null || runnerB == null)
                return null;
            while(runnerA!=null && runnerB!=null && runnerA!=runnerB){
                runnerA = runnerA.next;
                runnerB = runnerB.next;
                if(runnerA==runnerB)
                    return runnerA;
                if(runnerA == null)
                    runnerA = headB;
                if(runnerB == null)
                    runnerB = headA;
            }
            return runnerA;
        }
    }
}
