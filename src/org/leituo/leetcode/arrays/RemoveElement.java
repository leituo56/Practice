//Given an array and a value, remove all instances of that value in place and return the new length.

//The order of elements can be changed. It doesn't matter what you leave beyond the new length.
package org.leituo.leetcode.arrays;


/**
 * Created by leituo56 on 10/30/14.
 */
public class RemoveElement {
    class Solution{
        //result is always the len
        //loop
        //when found one, swap it to the end, and result--, i--(to make sure at the same index)
        public int removeElement(int[] A, int elem) {
            int result = A.length;
            for(int i=0;i<result;i++){
                if(A[i]==elem){
                    swap(A, i--, --result);
                }
            }
            return result;
        }
        public void swap(int[] A, int index1, int index2){
            int temp = A[index1];
            A[index1] = A[index2];
            A[index2] = temp;
        }
    }

}
