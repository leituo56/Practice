//Reverse digits of an integer.

//Example1: x = 123, return 321
//        Example2: x = -123, return -321
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 11/3/14.
 */
public class ReverseInt {
    public int reverse(int x) {
        int result = 0;
        while(x!=0){
            int r = x % 10;
            x = x / 10;
            result = result * 10 + r;
        }
        return result;
    }
}
