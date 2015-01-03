//Given inorder and postorder traversal of a tree, construct the binary tree.
package org.leituo.leetcode.treeM;

/**
 * Created by leituo56 on 1/3/15.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd)
            return null;
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int offset = 0;
        while(inorder[inStart + offset]!=rootVal){
            offset++;
        }
        root.left = buildTree(inorder, inStart, inStart + offset - 1, postorder, postStart, postStart + offset - 1);
        root.right = buildTree(inorder, inStart + offset + 1, inEnd,  postorder, postStart + offset, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal test = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        int[] inorder = {1,3,2};
        int[] postorder = {3,2,1};
        test.buildTree(inorder, postorder);
    }
}
