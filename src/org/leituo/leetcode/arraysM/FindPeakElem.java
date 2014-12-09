//A peak element is an element that is greater than its neighbors.

//Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
//
//        The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//
//        You may imagine that num[-1] = num[n] = -∞.
//
//        For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
package org.leituo.leetcode.arraysM;

/**
 * Created by leituo56 on 12/8/14.
 */
public class FindPeakElem {
    public int findPeakElement(int[] num) {
        return peakIndex(num, 0, num.length-1);
    }
    private int peakIndex(int[] num, int left, int right){
        if(left==right){
            return left;
        }
        int mid = (left + right) / 2;
        int mid1 = mid + 1;
        if(num[mid] > num[mid1]){
            return peakIndex(num, left, mid);
        }else{
            return peakIndex(num, mid1, right);
        }
    }
}
