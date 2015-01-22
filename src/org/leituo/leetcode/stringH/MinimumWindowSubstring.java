//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//For example,
//S = "ADOBECODEBANC"
//T = "ABC"
//Minimum window is "BANC".
//
//Note:
//If there is no such window in S that covers all characters in T, return the emtpy string "".
//
//If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
package org.leituo.leetcode.stringH;

/**
 * Created by leituo56 on 1/22/15.
 */
public class MinimumWindowSubstring {
    class Solution{
        public String minWindow(String S, String T) {
            int[] needFind = new int[256];
            for(int i=0; i<T.length(); i++){
                needFind[T.charAt(i)]++;
            }
            int[] hadFound = new int[256];
            int min = Integer.MAX_VALUE;
            int minStart = 0;
            int minEnd = 0;
            int count = 0;//how many char had met
            for(int start=0,  end=0; end < S.length(); end++){
                char c = S.charAt(end);
                if(needFind[c] == 0)
                    continue;
                hadFound[c]++;
                if(hadFound[c] <= needFind[c])
                    count++;
                if(count == T.length()){//start to replace
                    while(hadFound[S.charAt(start)] == 0 || hadFound[S.charAt(start)] > needFind[S.charAt(start)]){
                        if(hadFound[S.charAt(start)] > needFind[S.charAt(start)])
                            hadFound[S.charAt(start)]--;
                        start++;
                    }
                    int cur = end - start + 1;
                    if(cur < min){
                        min = cur;
                        minStart = start;
                        minEnd = end;
                    }
                }
            }
            if(count < T.length())
                return "";
            return S.substring(minStart, minEnd + 1);
        }
    }
}
