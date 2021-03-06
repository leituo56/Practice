//Given a binary tree and a sum, determine if the tree has a root-to-leaf
// path such that adding up all the values along the path equals the given sum.

//For example:
//        Given the below binary tree and sum = 22,
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \      \
//        7    2      1
//        return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
package org.leituo.leetcode.tree;

import org.leituo.utils.TreeNode;

/**
 * Created by leituo56 on 11/6/14.
 */
public class PathSum {
    class Solution{
        //if root is the leaf && root.val==sum
        //pathSum = pathSum(left, remains) || pathSum(right, remains)
        public boolean hasPathSum(TreeNode root, int sum) {
            if(root==null){
                return false;
            }
            if(root.val == sum && root.left==null && root.right==null){
                return true;
            }
            int remain = sum - root.val;

            return hasPathSum(root.left, remain) || hasPathSum(root.right, remain);
        }
    }

}
