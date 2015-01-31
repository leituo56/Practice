//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.

//Note:
//        Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//        The solution set must not contain duplicate triplets.
//        For example, given array S = {-1 0 1 2 -1 -4},
//
//        A solution set is:
//        (-1, 0, 1)
//        (-1, -1, 2)
package org.leituo.leetcode.arraysM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leituo56 on 11/1/14.
 */
public class ThreeSum {
    class Solution{
        //traverse each elem except 2 right most
        //for each elem, do 2sum from its right till end(left->, <-right)
        //skip when next elem is equal to current
        public List<List<Integer>> threeSum(int[] num) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            Arrays.sort(num);//O(nLogN)
            for(int i=0;i<num.length-2;i++){
                if(i>0 && num[i-1]==num[i])
                    continue;
                int left = i+1, right = num.length - 1;
                while(left<right){
                    int sum = num[i] + num[left] + num[right];
                    if(sum<=0){
                        if(sum==0){
                            List<Integer> temp = new ArrayList<Integer>();
                            temp.add(num[i]);
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

            return result;
        }
    }

}
