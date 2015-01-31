//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
// Return the sum of the three integers. You may assume that each input would have exactly one solution.

//For example, given array S = {-1 2 1 -4}, and target = 1.
//
//        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

package org.leituo.leetcode.arraysM;

import java.util.Arrays;

/**
 * Created by leituo56 on 11/1/14.
 */
public class ThreeSumClosest {
    class Solution{
        //same as 3 sum, sort, two pointers
        //use result to track the best answer
        //update when abs(result - target) > abs(sum - target)
        public int threeSumClosest(int[] num, int target) {
            int result = 0;
            if(num.length<=3){
                for (int elem : num) {
                    result += elem;
                }
                return result;
            }
            result = num[0] + num[1] + num[2];
            int[] temp = num.clone();
            Arrays.sort(temp);//O(logN)
            for(int i=0;i<temp.length - 2;i++){
                int left = i + 1;
                int right = temp.length -1;
                while(right>left){
                    int sum = temp[i] + temp[left] + temp[right];
                    if(sum==target){
                        return sum;
                    }else if(sum>target){
                        right--;
                    }else{
                        left++;
                    }
                    if(Math.abs(sum-target) < Math.abs(result-target)){
                        result = sum;
                    }//check if it's better
                }
            }
            return result;
        }
    }

}
