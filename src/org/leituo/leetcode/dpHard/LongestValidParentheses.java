//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
//For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
//Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
package org.leituo.leetcode.dpHard;

import java.util.Stack;

/**
 * Created by leituo56 on 1/20/15.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        int left = -1;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(!stack.isEmpty()){//)
                stack.pop();
                max = Math.max(max, i - (stack.isEmpty()?left:stack.peek()));
            }else{//) && empty
                left = i;
            }
        }
        return max;
    }
}
