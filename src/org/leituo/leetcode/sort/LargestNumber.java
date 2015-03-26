//Given a list of non negative integers, arrange them such that they form the largest number.
//
//For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
//
//Note: The result may be very large, so you need to return a string instead of an integer.
package org.leituo.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by leituo56 on 1/22/15.
 */
public class LargestNumber {
    //一串数字如何连接构成最大数字
    class Solution{
        // use Arrays.sort(array, comparator) to sort
        // write a compare function with Anonymous class. s1s2 > s2s1?
        // notice all zero cases
        public String largestNumber(int[] num) {
            Comparator<String> comparator = new Comparator<String>(){
                @Override
                public int compare(String s1, String s2){
                    String s1s2 = s1 + s2;
                    String s2s1 = s2 + s1;
                    return -s1s2.compareTo(s2s1);
                }//e.g. 98, 9, just compare(989 and 998)
            };//Anonymous class
            String[] tmp = new String[num.length];
            for(int i=0; i<num.length; i++){
                tmp[i] = String.valueOf(num[i]);
            }//convert to string
            Arrays.sort(tmp, comparator);
            StringBuilder builder = new StringBuilder();
            for(String str:tmp){
                if(str.equals("0") && builder.length()==0){
                    builder.append('0');
                    break;//if str is zero, means all left is 0.
                }
                builder.append(str);
            }
            return builder.toString();
        }
    }
}
