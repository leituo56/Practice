//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//        The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//        How many possible unique paths are there?
package org.leituo.leetcode.dp;

/**
 * Created by leituo56 on 12/6/14.
 */
//a1: Formula UP(m,n) = C(m-1 + n-1, n-1)
//a2: DP, UP(m,n) = UP(m-1, n) + UP(m, n-1)
public class UniqPath {
    //Math
    public int uniquePaths(int m, int n) {
        return combination(m-1+n-1, n-1);
    }
    private int combination(int m, int n){
        if(n > m / 2)   return combination(m, m - n);
        else{
            double result = 1;
            for(int i = 1; i <= n; i++){
                result *= m - n + i;
                result /= i;
            }
            return (int)result;
        }
    }

    //DP, memory can be optimized
    public int uniquePaths2(int m, int n) {
        if(m<=1 || n<=1) return 1;
        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++){
            grid[i][0] = 1;
        }
        for(int j=0;j<n;j++){
            grid[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }

    //DP, optimized
    public int uniquePaths3(int m, int n) {
        int[] data = new int[m+1];
        data[1] = 1;
        for(int i=0;i<n;i++){
            for(int j=1;j<=m;j++){
                data[j] = data[j-1] + data[j];
            }
        }
        return data[m];
    }
}
