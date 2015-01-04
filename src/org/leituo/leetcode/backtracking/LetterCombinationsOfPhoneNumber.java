//Given a digit string, return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
//
//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
package org.leituo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 1/3/15.
 */
public class LetterCombinationsOfPhoneNumber {
    String[] phone = {
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };

    public List<String> letterCombinations2(String digits) {
        List<String> result = new ArrayList<String>();
        result.add("");
        char[] digitList = digits.toCharArray();
        for (char digit:digitList){
            int num = digit - '0';
            List<String> temp = new LinkedList<String>();
            for (int i = 0; i<phone[num].length(); i++){
                for (String oldEntry : result) {
                    StringBuilder entry = new StringBuilder();
                    entry.append(oldEntry);
                    entry.append(phone[num].charAt(i));
                    temp.add(entry.toString());
                }
            }
            result = temp;
        }
        return result;
    }

    public List<String> letterCombinations(String digits){
        if(digits.length() == 0) {
            List<String> result = new LinkedList<String>();
            result.add("");
            return result;
        }
        return letterCombinations(digits, 0);
    }
    private List<String> letterCombinations(String digits, int start){
        List<String> result = new LinkedList<String>();
        if(start >= digits.length())
            return result;
        int num = digits.charAt(start) - '0';
        List<String> list = letterCombinations(digits, start + 1);
        if(list.size() > 0){
            for (String right:list){
                for (int i=0; i<phone[num].length(); i++){
                    StringBuilder entry = new StringBuilder();
                    entry.append(phone[num].charAt(i));
                    entry.append(right);
                    result.add(entry.toString());
                }
            }
        }else {
            for (int i=0; i<phone[num].length(); i++){
                StringBuilder entry = new StringBuilder();
                entry.append(phone[num].charAt(i));
                result.add(entry.toString());
            }
        }
        return result;
    }
}
