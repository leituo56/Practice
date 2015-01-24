//4.3 Given a sorted (increasing order) array with unique integer elements,
// write an algo- rithm to create a binary search tree with minimal height.
package org.leituo.cc150.DataStructure.TreesAndGraphs;

/**
 * Created by leituo56 on 11/2/14.
 */
public class Q4_3_ArrayToBST {
    public Tree arrayToBST(int[] a,  int start, int end){
        if(start>end){
            return null;
        }
        int index = (start + end)/2;
        int pivot = a[index];
        Tree root = new Tree(pivot);
        root.left = arrayToBST(a, start, index - 1);
        root.right = arrayToBST(a, index+1, end);
        return root;
    }
    public static void main(String[] args) {
        Q4_3_ArrayToBST test = new Q4_3_ArrayToBST();
        int[] array = {1,2,3,4,5,6,7,8,9};
        Tree tree = test.arrayToBST(array, 0, array.length-1);
        tree.inOrder();
    }
}
