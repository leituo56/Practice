//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

//For example, this binary tree is symmetric:
//
//        1
//        / \
//        2   2
//        / \ / \
//        3  4 4  3
package org.leituo.leetcode.tree;

import java.util.Stack;

/**
 * Created by leituo56 on 11/5/14.
 */
public class SymmetricTree {
    class SolutionRec{
        //recursive
        // use isMirror helper
        public boolean isSymmetric2(TreeNode root) {
            if(root==null)
                return true;
            return isMirror(root.left, root.right);
        }
        public boolean isMirror(TreeNode left, TreeNode right){
            if(left == null && right == null)
                return true;
            return left!= null && right!=null && left.val==right.val &&
                    isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
    }
    class SolutionIt{
        //iterate
        //use 2 stacks to track
        public boolean isSymmetric(TreeNode root) {
            if(root == null || (root.left==null && root.right == null))
                return true;
            Stack<TreeNode> stackLeft = new Stack<TreeNode>();
            stackLeft.push(root.left);
            Stack<TreeNode> stackRight = new Stack<TreeNode>();
            stackRight.push(root.right);
            while(!stackLeft.isEmpty() && !stackRight.isEmpty()){
                TreeNode left = stackLeft.pop();
                TreeNode right = stackRight.pop();
                if(left==null && right == null){
                    continue;
                }
                if(!isEqualNode(left, right))
                    return false;
                stackLeft.push(left.left);
                stackLeft.push(left.right);
                stackRight.push(right.right);
                stackRight.push(right.left);
            }
            return true;
        }
        public boolean isEqualNode(TreeNode one, TreeNode two){
            if(one==null && two==null)
                return true;
            if(one==null || two==null)
                return false;
            if(one.val == two.val)
                return true;
            return false;
        }
    }

}
