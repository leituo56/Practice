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
    // 分数变无限循环小数
    class Solution{
        // a more concise version
        // use long to avoid overflow
        // change numerator and denominator to all positive or all negative, calculate the sign
        // use a HashMap to store remainder and occuring index
        // when a remainder appear before, then it's infinite loop, add ( and ) to the string
        // don't forget to add the sign and int part and . at the end
        public String fractionToDecimal(int numerator, int denominator) {
            if(denominator == 0)
                return null;
            StringBuilder result = new StringBuilder();
            int sign = (numerator >>> 31) ^ (denominator >>> 31);//1 for negative
            long num = numerator < 0 ? numerator:-numerator;//make to negative
            long deno = denominator < 0 ? denominator:-denominator;//make to negative
            long leftPart = num / deno;
            long remainder = num % deno;
            if(remainder == 0){
                if(sign==1 && leftPart!=0)
                    result.append("-");
                result.append(leftPart);
                return result.toString();
            }// no decimal condition
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            int index = 0;//trace where to insert (
            map.put(remainder, index);
            while(remainder != 0){// == 0 means no loop
                remainder = remainder * 10;
                long digit = remainder / deno;
                remainder = remainder % deno;
                result.append(digit);
                if(map.containsKey(remainder)){
                    result.insert(map.get(remainder), "(");//insert ( to the pos start to loop
                    result.append(")");//add ) to end
                    break;
                }
                map.put(remainder, ++index);
            }
            result.insert(0, leftPart + ".");
            if(sign==1)
                result.insert(0, "-");
            return result.toString();
        }
    }
    class SolutionIntuit{
        // Implementation for the first round of leetcode
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
    }

}
