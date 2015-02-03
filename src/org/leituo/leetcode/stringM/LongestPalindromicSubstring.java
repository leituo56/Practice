//Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
// and there exists one unique longest palindromic substring.
package org.leituo.leetcode.stringM;

/**
 * Created by leituo56 on 1/5/15.
 */
public class LongestPalindromicSubstring {
    class Solution{
        //mid part of palindrom always are either 'YXY' pattern or 'XX' pattern.
        //for each [pos], [pos-1, pos], try to expend to find the biggest one from this center
        public String longestPalindrome(String s) {
            if(s == null || s.length() <= 1)
                return s;
            String result = "";
            for(int i = 1; i < s.length(); i++){
                String expOdd = expend(s, i, i);
                String expEven = expend(s, i-1, i);
                if(expOdd.length() > result.length())
                    result = expOdd;
                if(expEven.length() > result.length())
                    result = expEven;
            }
            return result;
        }
        private String expend(String s, int left, int right){
            while(left >= 0 && right < s.length()){
                if(s.charAt(left)!=s.charAt(right))
                    break;
                left--;
                right++;
            }
            return s.substring(left+1, right);
        }
    }

}
