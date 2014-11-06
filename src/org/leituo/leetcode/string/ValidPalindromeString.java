//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

//For example,
//        "A man, a plan, a canal: Panama" is a palindrome.
//        "race a car" is not a palindrome.
//
//        Note:
//        Have you consider that the string might be empty? This is a good question to ask during an interview.
//
//        For the purpose of this problem, we define empty string as valid palindrome.
package org.leituo.leetcode.string;

/**
 * Created by leituo56 on 11/6/14.
 */
public class ValidPalindromeString {
    public boolean isPalindrome(String s) {
        if(s.length()<2)
            return true;
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(left < s.length() && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while(right >= 0 && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if(left >= s.length() || right < 0){//move out
                return true;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeString test = new ValidPalindromeString();
        System.out.println(test.isPalindrome("aA"));
    }
}
