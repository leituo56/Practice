//Given a binary tree, return the preorder traversal of its nodes' values.

//For example:
//        Given binary tree {1,#,2,3},
package org.leituo.leetcode.tree;

import org.leituo.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by leituo56 on 11/3/14.
 */
public class Preorder {
    class SolutionIt{
        //Stack to store
        //add stack.pop, push its right, and then left(notice last in first out)
        public List<Integer> preorderTraversal2(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if(root == null)
                return result;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode current = stack.pop();
                if(current==null)
                    continue;
                result.add(current.val);
                stack.push(current.right);
                stack.push(current.left);
            }
            return result;
        }
    }

    class SolutionRec{
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if(root == null)
                return result;
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
            return result;
        }
    }


}
