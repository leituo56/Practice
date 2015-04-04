//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//        An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//        Find the total sum of all root-to-leaf numbers.
//
//        For example,
//
//        1
//        / \
//        2   3
//        The root-to-leaf path 1->2 represents the number 12.
//        The root-to-leaf path 1->3 represents the number 13.
//
//        Return the sum = 12 + 13 = 25.
package org.leituo.leetcode.treeM;

import org.leituo.utils.TreeNode;

import java.util.Stack;

/**
 * Created by leituo56 on 12/18/14.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    private int sumNumbers(TreeNode root, int sum){
        if(root==null)
            return 0;
        int result = sum*10 + root.val;
        if(root.left==null && root.right==null)
            return result;
        return sumNumbers(root.left, result) + sumNumbers(root.right, result);
    }

    public int sumNumbers2(TreeNode root) {
        int sum = 0;
        if(root==null)
            return sum;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.right!=null) {
                stack.push(cur.right);
                cur.right.val += cur.val * 10;
            }
            if(cur.left!=null) {
                stack.push(cur.left);
                cur.left.val += cur.val * 10;
            }
            if(cur.left==null && cur.right==null){
                sum += cur.val;
            }
        }
        return sum;
    }

}
