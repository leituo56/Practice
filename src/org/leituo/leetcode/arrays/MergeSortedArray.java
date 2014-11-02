//Given two sorted integer arrays A and B, merge B into A as one sorted array.
//Note:You may assume that A has enough space (size that is greater or equal to m + n)
// to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

package org.leituo.leetcode.arrays;

/**
 * Created by leituo56 on 11/1/14.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int aEnd = m-1;
        int bEnd = n-1;
        for(int i=m+n-1;i>=0;i--){
            if(aEnd<0){
                A[i]=B[bEnd];
                bEnd--;
            }else if(bEnd<0){
                A[i]=A[aEnd];
                aEnd--;
            }
            else if(A[aEnd]>B[bEnd]){
                A[i]=A[aEnd];
                aEnd--;
            }else{
                A[i]=B[bEnd];
                bEnd--;
            }
        }
    }
}
