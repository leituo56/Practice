//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//You may assume that the array is non-empty and the majority element always exist in the array.
package org.leituo.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leituo56 on 1/1/15.
 */
public class MajorityElement {
    //Voting algorithm
    public int majorityElement(int[] num) {
        int count = 0;
        int majNum = 0;
        for(int elem:num){
            if(count==0){
                majNum = elem;
                count = 1;
            }else if(elem == majNum){
                count++;
            }else{
                count--;
            }
        }
        return majNum;
    }

    //Intuit
    public int majorityElement2(int[] num) {
        int maxTimes = 1;
        int maxElem = num[0];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int elem:num){
            if(map.containsKey(elem)){
                int times = map.get(elem);
                if(++times > maxTimes){
                    maxTimes = times;
                    maxElem = elem;
                }
                map.put(elem, times);
            }else{
                map.put(elem, 1);
            }
            if(maxTimes > num.length / 2)
                return maxElem;
        }
        return maxElem;
    }
}
