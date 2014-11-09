//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

//If the last word does not exist, return 0.
//
//        Note: A word is defined as a character sequence consists of non-space characters only.
//
//        For example,
//        Given s = "Hello World",
//        return 5.
package org.leituo.leetcode.string;

/**
 * Created by leituo56 on 11/8/14.
 */
public class LenthOfLastWord {
    public int lengthOfLastWord(String s) {
        int result = 0;
        int recentResult = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ')
                result++;
            else{
                if(result!=0)
                    recentResult = result;
                result = 0;
            }
        }
        return result>0?result:recentResult;
    }
}
