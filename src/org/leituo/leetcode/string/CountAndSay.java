//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//
//        1 is read off as "one 1" or 11.
//        11 is read off as "two 1s" or 21.
//        21 is read off as "one 2, then one 1" or 1211.
//        Given an integer n, generate the nth sequence.
//
//        Note: The sequence of integers will be represented as a string.
package org.leituo.leetcode.string;

/**
 * Created by leituo56 on 11/5/14.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        else{
            return read(countAndSay(n-1));
        }
    }
    public String read(String str){
        if(str==null || str.isEmpty())
            return str;
        char last = str.charAt(0);
        int count = 1;
        StringBuffer dest = new StringBuffer();
        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == last){
                count++;
            }else{
                dest.append(count);
                dest.append(last);
                count = 1;
                last = str.charAt(i);
            }
        }
        dest.append(count).append(last);
        return dest.toString();
    }
}
