//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
//Return a deep copy of the list.
package org.leituo.leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leituo56 on 1/16/15.
 */
public class CopyListWithRandomPointer {
    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     *     int label;
     *     RandomListNode next, random;
     *     RandomListNode(int x) { this.label = x; }
     * };
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode result = new RandomListNode(head.label);
        map.put(head, result);
        RandomListNode runner = head;
        RandomListNode runner2 = result;
        //copy next
        while(runner.next!=null){
            RandomListNode next = runner.next;
            RandomListNode next2 = new RandomListNode(next.label);
            map.put(next, next2);
            runner2.next = next2;

            runner = next;
            runner2 = next2;
        }
        //copy random
        runner = head;
        runner2 = result;
        while(runner!=null){
            if(runner.random == null){
                runner2.random = null;
            }else{
                runner2.random = map.get(runner.random);
            }
            runner = runner.next;
            runner2 = runner2.next;
        }
        return result;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };
}
