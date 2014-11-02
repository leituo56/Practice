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
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);//O(nLogN)
        for(int i=0;i<num.length-2;i++){
            if(i>0 && num[i-1]==num[i])
                continue;
            int j = i+1, k = num.length - 1;
            while(j<k){
                int sum = num[i] + num[j] + num[k];
                if(sum<=0){
                    if(sum==0){
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        result.add(temp);
                    }
                    j++;
                    while(j<k && num[j]==num[j-1])
                        j++;
                }else{
                    k--;
                    while(j<k && num[k]==num[k+1])
                        k--;
                }
            }
        }

        return result;
    }
}
