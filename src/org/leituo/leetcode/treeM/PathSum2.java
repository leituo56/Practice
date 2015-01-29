//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

//For example:
//        Given the below binary tree and sum = 22,
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \    / \
//        7    2  5   1
//        return
//        [
//        [5,4,11,2],
//        [5,8,4,5]
//        ]
package org.leituo.leetcode.treeM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leituo56 on 11/9/14.
 */
public class PathSum2 {
    //Iterative


    class SolutionRec{
        //Recursive
        //use remains, same idea as pathSum1
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if(root==null)
                return result;
            if(root.val==sum && root.left==null && root.right==null){
                List<Integer> list = new ArrayList<Integer>();
                list.add(root.val);
                result.add(list);
                return result;
            }
            int remain = sum - root.val;
            for(List<Integer> list:pathSum(root.left, remain)){
                list.add(0, root.val);
                result.add(list);
            }
            for(List<Integer> list:pathSum(root.right, remain)){
                list.add(0, root.val);
                result.add(list);
            }
            return result;
        }
    }

}
