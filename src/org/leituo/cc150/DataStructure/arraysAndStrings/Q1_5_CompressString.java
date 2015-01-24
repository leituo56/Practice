//  1.5 Implement a method to perform basic string compression using the counts of repeated characters.
//  For example, the string a a b c c c c c a a a would become a2blc5a3.
//  If the "compressed" string would not become smaller than the original string,
//  your method should return the original string.
package org.leituo.cc150.DataStructure.arraysAndStrings;

/**
 * Created by leituo56 on 10/27/14.
 */
public class Q1_5_CompressString {
    //O(n)
    public String compressString(String str){
        if(str == null || str.isEmpty())  return str;   //invalid
        char last = str.charAt(0);//first char
        int repeat = 1;
        StringBuffer dest = new StringBuffer();
        for (int i = 1; i < str.length() ; i++) {
            if (str.charAt(i) == last){ //Same as Prev
                repeat++;
            }else {   //Different than prev
                dest.append(last);
                dest.append(repeat);
                last = str.charAt(i);
                repeat = 1;
            }
        }
        dest.append(last).append(repeat);   //Last char and num
        if(dest.length()>=str.length())
            return str;
        return dest.toString();
    }
    public static void main(String[] args) {
        Q1_5_CompressString test = new Q1_5_CompressString();
        System.out.println(test.compressString("aaabbbcc"));
        System.out.println(test.compressString("aaa"));
        System.out.println(test.compressString("abbbbbbbc"));
        System.out.println(test.compressString("aabccwhatisit"));
    }
}
