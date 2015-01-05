//Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//Here is an example:
//S = "rabbbit", T = "rabbit"
//
//Return 3.
package org.leituo.leetcode.dpHard;

/**
 * Created by leituo56 on 1/4/15.
 */
public class DistinctSubsequences {
    //   , S, b, b, a, a, c
    // T , 1, 1, 1, 1, 1, 1
    // b , 0, 1, 2, 2, 2, 2
    // a , 0, 0, 0, 2, 4, 4

    //Basic idea: current = left + (if equal, leftTop)
    // [t][s] = [t][s-1] + (S[s-1]==T[t-1])?
    public int numDistinct(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        if(sLen < tLen)
            return 0;
        int[][] distincts = new int[tLen + 1][sLen + 1];
        for(int s = 0; s<=sLen; s++){
            distincts[0][s] = 1;
        }
        for(int s = 1; s<=sLen; s++){
            for(int t = 1; t<=tLen; t++){
                distincts[t][s] = distincts[t][s-1];
                if(S.charAt(s-1) == T.charAt(t-1))
                    distincts[t][s] += distincts[t-1][s-1];
            }
        }
        return distincts[tLen][sLen];
    }
}
