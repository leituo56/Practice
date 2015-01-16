//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Your goal is to reach the last index in the minimum number of jumps.
//
//For example:
//Given array A = [2,3,1,1,4]
//
//The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
package org.leituo.leetcode.greedy;


/**
 * Created by leituo56 on 1/15/15.
 */
public class JumpGame2 {
    public int jump(int[] A) {
        int step = 0;
        int max = 0;
        for(int i = 0, nextMax = max; i <= max && i < A.length; i++){
            if(max >= A.length - 1)
                return step;
            nextMax = Math.max(nextMax, i + A[i]);
            if(i==max){
                max = nextMax;
                step++;
            }
        }
        return max >= A.length - 1 ? step : -1;
    }
}
