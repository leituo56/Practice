//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//For example,
//Given:
//s1 = "aabcc",
//s2 = "dbbca",
//
//When s3 = "aadbbcbcac", return true.
//When s3 = "aadbbbaccc", return false.
package org.leituo.leetcode.dpHard;

/**
 * Created by leituo56 on 1/22/15.
 */
public class InterleavingString {

    //DP, len(s1)*len(s2) memory
    class Solution2{
        //XX, YY interleave ZZZZ=> XX, Y il ZZZ && Z[3]==Y[1] || X, YY il ZZZ && Z[3]==X[1]
        public boolean isInterleave(String s1, String s2, String s3) {
            if(s1==null || s2==null || s3==null)
                return false;
            if(s3.length()!=s1.length() + s2.length())
                return false;
            //dp data, data[i][j] means s1(0,i), s2(0, j) is interleave with s3(0, i+j);
            boolean[][] data = new boolean[s1.length() + 1][s2.length() + 1];
            data[0][0] = true;
            for(int i = 1; i <= s1.length(); i++){
                data[i][0] = data[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
            }
            for(int j = 1; j <= s2.length(); j++){
                data[0][j] = data[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
            }
            for(int i = 1; i <= s1.length(); i++){
                for(int j = 1; j <= s2.length(); j++){
                    data[i][j] = data[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)
                            || data[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                }
            }
            return data[s1.length()][s2.length()];
        }
    }

    // Bad in memory, len(s3)*len(s3)
    class Solution1{
        public boolean isInterleave(String s1, String s2, String s3) {
            if(s1==null || s2==null || s3==null)
                return false;
            if(s3.length()!=s1.length() + s2.length())
                return false;
            //dp data, 0 for not visited, 1 for true, -1 for false
            int[][] s1s3 = new int[s1.length()+1][s3.length()+1];
            int[][] s2s3 = new int[s2.length()+1][s3.length()+1];
            return isInterleave(s1s3, s2s3, s1, 0, s2, 0, s3, 0);
        }
        private boolean isInterleave(int[][] s1s3, int[][] s2s3, String s1, int i1, String s2, int i2, String s3, int i3) {
            if(i1 == s1.length() || i2 == s2.length()){
                return s1.substring(i1).equals(s3.substring(i3)) || s2.substring(i2).equals(s3.substring(i3));
            }
            if(i1 < s1.length()){
                if(s1s3[i1][i3] != -1 && s1.charAt(i1)==s3.charAt(i3)){
                    if(s1s3[i1+1][i3+1] == 1 || isInterleave(s1s3, s2s3, s1, i1+1, s2, i2, s3, i3+1)){
                        s1s3[i1][i3] = 1;
                        return true;
                    }else s1s3[i1][i3] = -1;
                }else{
                    s1s3[i1][i3] = -1;
                }
            }
            if(i2 < s2.length()){
                if(s2s3[i2][i3] != -1 && s2.charAt(i2)==s3.charAt(i3)){
                    if(s2s3[i2+1][i3+1] == 1 || isInterleave(s1s3, s2s3, s1, i1, s2, i2+1, s3, i3+1)){
                        s2s3[i2][i3] = 1;
                        return true;
                    }else s2s3[i2][i3] = -1;
                }else{
                    s2s3[i2][i3] = -1;
                }
            }
            return false;
        }
    }
}
