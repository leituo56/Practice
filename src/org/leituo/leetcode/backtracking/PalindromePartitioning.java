//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return all possible palindrome partitioning of s.
//
//For example, given s = "aab",
//Return
//
//[
//["aa","b"],
//["a","a","b"]
//]
package org.leituo.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 1/4/15.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<List<String>>();
        List<String> completed = new LinkedList<String>();
        partition(completed, s, result);
        return result;
    }
    private void partition(List<String> completed, String rest, List<List<String>> result){
        if(rest.length() == 0){
            result.add(new LinkedList<String>(completed));
        }
        for(int i = 1; i<=rest.length(); i++){
            if(isPalindrome(rest.substring(0, i))){
                completed.add(rest.substring(0, i));
                partition(completed, rest.substring(i), result);
                completed.remove(completed.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s){
        if(s.length() == 0)
            return false;
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
