//Given preorder and inorder traversal of a tree, construct the binary tree.
package org.leituo.leetcode.treeM;

/**
 * Created by leituo56 on 1/3/15.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder == null || preorder.length!=inorder.length)
            return null;
        return BuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode BuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd)
            return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int offset = 0;
        while(inorder[inStart + offset] != rootVal){
            offset++;
        }
        root.left = BuildTree(preorder, preStart + 1, preStart + offset, inorder, inStart, inStart + offset - 1);
        root.right = BuildTree(preorder, preStart + offset + 1, preEnd, inorder, inStart + offset + 1, inEnd);
        return root;
    }
}
