//Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
//
//For example, given the range [5, 7], you should return 4.
package org.leituo.leetcode.bitManipulation;

/**
 * Created by leituo56 on 4/21/15.
 */
public class BitwiseANDofNumbersRange {
    // 两个整数之间所有数的 & 结果
    class Solution {
        // & means if all numbers have the same value on same bit
        // if m & n is not same bit, than all the bit from this point is 0
        // question became what's the first bit that m and n become different
        public int rangeBitwiseAnd(int m, int n) {
            int result = 0;
            for(int i=31; i>=0; i--){
                int mBit = (m >> i) & 1;
                int nBit = (n >> i) & 1;
                if(mBit == nBit){
                    result = result | (mBit << i);
                }else{
                    break;
                }
            }
            return result;
        }
    }
}
