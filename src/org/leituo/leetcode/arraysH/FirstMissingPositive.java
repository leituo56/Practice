//Given an unsorted integer array, find the first missing positive integer.
//
//For example,
//Given [1,2,0] return 3,
//and [3,4,-1,1] return 2.
package org.leituo.leetcode.arraysH;

/**
 * Created by leituo56 on 1/16/15.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0)
            return 1;
        int len = A.length;
        for(int i=0; i<len; i++){
            while(A[i]>=1 && A[i] <=len && A[i] - 1 != i && A[i] != A[A[i] - 1]){
                swap(A, A[i] - 1, i);
            }//[1,len], not swap same index,  target value not equal to cur value
        }
        for(int i=0; i<len; i++){
            if(A[i] != i+1)
                return i + 1;
        }
        return len + 1;
    }
    private void swap(int[] A, int i1, int i2){
        int temp = A[i1];
        A[i1] = A[i2];
        A[i2] = temp;
    }
}
