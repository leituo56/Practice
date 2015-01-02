//Given an integer n, return the number of trailing zeroes in n!.
//
//        Note: Your solution should be in logarithmic time complexity.
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 1/1/15.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0;
        while(n > 0){
            result += n / 5;
            n = n / 5;
        }
        return result;
    }
}
