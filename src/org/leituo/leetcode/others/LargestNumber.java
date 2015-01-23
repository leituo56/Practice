//Given a list of non negative integers, arrange them such that they form the largest number.
//
//For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
//
//Note: The result may be very large, so you need to return a string instead of an integer.
package org.leituo.leetcode.others;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by leituo56 on 1/22/15.
 */
public class LargestNumber {
    class Solution{
        public String largestNumber(int[] num) {
            Comparator<String> comparator = new Comparator<String>(){
                public int compare(String s1, String s2){
                    String s1s2 = s1 + s2;
                    String s2s1 = s2 + s1;
                    return -s1s2.compareTo(s2s1);
                }
            };
            String[] temp = new String[num.length];
            for (int i=0; i<num.length; i++){
                temp[i] = String.valueOf(num[i]);
            }
            Arrays.sort(temp, comparator);
            StringBuilder result = new StringBuilder();
            for(String str:temp){
                if (str.equals("0") && result.length()==0)
                    continue;
                result.append(str);
            }
            if(result.length()==0)
                result.append('0');
            return result.toString();
        }
    }
}
