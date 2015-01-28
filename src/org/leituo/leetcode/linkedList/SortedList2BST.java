//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
package org.leituo.leetcode.linkedList;

/**
 * Created by leituo56 on 1/2/15.
 */
public class SortedList2BST {
    class Solution{
        //recurrsive, use count for help
        //left = generate left part of list
        //result = current
        //right = generate right part of list
        ListNode list;
        public TreeNode sortedListToBST(ListNode head) {
            this.list = head;
            return generate(count(head));
        }
        private TreeNode generate(int count){
            if (count <= 0)
                return null;
            TreeNode node = new TreeNode(0);
            node.left = generate(count / 2);
            node.val = list.val;
            list = list.next;
            node.right = generate(count - count/2 - 1);
            return node;
        }
        private int count(ListNode head){
            int total = 0;
            while (head!=null){
                total++;
                head = head.next;
            }
            return total;
        }
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
