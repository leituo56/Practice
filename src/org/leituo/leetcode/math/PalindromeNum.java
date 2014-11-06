//Implement a function to check if a number is a palindrome,
//  12321
//  overflow?
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 11/6/14.
 */
public class PalindromeNum {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        return x==reverse(x);
    }
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
