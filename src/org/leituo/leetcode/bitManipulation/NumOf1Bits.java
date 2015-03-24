//Write a function that takes an unsigned integer and returns the number of ’1' bits
//it has (also known as the Hamming weight).
//
//For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
//so the function should return 3.
package org.leituo.leetcode.bitManipulation;

/**
 * Created by leituo56 on 3/23/15.
 */
public class NumOf1Bits {
    // you need to treat n as an unsigned value
    // 求一个uint32数2进制'1'的个数
    class Solution {
        //unsigned int has 32 bits
        //traverse, >>>1 for unsigned shift
        //1 & each bit
        public int hammingWeight(int n) {
            int result = 0;
            for(int i=0; i<32; i++){
                result += 1 & n;
                n = n >>> 1;
            }
            return result;
        }
    }
}
