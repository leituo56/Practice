//Implement atoi to convert a string to an integer.

//Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
//
//        Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
package org.leituo.leetcode.string;

/**
 * Created by leituo56 on 11/6/14.
 */
public class Atoi {
    public int atoi(String str) {
        int i=0;
        int sign = 1;
        int result = 0;
        while(i<str.length() && str.charAt(i)==' ')
            i++;
        if(i<str.length() && (str.charAt(i)=='-'|| str.charAt(i)=='+')){
            if(str.charAt(i) == '-')
                sign = -1;
            i++;
        }
        while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9'){
            if (result >  Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0' > 7))) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            result *= 10;
            result = result + str.charAt(i) - '0';
            i++;
        }
        return sign * result;
    }

    public static void main(String[] args) {
        Atoi test = new Atoi();
        System.out.println(test.atoi("123"));
    }
}
