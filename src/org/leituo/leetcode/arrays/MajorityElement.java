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
    // 求过半元素， 考点:Voting algorithm || 位运算
    class Solution {
        // Voting algorithm
        // since major elem have more occurrence than all else,
        // use counter to trace, guess cur as major elem, and ++counter
        // if cur != major, than --counter
        // if counter is 0, than make a new guess
        public int majorityElement(int[] num) {
            int result = 0;
            int counter = 0;
            for(int elem:num){
                if(counter == 0)
                    result = elem;
                if(elem == result)
                    counter++;
                else
                    counter--;
            }
            return result;
        }
    }

    class SolutionBit {
        //Vote for every bit
        //since maj elem will win every bit, so return the bit array result
        //time complexity is 32n
        public int majorityElement(int[] num) {
            int[] bitVoting = new int[32];
            for (int i = 0; i < 32; i++) {
                for (int elem : num) {
                    if (((elem >> i) & 1) > 0)
                        bitVoting[i]++;
                    else
                        bitVoting[i]--;
                }
            }
            int result = 0;
            for (int i = 0; i < 32; i++) {
                if (bitVoting[i] > 0)
                    result = result | (1 << i);
            }
            return result;
        }
    }
}
