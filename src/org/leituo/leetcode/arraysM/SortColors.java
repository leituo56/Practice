//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//        Note:
//        You are not suppose to use the library's sort function for this problem.
package org.leituo.leetcode.arraysM;

import java.util.Arrays;

/**
 * Created by leituo56 on 11/16/14.
 */
public class SortColors {
    public void sortColors(int[] A) {
        int red = -1, white = -1, blue = -1;
        for(int i=0;i<A.length;i++){
            if(A[i]==0){
                A[++blue] = 2;
                A[++white] = 1;
                A[++red] = 0;
            }else if(A[i] == 1){
                A[++blue] = 2;
                A[++white] = 1;
            }else{
                A[++blue] = 2;
            }
        }

    }

    public static void main(String[] args) {
        SortColors test = new SortColors();
        int[] arr = {0,1};
        test.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
