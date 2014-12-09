//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//        You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//        You may assume no duplicate exists in the array.
package org.leituo.leetcode.arraysM;

/**
 * Created by leituo56 on 12/8/14.
 */
public class SearchRotatedSortedArray {
    public int search(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(A[mid]==target) return mid;
            if(A[left] <= A[mid]){
                //min at right
                if(A[left] <= target && target <= A[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                //min at left
                if(A[mid] <= target && target <= A[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
