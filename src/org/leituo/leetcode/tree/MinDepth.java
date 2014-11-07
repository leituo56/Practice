//Given a binary tree, find its minimum depth.

//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
package org.leituo.leetcode.tree;

/**
 * Created by leituo56 on 11/6/14.
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left == null && root.right==null)
            return 1;
        if(root.left == null)
            return 1 + minDepth(root.right);
        if(root.right == null)
            return 1 + minDepth(root.left);
        else
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
