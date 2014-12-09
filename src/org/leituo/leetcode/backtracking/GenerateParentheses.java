//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//        For example, given n = 3, a solution set is:
//
//        "((()))", "(()())", "(())()", "()(())", "()()()"
package org.leituo.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 12/8/14.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        addParenthesis(result, "", n, 0);
        return result;
    }
    private void addParenthesis(List<String> list, String str, int left, int rightLeft){
        if (left==0 && rightLeft==0){
            list.add(str);
        }
        if(left>0)
            addParenthesis(list, str+"(", left-1, rightLeft + 1);
        if (rightLeft > 0){
            addParenthesis(list, str+")", left, rightLeft - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses test = new GenerateParentheses();
        List<String> result = test.generateParenthesis(3);
        for (String str:result){
            System.out.println(str);
        }
    }
}
