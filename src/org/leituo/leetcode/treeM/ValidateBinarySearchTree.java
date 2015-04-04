//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
package org.leituo.leetcode.treeM;

import org.leituo.utils.TreeNode;

/**
 * Created by leituo56 on 1/7/15.
 */
public class ValidateBinarySearchTree {
    class Solution{
        //inorder traversal
        //if cur <= prev, then false
        private TreeNode prev;
        public boolean isValidBST(TreeNode root) {
            this.prev = null;
            return validateBST(root);
        }
        public boolean validateBST(TreeNode root){
            if(root == null)
                return true;
            //traverse left
            if(!validateBST(root.left))
                return false;

            //compare current
            if(prev != null && prev.val >= root.val)
                return false;
            prev = root;

            //traverse right
            return validateBST(root.right);
        }
    }

}
