//A message containing letters from A-Z is being encoded to numbers using the following mapping:

//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given an encoded message containing digits, determine the total number of ways to decode it.
//
//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//The number of ways decoding "12" is 2.
package org.leituo.leetcode.dp;

/**
 * Created by leituo56 on 11/14/14.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s.length()==0)
            return 0;
        if(s.length()==1)
            return s.charAt(0)=='0'?0:1;
        int last1 = s.charAt(0)=='0'?0:1;
        int last2 = 1;
        int result = last1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'){
                if(isValid(s.charAt(i-1), s.charAt(i)) )
                    result = last2;
                else
                    return 0;
            }else if(isValid(s.charAt(i-1), s.charAt(i)) ){
                result = last1 + last2;
            }
            last2 = last1;
            last1 = result;
        }
        return result;
    }
    public boolean isValid(char a, char b){
        if(a=='1')
            return true;
        if(a=='2'){
            if(b>='0' && b<='6')
                return true;
        }
        return false;
    }
}
