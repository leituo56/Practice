//Given a binary tree, return the postorder traversal of its nodes' values.
//
//        For example:
//        Given binary tree {1,#,2,3},
//        1
//        \
//        2
//        /
//        3
//        return [3,2,1].
//
//        Note: Recursive solution is trivial, could you do it iteratively?
package org.leituo.leetcode.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by leituo56 on 12/8/14.
 */
public class PostOrder {
    class SolutionIt{
        //post order left, right, root. reverse it as root, right, left
        //so same as preorder
        //use a stack
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new LinkedList<Integer>();
            if(root==null)
                return list;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode current = stack.pop();
                list.add(current.val);
                if(current.left!=null)
                    stack.push(current.left);
                if(current.right!=null)
                    stack.push(current.right);
            }
            Collections.reverse(list);

            return list;
        }
    }

    class SolutionRec{
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new LinkedList<Integer>();
            if(root == null)
                return list;
            list.addAll(postorderTraversal(root.left));
            list.addAll(postorderTraversal(root.right));
            list.add(root.val);
            return list;
        }
    }
}
