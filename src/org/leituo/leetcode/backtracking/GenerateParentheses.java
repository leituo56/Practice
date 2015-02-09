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
    class Solution{
        //recursive solution
        //for each cases, either add ( or add )
        //track isValid by the num of ( not added yet, and ) need to add to form a valid parentheses

        public List<String> generateParenthesis(int n) {
            List<String> result = new LinkedList<String>();
            addParenthesis(result, "", n, 0);
            return result;
        }
        private void addParenthesis(List<String> result, String str, int leftNotAdded, int rightNeedAdded){
            if (leftNotAdded==0 && rightNeedAdded==0){
                result.add(str);
            }
            if(leftNotAdded>0)
                addParenthesis(result, str+"(", leftNotAdded-1, rightNeedAdded + 1);
            if (rightNeedAdded > 0){
                addParenthesis(result, str+")", leftNotAdded, rightNeedAdded - 1);
            }
        }
    }

}
