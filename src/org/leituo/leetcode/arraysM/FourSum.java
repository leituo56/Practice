//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
// Find all unique quadruplets in the array which gives the sum of target.

//Note:
//        Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
//        The solution set must not contain duplicate quadruplets.
//        For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//
//        A solution set is:
//        (-1,  0, 0, 1)
//        (-2, -1, 1, 2)
//        (-2,  0, 0, 2)
package org.leituo.leetcode.arraysM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leituo56 on 11/1/14.
 */
public class FourSum {
    class Solution{
        //Same as 3 Sum
        //traverse for 2 layer
        //then 2 pointers
        //notice that skip the equals
        public List<List<Integer>> fourSum(int[] num, int target) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            Arrays.sort(num);
            for(int i=0;i<num.length-3;i++){
                if(i>0 && num[i] == num[i-1])
                    continue;
                for(int j=i+1;j<num.length-2;j++){
                    if(j>i+1 && num[j] == num[j-1] )
                        continue;
                    int left = j+1;
                    int right = num.length -1;
                    while(left<right){
                        int sum = num[i] + num[j] + num[left] + num[right];
                        if(sum <=target){
                            if(sum==target){
                                List<Integer> temp = new ArrayList<Integer>();
                                temp.add(num[i]);
                                temp.add(num[j]);
                                temp.add(num[left]);
                                temp.add(num[right]);
                                result.add(temp);
                            }
                            left++;
                            while(left<right && num[left]==num[left-1])
                                left++;
                        }else{
                            right--;
                            while(left<right && num[right]==num[right+1])
                                right--;
                        }
                    }
                }
            }
            return result;
        }
    }

}
