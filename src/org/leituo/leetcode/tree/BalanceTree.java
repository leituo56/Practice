//Given a binary tree, determine if it is height-balanced.

//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
// of every node never differ by more than 1.
package org.leituo.leetcode.tree;

import org.leituo.utils.TreeNode;

/**
 * Created by leituo56 on 11/6/14.
 */
public class BalanceTree {
    class Solution{
        //combine height and isBalance to a help method
        // >=0 means height, -1 means unbalance
        // unbalance when left unbalance || right unbalance || abs(hL - hR) > 1
        public boolean isBalanced(TreeNode root) {
            int result = heightAndBalance(root);
            return result!=-1;
        }
        public int heightAndBalance(TreeNode root){
            if(root == null)
                return 0;
            int left = heightAndBalance(root.left);
            int right = heightAndBalance(root.right);
            if(left==-1 || right==-1 ||Math.abs(left-right)>1)
                return -1;
            return Math.max(left, right) + 1;
        }
    }

}
