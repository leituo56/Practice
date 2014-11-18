//The gray code is a binary numeral system where two successive values differ in only one bit.

//Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
//
//For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
//
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//Note:
//For a given n, a gray code sequence is not uniquely defined.
//
//For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
//
//For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
package org.leituo.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leituo56 on 11/16/14.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result;
        if(n==0) {
            result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }
        if(n==1){
            result = new ArrayList<Integer>();
            result.add(0);
            result.add(1);
            return result;
        }
        result = grayCode(n-1);
        int len = (int)Math.pow(2, n - 1);
        for(int offset = 0;offset<len;offset++){
            result.add(result.get(len - offset - 1) + len);
        }
        return result;
    }

    public static void main(String[] args) {
        GrayCode test = new GrayCode();
        List<Integer> list = test.grayCode(0);
        System.out.println(list);
    }
}
