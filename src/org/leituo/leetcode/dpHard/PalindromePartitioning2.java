//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return the minimum cuts needed for a palindrome partitioning of s.
//
//For example, given s = "aab",
//Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
package org.leituo.leetcode.dpHard;

/**
 * Created by leituo56 on 1/22/15.
 */
public class PalindromePartitioning2 {
    class Solution{
        // isPld(i, j) = s[i] == s[j] && isPld(i+1, j-1);
        public int minCut(String s) {
            if(s==null || s.length() == 0)
                return 0;
            boolean[][] isPld = new boolean[s.length()][s.length()];
            int[] minCut = new int[s.length()];
            for(int i = 0; i < s.length(); i++){
                minCut[i] = i;
            }//init worst case => equal its length;
            for(int i = 0; i < s.length(); i++){
                for(int j = 0; j <= i; j++){
                    if(isPld[i][j] || s.charAt(i)==s.charAt(j) && (i-j<=1 || isPld[i-1][j+1])){
                        isPld[i][j] = true;
                        minCut[i] = Math.min(minCut[i], j==0?0:minCut[j-1] + 1);
                    }
                }
            }
            return minCut[s.length() - 1];
        }
    }
}
