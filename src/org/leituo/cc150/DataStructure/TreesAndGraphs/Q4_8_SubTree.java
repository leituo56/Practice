//4.8 You have two very large binary trees: Tl, with millions of nodes, and T2, with
//hundreds of nodes. Create an algorithm to decide if T2 is a subtree of Tl.
//A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2.
// That is, if you cut off the tree at node n, the two trees would be identical.

package org.leituo.cc150.DataStructure.TreesAndGraphs;

/**
 * Created by leituo56 on 11/13/14.
 */
public class Q4_8_SubTree {
    public boolean isSubTree(Tree src, Tree target){
        if (target==null)
            return true;
        if (src==null)
            return false;
        if (src.key==target.key)
            if (isSameTree(src, target))
                return true;
        return isSubTree(src.left, target) || isSubTree(src.right, target);

    }
    public boolean isSameTree(Tree p, Tree q){
        if (p==null && q==null)
            return true;
        if (p==null || q==null)
            return false;
        if (p.key != q.key)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
