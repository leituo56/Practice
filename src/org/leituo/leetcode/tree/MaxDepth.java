//Given a binary tree, find its maximum depth.

//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
package org.leituo.leetcode.tree;

import org.leituo.utils.TreeNode;

/**
 * Created by leituo56 on 11/3/14.
 */
public class MaxDepth {
    class Solution{
        //brute force
        public int maxDepth(TreeNode root) {
            if(root == null)
                return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
