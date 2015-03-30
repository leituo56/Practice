//Given an integer n, return the number of trailing zeroes in n!.
//
//        Note: Your solution should be in logarithmic time complexity.
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 1/1/15.
 */
public class FactorialTrailingZeroes {
    // 求阶乘尾部0的数量
    // Every 0 contribute by a 5 and 2 factor
    // since 2 is much more than 5, just calculate 5
    // Iterate by divided by 5.
    class Solution {
        public int trailingZeroes(int n) {
            int result = 0;
            while(n > 0){
                n /= 5;
                result += n;
            }
            return result;
        }
    }
}
