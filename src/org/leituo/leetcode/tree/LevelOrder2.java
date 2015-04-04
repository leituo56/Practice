//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
// level by level from leaf to root).

//For example:
//        Given binary tree {3,9,20,#,#,15,7},
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its bottom-up level order traversal as:
//        [
//        [15,7],
//        [9,20],
//        [3]
//        ]
package org.leituo.leetcode.tree;

import org.leituo.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 11/6/14.
 */
public class LevelOrder2 {
    class Solution{
        //same as levelorder1
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<TreeNode> queue = new LinkedList<TreeNode>();

            List<List<Integer>> result = new LinkedList<List<Integer>>();
            if(root == null)
                return result;
            queue.add(root);
            while(!queue.isEmpty()){
                List<Integer> numInLevel = new LinkedList<Integer>();
                //for each elem in queue
                queue.add(null);//delimiter
                while(!queue.isEmpty()){
                    TreeNode temp = queue.remove(0);
                    if(temp==null)
                        break;
                    //  form a list
                    numInLevel.add(temp.val);
                    //  put children of elem back to queue
                    if(temp.left!=null)
                        queue.add(temp.left);
                    if(temp.right!=null)
                        queue.add(temp.right);
                }
                result.add(0, numInLevel);
            }
            return result;
        }
    }

}
