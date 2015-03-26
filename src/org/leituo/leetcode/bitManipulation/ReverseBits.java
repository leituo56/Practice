//Reverse bits of a given 32 bits unsigned integer.
//
//For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
// return 964176192 (represented in binary as 00111001011110000010100101000000).
//
//Follow up:
//If this function is called many times, how would you optimize it?
package org.leituo.leetcode.bitManipulation;

/**
 * Created by leituo56 on 3/23/15.
 */
public class ReverseBits {
    // 反转位
    class SolutionEasy {
        // copy bit from right to left, past from left to right
        public int reverseBits(int n) {
            int result = 0;
            for(int i=0; i<32; i++){
                result = result << 1;
                result = result | (1 & n);
                n = n >>> 1;
            }
            return result;
        }
    }
    class Solution {
        public int reverseBits(int n) {
            int result = 0;
            for(int i=0; i<32; i++){
                int tmp = 1 & (n >>> i);
                result = result | (tmp << (32 - i - 1));
            }
            return result;
        }
    }
}
