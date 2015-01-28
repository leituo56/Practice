//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
package org.leituo.leetcode.linkedList;

import java.util.List;

/**
 * Created by leituo56 on 1/12/15.
 */
public class MergeKSortedLists {
    class Solution{
        //Merge every first two lists
        //add the merged list to the end of lists
        //continue until there's only one
        public ListNode mergeKLists(List<ListNode> lists) {
            while(lists.size() > 1){
                ListNode one = lists.remove(0);
                ListNode two = lists.remove(0);
                lists.add(mergeTwo(one, two));
            }
            return lists.size() == 0? null : lists.remove(0);
        }
        private ListNode mergeTwo(ListNode one, ListNode two){
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
            if(one==null)
                end.next = two;
            else
                end.next = one;
            return helper.next;
        }
    }

}
