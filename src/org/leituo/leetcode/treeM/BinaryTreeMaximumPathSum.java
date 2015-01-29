//Given a binary tree, find the maximum path sum.
//
//The path may start and end at any node in the tree.
//
//For example:
//Given the below binary tree,
//
//  1
// / \
//2   3
//Return 6.
package org.leituo.leetcode.treeM;

/**
 * Created by leituo56 on 1/19/15.
 */
public class BinaryTreeMaximumPathSum {
    class Solution{
        //write a pathSum helper, calculate the max path sum from node to leaf
        //update max while traversing, max = max(max, left + right + root)
        private int max;
        public int maxPathSum(TreeNode root) {
            if(root == null)
                return 0;
            max = Integer.MIN_VALUE;
            pathSum(root);
            return max;
        }
        public int pathSum(TreeNode root){
            if(root == null)
                return 0;
            int left = pathSum(root.left);
            int right = pathSum(root.right);
            max = Math.max(max, left + right + root.val );
            int result = Math.max(root.val, root.val + Math.max(left, right));
            result = Math.max(0, result);
            return result;
        }
    }

}
