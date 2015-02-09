//Implement strStr().

//Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//Rabin-Karp algorithm, KMP algorithm, and the Boyer- Moore algorithm
package org.leituo.leetcode.string;

/**
 * Created by leituo56 on 11/8/14.
 */
public class ImplementStrStr {
    class Solution{
        //Boyer Moore
        //right['a'] to store the right most ocur index of 'a';
        //compare from the behind
        //abbabbbabbd, abbd, [a->0, b->2, d->3]
        //abbd
        //   abbd
        //    abbd
        //       abbd
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0 || needle.equals(haystack))
                return 0;
            int R = 256;
            // position of rightmost occurrence of c in the pattern
            int[] right = new int[R];
            for (int c = 0; c < R; c++)
                right[c] = -1;
            for (int j = 0; j < needle.length(); j++)
                right[needle.charAt(j)] = j;
            int skip;
            for (int i = 0; i <= haystack.length() - needle.length(); i += skip) {
                skip = 0;
                for (int j = needle.length() - 1; j >= 0; j--) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        skip = Math.max(1, j - right[haystack.charAt(i + j)]);
                        break;
                    }
                }
                if (skip == 0)
                    return i; // found
            }
            return -1; // not found
        }
    }

    class SolutionBruteForce{
        public int strStr(String haystack, String needle) {
            if(needle.isEmpty())
                return 0;
            for(int i=0;i<haystack.length();i++){
                if(haystack.length()-i < needle.length())
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
    }

    class SolutionBFshort{
        public int strStr1(String haystack, String needle) {
            for (int i = 0; ; i++) {
                for (int j = 0; ; j++) {
                    if (j == needle.length()) return i;
                    if (i + j == haystack.length()) return -1;
                    if (needle.charAt(j) != haystack.charAt(i + j)) break;
                }
            }
        }
    }
}
