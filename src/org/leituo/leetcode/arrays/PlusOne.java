//Given a non-negative number represented as an array of digits, plus one to the number.

//The digits are stored such that the most significant digit is at the head of the list.

package org.leituo.leetcode.arrays;

/**
 * Created by leituo56 on 10/31/14.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1] += 1;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i] < 10){
                break;
            }
            else{
                digits[i] = 0;
                digits[i-1] += 1;
            }
        }
        if(digits[0] < 10){
            return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        result[1] = 0;
        for(int i=2;i<result.length;i++){
            result[i] = digits[i-1];
        }
        return result;
    }
}
