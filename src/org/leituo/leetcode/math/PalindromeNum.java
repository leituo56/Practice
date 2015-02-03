//Implement a function to check if a number is a palindrome,
//  12321
//  overflow?
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 11/6/14.
 */
public class PalindromeNum {
    class Solution{
        //split x in the middle
        //use reverse to store from the right to left num
        //stop when x < reverse
        //return x==reverse || x==reverse/10
        public boolean isPalindrome(int x) {
            if(x < 0 || x!=0 && x%10==0)//no palindrom for 1210, e.g.
                return false;
            int reverse = 0;
            while(x > reverse){
                reverse = reverse * 10 + x % 10;
                x = x / 10;
            }
            return (x==reverse) || (x==reverse/10);
        }
    }

    class SolutionReverse{
        //reverse integer, have overflow problem
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

}
