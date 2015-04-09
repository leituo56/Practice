//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//For example:
//Given the following binary tree,
//1            <---
///   \
//2     3         <---
//\     \
//5     4       <---
//You should return [1, 3, 4].
package org.leituo.leetcode.treeM;

import org.leituo.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by leituo56 on 4/7/15.
 */
public class BinaryTreeRightSideView {
    // 二叉树最右边的NODE组成一个LIST
    class Solution {
        //preorder, cur->right->left
        //if level>result.size, means it's the right most
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new LinkedList<Integer>();
            rightSideView(root, 0, result);
            return result;
        }
        public void rightSideView(TreeNode root, int level, List<Integer> result){
            if(root==null) return;
            if(level >= result.size())
                result.add(root.val);
            rightSideView(root.right, level+1, result);
            rightSideView(root.left, level+1, result);
        }
    }

    class SolutionLvOrder {
        //same as level order traversal, use a queue
        //using null as delimiter
        //when null, add the prev node to result
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new LinkedList<Integer>();
            if(root == null) return result;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            TreeNode cur = root;
            TreeNode prev = null;
            queue.offer(root);
            queue.offer(null);
            while(!queue.isEmpty()){
                prev = cur;
                cur = queue.poll();
                if(cur==null){
                    result.add(prev.val);
                    if(!queue.isEmpty())
                        queue.offer(null);
                    continue;
                }
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
            }
            return result;
        }
    }
}
