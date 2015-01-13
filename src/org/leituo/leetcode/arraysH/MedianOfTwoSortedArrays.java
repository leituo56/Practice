//There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
package org.leituo.leetcode.arraysH;

import java.util.Arrays;

/**
 * Created by leituo56 on 1/12/15.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if(len % 2 == 1)//odd
            return findKthElem(len/2 + 1, A, B);
        else//even
            return (findKthElem(len/2, A, B) + findKthElem(len/2 + 1, A, B)) / 2.0;
    }
    private double findKthElem(int k, int A[], int B[]){
        if(A.length > B.length)
            return findKthElem(k, B, A);
        if(A.length == 0)
            return B[k-1];
        if(k == 1)
            return Math.min(A[0], B[0]);
        int posA = Math.min(A.length, k/2);
        int posB = k - posA;

        if(A[posA - 1] < B[posB - 1]){
            return findKthElem(k - posA, Arrays.copyOfRange(A, posA, A.length), B);
        }else if(A[posA - 1] > B[posB - 1]){
            return findKthElem(k - posB, A, Arrays.copyOfRange(B, posB, B.length));
        }else{
            return A[posA - 1];
        }
    }
}
