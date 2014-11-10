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
    //Iterative
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
    //RECURSIVE, using stack memory
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        if(root.left!=null && root.right!=null){
            root.left.next = root.right;//connect left, right
            connectAdj(root.left, root.right);//connect adjacent
            connect(root.left);
            connect(root.right);
        }
    }
    public void connectAdj(TreeLinkNode left, TreeLinkNode right){
        while(left.right!=null && right.left!=null) {
            left.right.next = right.left;
            left = left.right;
            right = right.left;
        }
    }

}
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
