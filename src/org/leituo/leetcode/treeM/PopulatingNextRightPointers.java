//Given a binary tree
//
//struct TreeLinkNode {
//TreeLinkNode *left;
//TreeLinkNode *right;
//TreeLinkNode *next;
//}
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//Initially, all next pointers are set to NULL.
//
//Note:
//
//You may only use constant extra space.
//You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
//For example,
//Given the following perfect binary tree,
//1
///  \
//2    3
/// \  / \
//4  5  6  7
//After calling your function, the tree should look like:
//1 -> NULL
///  \
//2 -> 3 -> NULL
/// \  / \
//4->5->6->7 -> NULL
package org.leituo.leetcode.treeM;

/**
 * Created by leituo56 on 11/9/14.
 */
public class PopulatingNextRightPointers {
    class Solution{
        //Iterative
        //go down level by level
        //for each level, traverse right, connect left->right and right-> next.left
        public void connect2(TreeLinkNode root) {
            TreeLinkNode down = root;
            while(down!=null){
                TreeLinkNode across = down;
                while(across!=null){
                    if(across.left != null && across.right !=null){
                        across.left.next = across.right;
                    }
                    if(across.right != null && across.next != null){
                        across.right.next = across.next.left;
                    }
                    across = across.next;
                }
                down = down.left;
            }
        }
    }

}
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
