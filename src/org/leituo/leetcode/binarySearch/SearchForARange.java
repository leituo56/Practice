//Given a sorted array of integers, find the starting and ending position of a given target value.
//
//        Your algorithm's runtime complexity must be in the order of O(log n).
//
//        If the target is not found in the array, return [-1, -1].
//
//        For example,
//        Given [5, 7, 7, 8, 8, 10] and target value 8,
//        return [3, 4].
package org.leituo.leetcode.binarySearch;

import java.util.Arrays;

/**
 * Created by leituo56 on 12/20/14.
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        int left = 0;
        int right = A.length - 1;
        int[] lId = binarySearch(A, left, right, target);
        int[] rId = lId;
        while(lId[0] >= 0){
            result[0] = lId[1];
            lId = binarySearch(A, lId[0], lId[1] - 1, target);
        }
        while(rId[0] >= 0){
            result[1] = rId[1];
            rId = binarySearch(A, rId[1] + 1, rId[2], target);
        }
        return result;
    }
    public int[] binarySearch(int[] A, int left, int right, int target){
        int[] result = {-1, -1, -1};
        while(left <= right){
            int mid = (left + right) / 2;
            if(A[mid] < target){
                left = mid + 1;
            }else if(A[mid] > target){
                right = mid - 1;
            }else{
                result[0] = left;
                result[1] = mid;
                result[2] = right;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SearchForARange test = new SearchForARange();
        int[] data = {5, 7, 7, 8, 8, 10};
        int[] result = test.searchRange(data, 8);
        System.out.println(Arrays.toString(result));
    }
}
