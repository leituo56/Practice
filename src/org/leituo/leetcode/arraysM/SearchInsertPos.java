//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

//You may assume no duplicates in the array.
//
//Here are few examples.
//[1,3,5,6], 5 → 2
//[1,3,5,6], 2 → 1
//[1,3,5,6], 7 → 4
//[1,3,5,6], 0 → 0
package org.leituo.leetcode.arraysM;

/**
 * Created by leituo56 on 11/16/14.
 */
public class SearchInsertPos {
    public int searchInsert(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        int mid = 0;
        while(left<=right){
            mid = (left + right)/2;
            if(target == A[mid]){
                return mid;
            }else if(target < A[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5};
        int target = 1;
        SearchInsertPos test = new SearchInsertPos();
        int result = test.searchInsert(arr, target);
        System.out.println(result);
    }
}
