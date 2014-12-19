//Follow up for "Search in Rotated Sorted Array":
//        What if duplicates are allowed?
//
//        Would this affect the run-time complexity? How and why?
//
//        Write a function to determine if a given target is in the array.
package org.leituo.leetcode.binarySearch;

/**
 * Created by leituo56 on 12/8/14.
 */
public class SearchRotatedSortedArray2 {
    public boolean search(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(A[mid]==target) return true;
            if(A[left] < A[mid]){
                //min at right
                if(A[left] <= target && target < A[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else if(A[left] > A[mid]){
                //min at left
                if(A[mid] < target && target <= A[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                left++;
            }
        }
        return false;
    }
}
