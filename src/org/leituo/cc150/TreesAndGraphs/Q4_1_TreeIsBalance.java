//4.1 Implement a function to check if a binary tree is balanced.
// For the purposes of this question, a balanced tree is defined to be a tree such
// that the heights of the two subtrees of any node never differ by more than one.
package org.leituo.cc150.TreesAndGraphs;

/**
 * Created by leituo56 on 11/1/14.
 */
public class Q4_1_TreeIsBalance {
    //O(n) time and O(h) space
    public boolean isTreeBalance(Tree t){
        if(t==null)
            return true;
        int hLeft = height(t.left);
        int hRight = height(t.right);
        if(hLeft == -1 || hRight == -1)
            return false;
        int diff = Math.abs(hLeft - hRight);
        if(diff > 1){
            return false;
        }else {
            return isTreeBalance(t.left) && isTreeBalance(t.right);
        }
    }
    public int height(Tree t){
        if (t==null)
            return 0;
        else {
            int hLeft = height(t.left);
            int hRight = height(t.right);
            if(hLeft == -1 || hRight == -1 || Math.abs(hLeft - hRight)>1)
                return -1;
            return Math.max(hLeft, hRight) + 1;
        }
    }
    public static void main(String[] args) {
        Q4_1_TreeIsBalance test = new Q4_1_TreeIsBalance();
        Tree t = new Tree(5);
        t.left = new Tree(3);
        t.right = new Tree(1);
        t.left.right = new Tree(4);
        t.left.left = new Tree(2);
        //t.left.left.right = new Tree(0);
        System.out.println(test.height(t));
        System.out.println(test.isTreeBalance(t));
    }
}
