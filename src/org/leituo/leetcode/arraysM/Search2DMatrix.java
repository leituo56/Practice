//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

//Integers in each row are sorted from left to right.
//        The first integer of each row is greater than the last integer of the previous row.
//        For example,
//
//        Consider the following matrix:
//
//        [
//        [1,   3,  5,  7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 50]
//        ]
package org.leituo.leetcode.arraysM;

/**
 * Created by leituo56 on 12/8/14.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length<1 || matrix[0].length < 1)
            return false;
        int left = 0;
        int right = matrix.length -1;
        int len = matrix[0].length;
        if(target<matrix[0][0] || target > matrix[right][len-1])
            return false;
        while(left <= right){
            int mid = (left + right)/2;
            if(target < matrix[mid][0]){
                right = mid - 1;
            }else if(target > matrix[mid][len-1]){
                left = mid + 1;
            }else{
                return binarySearch(matrix[mid], target);
            }
        }
        return false;
    }
    private boolean binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = (left + right) /2;
            if(target > array[mid]){
                left = mid + 1;
            }else if(target < array[mid]){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
