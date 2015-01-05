//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//
//You have the following 3 operations permitted on a word:
//
//a) Insert a character
//b) Delete a character
//c) Replace a character
package org.leituo.leetcode.dpHard;

/**
 * Created by leituo56 on 1/4/15.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if(l1==0)
            return l2;
        if(l2==0)
            return l1;
        int[][] distances = new int[l1 + 1][l2 + 1];
        for(int i = 1; i<=l1; i++){
            distances[i][0] = i;
        }
        for(int j = 1; j<=l2; j++){
            distances[0][j] = j;
        }
        for(int i = 1; i<=l1; i++){
            char c1 = word1.charAt(i-1);
            for(int j=1; j<=l2; j++){
                char c2 = word2.charAt(j-1);
                //d(xxx, ###) = Min of d(xxx,##+) + 1, d(xx-, ###) + 1, d(xx-, ##-) + replaceCost
                //delete last l1 char, redo xx->###
                int case1 = distances[i-1][j] + 1;
                //redu xxx->##, and insert last l2 char
                int case2 = distances[i][j-1] + 1;
                //replace last l1 char to last l2 char, redo xx->##
                int replace = distances[i-1][j-1] + ((c1==c2)?0:1);

                distances[i][j] = Math.min(Math.min(case1, case2), replace);
            }
        }
        return distances[l1][l2];
    }
}
