//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//        For example:
//        Given "25525511135",
//
//        return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
package org.leituo.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 12/19/14.
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<String>();
        int[] digits = new int[s.length()];
        for(int i = 0; i<s.length(); i++){
            digits[i] = (s.charAt(i) - '0');
        }
        String prev = "";
        restoreIpAddresses(result, prev, digits, 0, 4);
        return result;
    }
    private void restoreIpAddresses(List<String> result, String prev, int[] digits, int start, int num){
        if(num < 0 || digits.length - start > num * 3)
            return;
        if(num == 0){
            result.add(prev.substring(0, prev.length() - 1));
            return;
        }
        if(start >= digits.length)
            return;
        //1 digits
        String append = prev + digits[start] + ".";
        restoreIpAddresses(result, append, digits, start+1, num - 1);
        //2 digits
        if(digits.length - start >= 2 && digits[start] != 0) {
            append = prev + digits[start] + digits[start + 1] + ".";
            restoreIpAddresses(result, append, digits, start + 2, num - 1);
        }
        //3 digits
        if(digits.length - start >= 3 && digits[start] != 0){
            if(digits[start] * 100 + digits[start + 1] * 10 + digits[start + 2] <= 255){
                append = prev + digits[start] + digits[start + 1] + digits[start + 2] + ".";
                restoreIpAddresses(result, append, digits, start + 3, num - 1);
            }
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses test = new RestoreIPAddresses();
//        List<String> result = test.restoreIpAddresses("25525511135");
        List<String> result = test.restoreIpAddresses("010010");
        for (String item:result){
            System.out.println(item);
        }
    }
}
