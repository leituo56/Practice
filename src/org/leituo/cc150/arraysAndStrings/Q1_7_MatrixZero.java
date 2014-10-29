//  1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.

package org.leituo.cc150.arraysAndStrings;

import java.util.Arrays;

/**
 * Created by leituo56 on 10/28/14.
 */
public class Q1_7_MatrixZero {
    //O(n^2)
    public void setMatrixZero(int[][] matrix){
        int height = matrix.length;
        int width = matrix[0].length;
        boolean[] isZeroRow = new boolean[height];
        boolean[] isZeroColumn = new boolean[width];
        for (int row=0;row<height;row++){
            for (int col=0;col<width;col++){
                if (matrix[row][col]==0){
                    isZeroRow[row] = true;
                    isZeroColumn[col] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(isZeroRow[i] || isZeroColumn[j])
                    matrix[i][j] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Q1_7_MatrixZero test = new Q1_7_MatrixZero();
        int[][] matrix = {
                {1,0,2,3,4},
                {5,6,0,7,8},
                {9,0,10,0,12},
                {11,13,14,15,16}
        };
        test.setMatrixZero(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
