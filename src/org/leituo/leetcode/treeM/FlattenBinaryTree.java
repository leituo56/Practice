//Given a binary tree, flatten it to a linked list in-place.

//For example,
//        Given
//
//        1
//        / \
//        2   5
//        / \   \
//        3   4   6
//        The flattened tree should look like:
//        1
//        \
//        2
//        \
//        3
//        \
//        4
//        \
//        5
//        \
//        6
package org.leituo.leetcode.treeM;

import org.leituo.utils.TreeNode;

/**
 * Created by leituo56 on 11/9/14.
 */
public class FlattenBinaryTree {
    class Solution{
        //put left part to root.right
        //put right part to most right node of root.left
        //root = root.right
        public void flatten(TreeNode root) {
            while(root!=null){
                if(root.left != null){
                    TreeNode runner = root.left;
                    while(runner.right!=null)
                        runner = runner.right;
                    runner.right = root.right;
                    root.right = root.left;
                    root.left = null;
                }
                root = root.right;
            }
        }
    }

}
