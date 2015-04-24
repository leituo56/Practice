//Given n items with size A[i], an integer m denotes the size of a backpack. How full you can fill this backpack?
//
//Example
//If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select 2, 3 and 5, so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
//
//You function should return the max size we can fill in the given backpack.
package org.leituo.lintcode.dp;

/**
 * Created by leituo56 on 4/23/15.
 */
public class BackPack {
    // dp[first_x_item][in_a_y_bag] to store the solution
    // for each item, you can either use it, or not use it
    // if not use it, just the same solution of first x-1 items
    // if use it, than find solution of first x-1 items of a y-curSize bag
    // dp[x][y] = max(dp[x-1][y], dp[x-1][y-SizeOfCurObj] + MassOfCurObj)
    class Solution {
        /**
         * @param m: An integer m denotes the size of a backpack
         * @param A: Given n items with size A[i]
         * @return: The maximum size
         */
        public int backPack(int m, int[] A) {
            if(m<=0 || A == null || A.length == 0)
                return 0;
            int len = A.length;
            //store solution of first i elem fit in a size j bag
            int[] prevSet = new int[m+1];//prev loop solution
            for(int i = 0; i < len; i++){
                int[] curSet = new int[m+1];//cur loop solution
                for(int j = 0; j <= m; j++){
                    if(A[i] > j){
                        curSet[j] = prevSet[j];
                    }else{
                        curSet[j] = Math.max(prevSet[j], prevSet[j-A[i]] + A[i]);
                    }
                }
                prevSet = curSet;
            }
            return prevSet[m];
        }
    }

    class SolutionOriginal {
        /**
         * @param m: An integer m denotes the size of a backpack
         * @param A: Given n items with size A[i]
         * @return: The maximum size
         */
        public int backPack(int m, int[] A) {
            if(m<=0 || A == null || A.length == 0)
                return 0;
            int len = A.length;
            int[][] dp = new int[len+1][m+1];//store solution for first i elem, j bag
            for(int i = 1; i <= len; i++){
                for(int j = 0; j <= m; j++){
                    int op1 = dp[i-1][j];
                    if(A[i-1] > j){
                        dp[i][j] = op1;
                    }else{
                        int op2 = dp[i-1][j-A[i-1]] + A[i-1];
                        dp[i][j] = (op2 > j)?op1:Math.max(op1, op2);
                    }
                }
            }
            return dp[len][m];
        }
    }
}
