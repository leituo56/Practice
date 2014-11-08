//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
package org.leituo.leetcode.string;

import java.util.Stack;

/**
 * Created by leituo56 on 11/7/14.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<s.length();i++){
            char temp = s.charAt(i);
            if(temp=='(' || temp=='[' || temp=='{'){
                stack.push(temp);
            }else{
                if(temp==')'){
                    if(!stack.isEmpty() && stack.peek().equals('(')){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
                if(temp==']'){
                    if(!stack.isEmpty() && stack.peek().equals('[')){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
                if(temp=='}'){
                    if(!stack.isEmpty() && stack.peek().equals('{')){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }


}
