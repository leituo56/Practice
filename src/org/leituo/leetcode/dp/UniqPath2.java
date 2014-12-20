//Follow up for "Unique Paths":
//
//        Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//        An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//        For example,
//        There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//        [
//        [0,0,0],
//        [0,1,0],
//        [0,0,0]
//        ]
//        The total number of unique paths is 2.
//
//        Note: m and n will be at most 100.
package org.leituo.leetcode.dp;

/**
 * Created by leituo56 on 12/20/14.
 */
public class UniqPath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        if(x < 1) return 0;
        int y = obstacleGrid[0].length;
        int[] data = new int[x+1];
        data[1] = obstacleGrid[0][0]==1?0:1;
        for(int i=0; i<y; i++){
            for(int j=1; j<=x; j++){
                data[j] = data[j-1] + data[j];
                if(obstacleGrid[j-1][i]==1)
                    data[j] = 0;
            }
        }
        return data[x];
    }
}
