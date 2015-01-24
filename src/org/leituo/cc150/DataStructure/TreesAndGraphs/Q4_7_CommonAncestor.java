//4.7 Design an algorithm and write code to find the first common ancestor of
// two nodes in a binary tree. Avoidstoring additional nodes in a data structure.
// NOTE: This is not necessarily a binary search tree.
package org.leituo.cc150.DataStructure.TreesAndGraphs;

/**
 * Created by leituo56 on 11/13/14.
 */
public class Q4_7_CommonAncestor {
    public Tree commonAncestor(Tree root, Tree p, Tree q){
        if (root==null)
            return null;
        if (root == p || root == q)
            return root;
        Tree left = commonAncestor(root.left, p, q);
        Tree right = commonAncestor(root.right, p, q);
        if(left!= null && right != null)
            return root;
        return left != null?left:right;
    }
}
