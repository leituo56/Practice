//Given two numbers represented as strings, return multiplication of the numbers as a string.
//
//        Note: The numbers can be arbitrarily large and are non-negative.
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 12/20/14.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        String n1 = new StringBuffer(num1).reverse().toString();
        String n2 = new StringBuffer(num2).reverse().toString();

        for(int i = 0; i<n2.length(); i++){
            int carry = 0;
            int i2 = n2.charAt(i) - '0';
            for (int j = 0; j<n1.length(); j++){
                int i1 = n1.charAt(j) - '0';
                int resultDigit = result[i+j];
                int sum = i1 * i2 + carry + resultDigit;
                carry = sum / 10;
                sum = sum % 10;
                result[i+j] = sum;
            }
            if(carry > 0)
                result[i + n1.length()] = carry;
        }
        StringBuilder fin = new StringBuilder();
        for (int elem:result){
            fin.append(elem);
        }
        while (fin.length() > 1 && fin.charAt(fin.length() - 1) == '0'){
            fin.deleteCharAt(fin.length() - 1);
        }
        return fin.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "0";
        String s2 = "0";
        MultiplyStrings test = new MultiplyStrings();
        String result = test.multiply(s1, s2);
        System.out.println(result);
    }
}
