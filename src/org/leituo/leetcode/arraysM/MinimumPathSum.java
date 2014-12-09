//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//        Note: You can only move either down or right at any point in time.
package org.leituo.leetcode.arraysM;

/**
 * Created by leituo56 on 12/8/14.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length==0 || grid[0].length==0)
            return 0;
        int height = grid.length;
        int width = grid[0].length;
        int[] data = new int[width + 1];

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(j==0) {
                    data[j + 1] = data[j + 1] + grid[i][j];
                }else if(i==0){
                    data[j + 1] = data[j] + grid[i][j];
                }else{
                    data[j + 1] = Math.min(data[j], data[j+1]) + grid[i][j];
                }
            }
        }
        return data[width];
    }

    public static void main(String[] args) {
        MinimumPathSum test = new MinimumPathSum();
        int[][] data = {{1,3, 1}, {1,5,1}, {4,2,1}};
        System.out.println(test.minPathSum(data));
    }
}
