//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//For example:
//
//1 -> A
//2 -> B
//3 -> C
//...
//26 -> Z
//27 -> AA
//28 -> AB
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 1/2/15.
 */
public class ExcelSheetColumnTitle {
    // Excel 数字转列名
    // Note that A is for 1,
    // n-- for each time to get the correct result, Z = 26 = 'A' + (26 - 1) % 26
    // try with some edge numbers to get intuition, like Z, AA
    class Solution{
        public String convertToTitle(int n) {
            StringBuilder result = new StringBuilder();
            while(n > 0){
                n--;
                char current = (char)('A' + n % 26);
                n = n / 26;
                result.insert(0, current);
            }
            return result.toString();
        }
    }
}
