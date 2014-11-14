//4.5 Imp/emen t a function to check if a binary tree is a binary search tree.
package org.leituo.cc150.TreesAndGraphs;

/**
 * Created by leituo56 on 11/13/14.
 */
public class Q4_5_CheckBST {
    public boolean checkBST(Tree root){
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean checkBST(Tree root, int min, int max){
        if (root==null)
            return true;
        if (root.key <= min || root.key > max)
            return false;
        return checkBST(root.left, min, root.key) && checkBST(root.right, root.key, max);
    }
}
