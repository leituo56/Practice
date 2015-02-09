//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this in place with constant memory.
//        For example,
//        Given input array A = [1,1,2],
//
//        Your function should return length = 2, and A is now [1,2].
package org.leituo.leetcode.arrays;


/**
 * Created by leituo56 on 10/31/14.
 */
public class RemoveDuplicatesfromSortedArray {
    class Solution{
        //return len if len <=1
        //loop from second elem, result = 1;
        //whenever cu!=prev, result++;
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
    }

}
