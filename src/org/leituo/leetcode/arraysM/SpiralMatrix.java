//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//        For example,
//        Given the following matrix:
//
//        [
//        [ 1, 2, 3 ],
//        [ 4, 5, 6 ],
//        [ 7, 8, 9 ]
//        ]
//        You should return [1,2,3,6,9,8,7,4,5].
package org.leituo.leetcode.arraysM;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 12/18/14.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<Integer>();
        if(matrix.length==0)
            return result;
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int j=colStart; j<=colEnd; j++){
                result.add(matrix[rowStart][j]);
            }//top
            rowStart++;

            for(int i=rowStart; i<=rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }//right
            colEnd--;

            if(rowStart > rowEnd) continue;
            for(int j=colEnd; j>=colStart; j--){
                result.add(matrix[rowEnd][j]);
            }//bottom
            rowEnd--;

            if(colStart > colEnd) continue;
            for(int i=rowEnd; i>=rowStart; i--){
                result.add(matrix[i][colStart]);
            }//left
            colStart++;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix test = new SpiralMatrix();
        int[][] result = {{1,2,3}, {4,5,6}, {7,8,9}};
        List<Integer> list = test.spiralOrder(result);
        for (int elem:list){
            System.out.print(elem + ",");
        }
    }
}
