//Given a binary tree where all the right nodes are either leaf nodes with a sibling
// (a left node that shares the same parent node) or empty, flip it upside down and turn it into
// a tree where the original right nodes turned into left leaf nodes. Return the new root.
//
//        For example:
//        Given a binary tree {1,2,3,4,5},
//        1
//        / \
//        2   3
//        / \
//        4   5
//        return the root of the binary tree [4,5,2,#,#,3,1].
//        4
//        / \
//        5   2
//        / \
//        3   1
package org.leituo.leetcode.treeM;

/**
 * Created by leituo56 on 12/18/14.
 */
public class BinaryTreeUpsideDown {
    public TreeNode UpsideDownBinaryTree2(TreeNode root) {
        TreeNode cur = root;
        TreeNode nextNodeLeft = null;
        TreeNode nextNodeRight = null;
        while(cur!=null){
            TreeNode tmpL = cur.left;
            TreeNode tmpR = cur.right;

            cur.left = nextNodeLeft;
            cur.right = nextNodeRight;

            nextNodeLeft = tmpR;
            nextNodeRight = cur;

            cur = tmpL;
        }
        return nextNodeRight;
    }

    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if (root==null)
            return null;
        if(root.left==null)
            return root;
        TreeNode newNode = UpsideDownBinaryTree(root.left);
        TreeNode temp = newNode;
        while (temp.right!=null){
            temp = temp.right;
        }
        temp.right = root;
        temp.left = root.right;
        root.right = root.left = null;
        return newNode;
    }
}
