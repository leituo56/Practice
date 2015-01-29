//Given two binary trees, write a function to check if they are equal or not.

//Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
package org.leituo.leetcode.tree;

/**
 * Created by leituo56 on 11/3/14.
 */
public class IsSameTree {
    class Solution{
        //brute force
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null && q==null)
                return true;
            if(p!=null && q!=null){
                if(p.val != q.val)
                    return false;
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }else{
                return false;
            }

        }
    }

}
