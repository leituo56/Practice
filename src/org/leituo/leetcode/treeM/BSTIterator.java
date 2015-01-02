//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//
//Calling next() will return the next smallest number in the BST.
//
//Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
package org.leituo.leetcode.treeM;

import java.util.Stack;

/**
 * Created by leituo56 on 1/2/15.
 */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        init(root);
    }
    private void init(TreeNode root){
        TreeNode current = root;
        while(current!=null){
            stack.push(current);
            current = current.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode current = stack.pop();
        if(current.right!=null)
            init(current.right);
        return current.val;
    }
}
