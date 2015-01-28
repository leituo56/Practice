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
    class Solution{
        //Use a hashmap to store Node->CopyedNode
        //Copy the head and put it to hashmap
        //Copy every next and put it to hashmap
        //Go through again, and find the copied Node(from map) and point to it
        public RandomListNode copyRandomList(RandomListNode head) {
            if(head==null)
                return null;
            Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
            RandomListNode result = new RandomListNode(head.label);
            map.put(head, result);

            RandomListNode runner = head;
            RandomListNode runnerCopy = result;
            //copy next
            while(runner.next!=null){
                RandomListNode next = runner.next;
                RandomListNode nextCopy = new RandomListNode(next.label);
                map.put(next, nextCopy);
                runnerCopy.next = nextCopy;

                runner = next;
                runnerCopy = nextCopy;
            }
            //copy random
            runner = head;
            runnerCopy = result;
            while(runner!=null){
                if(runner.random == null){
                    runnerCopy.random = null;
                }else{
                    runnerCopy.random = map.get(runner.random);
                }
                runner = runner.next;
                runnerCopy = runnerCopy.next;
            }
            return result;
        }
    }


    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };
}
