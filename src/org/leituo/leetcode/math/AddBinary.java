//Given two binary strings, return their sum (also a binary string).

//For example,
//        a = "11"
//        b = "1"
//        Return "100".
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 11/7/14.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        StringBuffer buff = new StringBuffer();
        int carry = 0;
        for(int i=1; i<=Math.max(lenA, lenB);i++){
            char ca = i<=lenA?a.charAt(lenA-i):'0';
            char cb = i<=lenB?b.charAt(lenB-i):'0';
            int ia = ca - '0';
            int ib = cb - '0';
            int sum = (ia + ib + carry) % 2;
            carry = (ia + ib + carry) / 2;
            buff.insert(0, sum);
        }
        if(carry>0)
            buff.insert(0, carry);
        return buff.toString();
    }
}
