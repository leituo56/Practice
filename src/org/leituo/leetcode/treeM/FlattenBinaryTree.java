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

/**
 * Created by leituo56 on 11/9/14.
 */
public class FlattenBinaryTree {
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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
