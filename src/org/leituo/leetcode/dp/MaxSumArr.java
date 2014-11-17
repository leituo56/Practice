//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
//For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
//        the contiguous subarray [4,−1,2,1] has the largest sum = 6.
package org.leituo.leetcode.dp;

/**
 * Created by leituo56 on 11/16/14.
 */
public class MaxSumArr {
    //Best Practice
    public int maxSubArray(int[] A) {
        int maxHere = A[0];
        int maxSoFar = A[0];
        for(int i=1;i<A.length;i++){
            maxHere = Math.max(maxHere+A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxHere);
        }
        return maxSoFar;
    }
}
