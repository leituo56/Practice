//Two elements of a binary search tree (BST) are swapped by mistake.
//
//Recover the tree without changing its structure.
//
//Note:
//A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
package org.leituo.leetcode.treeM;

import org.leituo.utils.TreeNode;

/**
 * Created by leituo56 on 1/16/15.
 */
public class RecoverBinarySearchTree {
    class Solution{
        //inorder
        //track prev
        //if cur < prev, means prev is misorder first, second try to give a val cur
        //second will finally stop at the biggest elem less than first
        //swap them
        TreeNode first;
        TreeNode second;
        TreeNode prev;
        public void recoverTree(TreeNode root) {
            traverse(root);
            if(first!=null && second!=null){
                int temp = first.val;
                first.val = second.val;
                second.val = temp;
            }
        }
        private void traverse(TreeNode root){
            if(root==null)
                return;
            traverse(root.left);
            if(prev !=null && root.val < prev.val){
                if(first == null){
                    first = prev;
                }
                second = root;
            }
            prev = root;
            traverse(root.right);
        }
    }

}
