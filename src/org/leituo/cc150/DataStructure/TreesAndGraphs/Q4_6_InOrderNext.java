//4.6 Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in
//a binary search tree. You may assume that each node has a link to its parent.
package org.leituo.cc150.DataStructure.TreesAndGraphs;

/**
 * Created by leituo56 on 11/13/14.
 */
public class Q4_6_InOrderNext {
    public Tree inOrderNext(Tree node){
        if (node==null)
            return null;
        if (node.right != null){
            Tree runner = node.right;
            while (runner.left!=null)
                runner = runner.left;
            return runner;
        }else {
            while (node.parent!= null && node.parent.right == node){
                node = node.parent;
            }
            return node.parent;
        }
    }
}
