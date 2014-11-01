//Given an array and a value, remove all instances of that value in place and return the new length.

//The order of elements can be changed. It doesn't matter what you leave beyond the new length.
package org.leituo.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by leituo56 on 10/30/14.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int result = A.length;
        for(int i=0;i<result;i++){
            if(A[i]==elem){
                swap(A, i--, --result);
            }
        }
        return result;
    }
    public void swap(int[] A, int index1, int index2){
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
    public static void main(String[] args) {
        RemoveElement test = new RemoveElement();
        int[] A = {1,3,2,4,1,5,6,3,2,5,6};
        int len = test.removeElement(A, 2);
        System.out.println(Arrays.toString(A));
        System.out.println(len);

        int[] B = {3,3};
        len = test.removeElement(B, 3);

        System.out.println(Arrays.toString(B));
        System.out.println(len);
    }
}
