//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//        For example,
//        Given n = 3,
//
//        You should return the following matrix:
//        [
//        [ 1, 2, 3 ],
//        [ 8, 9, 4 ],
//        [ 7, 6, 5 ]
//        ]
package org.leituo.leetcode.arraysM;

/**
 * Created by leituo56 on 12/18/14.
 */
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int counter = 0;
        for(int level = 0; level < n/2; level++){
            for(int offset = level; offset < n - level - 1; offset++)
                result[level][offset] = ++counter;//top
            for(int offset = level; offset < n - level - 1; offset++)
                result[offset][n-level-1] = ++counter;//right
            for(int offset = level; offset < n - level - 1; offset++)
                result[n-level-1][n-offset-1] = ++counter;//bottom
            for(int offset = level; offset < n - level - 1; offset++)
                result[n-offset-1][level] = ++counter;//left
        }
        if(n%2==1)
            result[n/2][n/2] = ++counter;
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix2 test = new SpiralMatrix2();
        int[][] result = test.generateMatrix(5);
        for (int[] row : result) {
            for (int elem : row) {
                System.out.print(elem + ",");
            }
            System.out.println();
        }
    }
}
