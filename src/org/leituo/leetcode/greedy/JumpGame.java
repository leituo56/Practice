//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//For example:
//A = [2,3,1,1,4], return true.
//
//A = [3,2,1,0,4], return false.
package org.leituo.leetcode.greedy;

/**
 * Created by leituo56 on 1/3/15.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if(A.length <= 1)
            return true;
        int index = 0;
        int endIndex = 0;
        while(index <= endIndex){
            endIndex = Math.max(endIndex, index + A[index]);
            if(endIndex >= A.length - 1)
                return true;
            index++;
        }
        return false;
    }
}
