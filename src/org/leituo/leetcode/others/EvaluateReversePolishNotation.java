//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//Some examples:
//["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
package org.leituo.leetcode.others;

import java.util.Stack;

/**
 * Created by leituo56 on 1/7/15.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for(String cur:tokens){
            if(cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/")){
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                if(cur.equals("+")){
                    cur = Integer.toString(op1 + op2);
                }else if(cur.equals("-")){
                    cur = Integer.toString(op1 - op2);
                }else if(cur.equals("*")){
                    cur = Integer.toString(op1 * op2);
                }else {
                    cur = Integer.toString(op1 / op2);
                }
            }
            stack.push(cur);
        }
        return Integer.parseInt(stack.peek());
    }
}
