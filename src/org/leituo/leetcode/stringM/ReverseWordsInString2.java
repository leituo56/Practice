//Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
//
//The input string does not contain leading or trailing spaces and the words are always separated by a single space.
//
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".
//
//Could you do it in-place without allocating extra space?
package org.leituo.leetcode.stringM;

/**
 * Created by leituo56 on 2/2/15.
 */
public class ReverseWordsInString2 {
    class Solution{
        public void reverseWords(char[] s) {
            if(s.length < 2)
                return;
            reverse(s, 0, s.length - 1);
            int left = 0;
            int right = 0;
            for(int i=0; i<s.length; i++){
                if(s[i]==' '){
                    right = i-1;
                    reverse(s, left, right);
                    left = i+1;
                }
            }
            reverse(s, left, s.length-1);
        }
        private void reverse(char[] s, int left, int right){
            while(left < right){
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }
    }
}
