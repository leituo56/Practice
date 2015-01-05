//Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//
//If the fractional part is repeating, enclose the repeating part in parentheses.
//
//For example,
//
//Given numerator = 1, denominator = 2, return "0.5".
//Given numerator = 2, denominator = 1, return "2".
//Given numerator = 2, denominator = 3, return "0.(6)".
package org.leituo.leetcode.math;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by leituo56 on 1/4/15.
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long deno = denominator;
        long nume = numerator;
        StringBuilder result = new StringBuilder();
        if((nume > 0 && deno < 0) || (nume < 0 && deno > 0)){
            result.append("-");
            nume = Math.abs(nume);
            deno = Math.abs(deno);
        }
        result.append(nume/deno);
        long remainder = nume % deno;
        if(remainder == 0)
            return result.toString();
        result.append(".");
        //key: remainder, value: first occur pos
        Map<Long, Long> map = new HashMap<Long, Long>();//remainder maps
        long pos = 0;
        List<Long> list = new LinkedList<Long>();//store value
        while(remainder!=0){
            remainder = remainder * 10;
            long quotient = remainder / deno;
            if(map.containsKey(remainder)){
                //find the pos of this remainder
                pos = map.get(remainder);
                for(int i=0; i<pos; i++){
                    result.append(list.remove(0));
                }//no Recurring part
                result.append("(");
                while(!list.isEmpty()){
                    result.append(list.remove(0));
                }//Recurring part
                result.append(")");
                return result.toString();
            }else{
                list.add(quotient);
                map.put(remainder, pos);
                pos++;
            }
            remainder = remainder % deno;
        }
        while(!list.isEmpty()){
            result.append(list.remove(0));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal test = new FractionToRecurringDecimal();
        System.out.println(test.fractionToDecimal(15, 3));
        System.out.println(test.fractionToDecimal(-7, 5));
        System.out.println(test.fractionToDecimal(1, -3));
        System.out.println(test.fractionToDecimal(-10, 7));
        System.out.println(test.fractionToDecimal(1, 6));
    }
}
