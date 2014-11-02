//Given an array of integers, find two numbers such that they add up to a specific target number.
//The function twoSum should return indices of the two numbers such that they add up to the target,
// where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not
// zero-based.
//You may assume that each input would have exactly one solution.
//
//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2
package org.leituo.leetcode.arraysM;

import java.util.HashMap;

/**
 * Created by leituo56 on 11/1/14.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                result[0] = map.get(target-numbers[i]);
                result[1] = i+1;
                return result;
            }else{
                map.put(numbers[i], i+1);
            }
        }
        return result;
    }
}
