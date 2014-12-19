//Follow up for "Find Minimum in Rotated Sorted Array":
//        What if duplicates are allowed?
//
//        Would this affect the run-time complexity? How and why?
//        Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//        Find the minimum element.
//
//        The array may contain duplicates.
package org.leituo.leetcode.binarySearch;

/**
 * Created by leituo56 on 12/18/14.
 */
public class MinRotateArray2 {
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        while(start < end){
            if(num[start] < num[end])
                return num[start];
            int mid = (start + end)/2;
            if(num[start] < num[mid]){
                start = mid + 1;
            }else if(num[start] > num[mid]){
                end = mid;
            }else{
                if(num[start]==num[end]){
                    start++;
                    end--;
                }else{
                    start = mid + 1;
                }
            }
        }
        return num[start];
    }
}
