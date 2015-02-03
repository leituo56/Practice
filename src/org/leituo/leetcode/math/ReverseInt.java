//Reverse digits of an integer.

//Example1: x = 123, return 321
//        Example2: x = -123, return -321
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 11/3/14.
 */
public class ReverseInt {
    class Solution{
        // x % 10 to get the right most digit
        // x / 10 for next loop
        // result = result * 10 + right most digit
        // stop when x==0;
        public int reverse(int x) {
            long result = 0;
            while(x!=0){
                int r = x % 10;
                x = x / 10;
                result = result * 10 + r;
            }
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;
            return (int)result;
        }
    }
}
