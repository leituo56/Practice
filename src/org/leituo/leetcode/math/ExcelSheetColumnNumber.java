//Related to question Excel Sheet Column Title
//
//        Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//        For example:
//
//        A -> 1
//        B -> 2
//        C -> 3
//        ...
//        Z -> 26
//        AA -> 27
//        AB -> 28
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 1/1/15.
 */
public class ExcelSheetColumnNumber {
    //EXCEL 列名转数字，AA->27
    class Solution {
        //Think it as base 26
        //add new char = prev * 26 + cur
        //iterate from head to tail
        public int titleToNumber(String s) {
            int result = 0;
            if(s == null || s.length() == 0)
                return result;
            for(int i=0; i<s.length(); i++){
                int cur = s.charAt(i) - 'A' + 1;
                result = result * 26 + cur;
            }
            return result;
        }
    }
}
