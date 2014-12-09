//You are given an n x n 2D matrix representing an image.
//
//        Rotate the image by 90 degrees (clockwise).
//
//        Follow up:
//        Could you do this in-place?
package org.leituo.leetcode.arraysM;

/**
 * Created by leituo56 on 12/8/14.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for(int level = 0; level<size/2;level++){
            for(int offset = level; offset < size - level - 1; offset++){
                //temp top
                int temp = matrix[level][offset];
                //top = left
                matrix[level][offset] = matrix[size - offset - 1][level];
                //left = bottom
                matrix[size - offset - 1][level] = matrix[size - level - 1][size - offset - 1];
                //bottom = right
                matrix[size - level - 1][size - offset - 1] = matrix[offset][size - level - 1];
                //right = temp
                matrix[offset][size - level - 1] = temp;
            }
        }
    }
}
