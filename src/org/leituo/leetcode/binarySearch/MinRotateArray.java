//Suppose a sorted array is rotated at some pivot unknown to you beforehand.

//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//        Find the minimum element.
//
//        You may assume no duplicate exists in the array.
package org.leituo.leetcode.binarySearch;

/**
 * Created by leituo56 on 11/17/14.
 */
public class MinRotateArray {
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        if(num[start] < num[end])
            return num[0];
        while(end - start > 1){
            int mid = (start + end)/2;
            if(num[mid] > num[start])
                start = mid;
            else
                end = mid;
        }
        return num[end];
    }
}
