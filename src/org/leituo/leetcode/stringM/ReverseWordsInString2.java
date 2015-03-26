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
    // 反转单词, "I love SJSU" => "SJSU love I"
    class Solution{
        // write a reverse helper method
        // reverse each word, by find spaces
        // reverse the whole string
        public void reverseWords(char[] s) {
            if(s == null || s.length < 2) return;
            int len = s.length;
            int left = 0;
            for(int i=0; i<len; i++){
                if(i == len - 1 || s[i+1]==' '){
                    reverse(s, left, i);
                    left = i + 2;
                }
            }
            reverse(s, 0, len - 1);
        }
        private void reverse(char[] s, int start, int end){
            while(start < end){
                char tmp = s[start];
                s[start++] = s[end];
                s[end--] = tmp;
            }
        }
    }
}
