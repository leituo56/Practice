//Given an input string, reverse the string word by word.
//
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".
//
//Clarification:
//What constitutes a word?
//A sequence of non-space characters constitutes a word.
//Could the input string contain leading or trailing spaces?
//Yes. However, your reversed string should not contain leading or trailing spaces.
//How about multiple spaces between two words?
//Reduce them to a single space in the reversed string.
package org.leituo.leetcode.stringM;

import java.util.Stack;

/**
 * Created by leituo56 on 1/6/15.
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        int i = s.length() - 1;
        while(i >= 0){
            char cur = s.charAt(i);
            if(cur != ' '){
                stack.push(cur);
                i--;
            }else{
                stackToBuilder(result, stack);
                while(i >= 0 && s.charAt(i)==' '){
                    i--;
                }//pass all 0;
                if(i >= 0 && s.charAt(i) != ' ')
                    result.append(' ');
            }
        }
        stackToBuilder(result, stack);
        return result.toString().trim();
    }
    private void stackToBuilder(StringBuilder builder, Stack<Character> stack){
        while(!stack.isEmpty()){
            builder.append(stack.pop());
        }
    }

    public static void main(String[] args) {
        ReverseWordsInString test = new ReverseWordsInString();
        System.out.println("[" + test.reverseWords("    what     the     Hell!!!    ") + "]");
    }
}
