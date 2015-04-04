//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
// then right to left for the next level and alternate between).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//  3
// / \
//9  20
//  /  \
// 15   7
//return its zigzag level order traversal as:
//[
//[3],
//[20,9],
//[15,7]
//]
package org.leituo.leetcode.tree;

import org.leituo.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 1/3/15.
 */
public class LevelOrderZigzag {
    class Solution{
        //Same as level order1
        //level to track odd or even
        //add to left or right base on odd or even
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            if(root == null)
                return result;
            List<TreeNode> queue = new LinkedList<TreeNode>();
            int level = 0;
            queue.add(root);
            while(!queue.isEmpty()){
                List<Integer> levelList = new LinkedList<Integer>();
                queue.add(null);
                while(!queue.isEmpty()){
                    TreeNode current = queue.remove(0);
                    if(current == null)
                        break;
                    if(current.left!=null)
                        queue.add(current.left);
                    if(current.right!=null)
                        queue.add(current.right);

                    if(level % 2 == 0)//left to right
                        levelList.add(current.val);
                    else//right to left
                        levelList.add(0, current.val);
                }
                level++;
                result.add(levelList);
            }
            return result;
        }
    }

}
