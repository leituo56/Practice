//Follow up for problem "Populating Next Right Pointers in Each Node".
//
//        What if the given tree could be any binary tree? Would your previous solution still work?
//
//        Note:
//
//        You may only use constant extra space.
//        For example,
//        Given the following binary tree,
//        1
//        /  \
//        2    3
//        / \    \
//        4   5    7
//        After calling your function, the tree should look like:
//        1 -> NULL
//        /  \
//        2 -> 3 -> NULL
//        / \    \
//        4-> 5 -> 7 -> NULL
package org.leituo.leetcode.treeM;

/**
 * Created by leituo56 on 12/8/14.
 */
public class PopulatingNextRightPointers2 {
    public void connect2(TreeLinkNode root){
        TreeLinkNode down = root;
        TreeLinkNode prev = null;
        while (down!=null){
            TreeLinkNode across = down;
            TreeLinkNode head = null;
            while (across!=null){
                if (across.left!=null){
                    if(prev!=null)
                        prev.next = across.left;
                    if(head==null)
                        head = across.left;
                    prev = across.left;
                }
                if (across.right!=null){
                    if(prev!=null)
                        prev.next = across.right;
                    if(head==null)
                        head = across.right;
                    prev = across.right;
                }
                across = across.next;
            }
            prev = null;
            down = head;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode down = root;
        while(down!=null){
            TreeLinkNode across = findNextAvailableParent(down);
            while(across != null){
                if(across.left!=null && across.right!=null){
                    across.left.next = across.right;
                }
                if(across.left!=null && across.right==null){
                    across.left.next = findNextAvailableChild(across.next);
                }
                if(across.right!=null){
                    across.right.next = findNextAvailableChild(across.next);
                }
                across = findNextAvailableParent(across.next);
            }
            down = findNextAvailableChild(down);
        }
    }
    private TreeLinkNode findNextAvailableParent(TreeLinkNode across){
        while(across!=null){
            if(across.left!=null || across.right!=null)
                return across;
            across = across.next;
        }
        return null;
    }
    private TreeLinkNode findNextAvailableChild(TreeLinkNode across){
        across = findNextAvailableParent(across);
        if (across==null)
            return null;
        else if(across.left!=null)
            return across.left;
        else
            return across.right;
    }
}
