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
    public int titleToNumber(String s) {
        int sum = 0;
        char[] list = s.toCharArray();
        for (char c:list){
            int current = c - 'A';
            if(current >= 26 || current < 0)
                return 0;
            sum *= 26;
            sum += (current + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber test = new ExcelSheetColumnNumber();
        System.out.println(test.titleToNumber("AA"));
    }
}
