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
    public int threeSumClosest(int[] num, int target) {
        int sum = 0, ans;
        if(num.length<=3){
            for(int i=0;i<num.length;i++){
                sum += num[i];
            }
            return sum;
        }
        ans = num[0] + num[1] + num[2];
        int[] temp = num.clone();
        Arrays.sort(temp);//O(logN)
        for(int i=0;i<temp.length;i++){
            int j = i + 1;
            int k = temp.length -1;
            while(k>j){
                sum = temp[i] + temp[j] + temp[k];
                if(sum==target){
                    return sum;
                }
                if(sum>target){
                    k--;
                }else{
                    j++;
                }
                if(Math.abs(sum-target) < Math.abs(ans-target)){
                    ans = sum;
                }//check if it's better
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSumClosest test = new ThreeSumClosest();
        int[] src = {-3,-2,-5,3,-4};
        int result = test.threeSumClosest(src, -1);
        System.out.println(result);
    }
}
