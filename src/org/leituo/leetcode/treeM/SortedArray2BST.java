//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
package org.leituo.leetcode.treeM;

/**
 * Created by leituo56 on 11/16/14.
 */
public class SortedArray2BST {
    class Solution{
        //recursive method
        //find the mid as root
        //arr2BST left
        //arr2BST right
        //stop when start > end
        public TreeNode sortedArrayToBST(int[] num) {
            return sortedArrayToBST(num, 0, num.length-1);
        }
        public TreeNode sortedArrayToBST(int[] num, int start, int end){
            if(start>end)
                return null;
            int index = (start + end)/2;
            TreeNode result = new TreeNode(num[index]);
            result.left = sortedArrayToBST(num, start, index-1);
            result.right = sortedArrayToBST(num, index + 1, end);
            return result;
        }
    }

}
