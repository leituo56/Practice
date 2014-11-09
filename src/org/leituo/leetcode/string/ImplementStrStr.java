//Implement strStr().

//Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//Rabin-Karp algorithm, KMP algorithm, and the Boyer- Moore algorithm
package org.leituo.leetcode.string;

/**
 * Created by leituo56 on 11/8/14.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())
            return 0;
        for(int i=0;i<haystack.length();i++){
            if(haystack.length()-i<needle.length())
                return -1;
            for(int j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)!=needle.charAt(j))
                    break;
                if(j==needle.length()-1)
                    return i;
            }
        }
        return -1;
    }
    public int strStr1(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    public static void main(String[] args) {
        ImplementStrStr test = new ImplementStrStr();
        System.out.println(test.strStr("ababababac", "ababac"));
    }
}
