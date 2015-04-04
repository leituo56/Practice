//Try again
//Given a binary tree, return the inorder traversal of its nodes' values.

//For example:
//        Given binary tree {1,#,2,3},
package org.leituo.leetcode.tree;

import org.leituo.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by leituo56 on 11/3/14.
 */
public class InOrder {
    class SolutionIt{
        //traverse through left, push every left
        //if left==null, add the pop() value, and asign root to the poped right
        //loop until emtpy and root==null
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while(!stack.isEmpty() || root!=null){
                if(root!=null){
                    stack.push(root);
                    root = root.left;
                }else{
                    root = stack.pop();
                    result.add(root.val);
                    root = root.right;
                }
            }
            return result;
        }
    }

    class SolutionRec{
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<Integer>();
            if(root == null)
                return result;
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
            return result;
        }
    }

}
