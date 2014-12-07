//Given an array of integers, every element appears three times except for one. Find that single one.
//
//        Note:
//        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
package org.leituo.leetcode.bitManipulation;

/**
 * Created by leituo56 on 12/6/14.
 */
public class SingleNumber2 {
    public int singleNumber(int[] A) {
        int result = 0;
        for(int i=0;i<32;i++){
            int sum = 0;
            for (int elem : A) {
                if (((elem >> i) & 1) == 1) {
                    sum++;
                    sum = sum % 3;
                }
            }
            result |= (sum << i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,1,2,3,1,2,3,5};
        SingleNumber2 test = new SingleNumber2();
        System.out.println(test.singleNumber(data));
    }
}
