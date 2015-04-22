//Write an algorithm to determine if a number is "happy".
//
//A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
//Example: 19 is a happy number
//
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
package org.leituo.leetcode.math;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by leituo56 on 4/21/15.
 */
public class HappyNumber {
    // 每位平方和，是否最终能等于1
    class Solution {
        // running recursive
        // in case of dead loop, save each step to a set
        // if current sum existing in set, then it is a loop
        private Set<Integer> happySet = new HashSet<Integer>();
        public boolean isHappy(int n) {
            int sum = 0;
            while(n > 0){
                int cur = n % 10;
                sum = sum + cur * cur;
                n = n / 10;
            }
            if(happySet.contains(sum))
                return false;
            happySet.add(sum);
            if(sum == 1)
                return true;
            else return isHappy(sum);
        }
    }
}
