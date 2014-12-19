//Follow up for "Remove Duplicates":
//        What if duplicates are allowed at most twice?
//
//        For example,
//        Given sorted array A = [1,1,1,2,2,3],
//
//        Your function should return length = 5, and A is now [1,1,2,2,3].
package org.leituo.leetcode.arrays;

/**
 * Created by leituo56 on 12/18/14.
 */
public class RemoveDuplicatesfromSortedArray2 {
    public int removeDuplicates2(int[] A) {
        if(A.length < 3)
            return A.length;
        int result = 2;
        for(int i=2; i<A.length; i++){
            if(A[result-2] != A[i]){
                A[result] = A[i];
                result++;
            }
        }
        return result;
    }
    public int removeDuplicates(int[] A) {
        if(A.length < 2)
            return A.length;
        boolean dup = false;
        int result = 1;
        for(int i=1; i<A.length; i++){
            if(A[i-1] == A[i]){
                if(!dup){
                    dup = true;
                    A[result] = A[i];
                    result++;
                }
            }else{
                dup = false;
                A[result] = A[i];
                result++;
            }
        }
        return result;
    }
}
