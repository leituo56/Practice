//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
//For example,
//Given n = 3, your program should return all 5 unique BST's shown below.
//
//1         3     3      2      1
//\       /     /      / \      \
//3     2     1      1   3      2
///     /       \                 \
//2     1         2                 3
package org.leituo.leetcode.dp;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 1/3/15.
 */
public class UniqBST2 {
    class SolutionRec{
        //recursive
        //use each number as root
        //generate left, and right
        //for each left*right, add current to the result
        public List<TreeNode> generateTrees(int n) {
            return generateTrees(1, n);
        }
        private List<TreeNode> generateTrees(int start, int end){
            List<TreeNode> result = new LinkedList<TreeNode>();
            if(start > end){
                result.add(null);
                return result;
            }
            for(int i = start; i<= end; i++){
                List<TreeNode> subLeft = generateTrees(start, i - 1);
                List<TreeNode> subRight = generateTrees(i + 1, end);
                for (TreeNode left : subLeft) {
                    for (TreeNode right : subRight) {
                        TreeNode current = new TreeNode(i);
                        current.left = left;
                        current.right = right;
                        result.add(current);
                    }
                }
            }
            return result;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
