//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this in place with constant memory.
//        For example,
//        Given input array A = [1,1,2],
//
//        Your function should return length = 2, and A is now [1,2].
package org.leituo.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by leituo56 on 10/31/14.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        if(A.length < 2)
            return A.length;
        int result = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i]!=A[i-1]){
                A[result] = A[i];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray test = new RemoveDuplicatesfromSortedArray();
        int[] A = {1,1,2,4,8,8,11,11,14,14,15,15};
        int len = test.removeDuplicates(A);
        System.out.println(Arrays.toString(A));
        System.out.println(len);
    }
}
