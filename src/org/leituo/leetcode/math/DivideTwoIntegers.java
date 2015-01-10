//Divide two integers without using multiplication, division and mod operator.
//
//If it is overflow, return MAX_INT.
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 1/10/15.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;//only possible overflow
        long p = Math.abs((long) dividend);
        long q = Math.abs((long) divisor);

        int result = 0;
        for(int bit = Integer.SIZE - 1; bit >= 0 && p >= q; bit--){
            if(p >= q << bit){
                p = p - (q << bit);
                result = result | (1 << bit);
            }
        }
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            return -result;
        else
            return result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers test = new DivideTwoIntegers();
        System.out.println(test.divide(5, 2));
    }
}
