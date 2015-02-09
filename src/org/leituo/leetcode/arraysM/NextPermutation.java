//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//The replacement must be in-place, do not allocate extra memory.
//
//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
package org.leituo.leetcode.arraysM;
import java.util.Arrays;
/**
 * Created by leituo56 on 1/4/15.
 */
public class NextPermutation {
    class Solution{
        public void nextPermutation(int[] num) {
            if(num.length < 2)
                return;
            int curDigit = num.length - 2;
            int curMax = num.length - 1;
            while(curDigit>=0){
                if(num[curDigit] < num[curMax]){
                    //find the next bigger elem
                    int curMin = curMax;
                    for(int i = curDigit; i<num.length; i++){
                        if(num[curDigit] < num[i] && num[i] < num[curMin]){
                            curMin = i;
                        }
                    }
                    //and swap with cur
                    swap(num, curDigit, curMin);
                    //and then sort the rest
                    Arrays.sort(num, curDigit+1, num.length);
                    return;
                }else{
                    curMax = curDigit;
                    curDigit--;
                }
            }
            Arrays.sort(num);
        }
        private void swap(int[] num, int index1, int index2){
            int temp = num[index1];
            num[index1] = num[index2];
            num[index2] = temp;
        }
    }
}
