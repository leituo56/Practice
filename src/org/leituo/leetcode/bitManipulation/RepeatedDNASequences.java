//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
// When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
//Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//
//For example,
//
//Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//
//Return:
//["AAAAACCCCC", "CCCCCAAAAA"].

package org.leituo.leetcode.bitManipulation;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 3/25/15.
 */
public class RepeatedDNASequences {
    //DNA中找重复10位片段
    class Solution {
        // use 00, 01, 10, 11 for A, C, G, T
        // use an int[0xFFFFF] to store the occurence of sequence, save the first 10 first
        // traverse char by char, use shift and mask to get the new sequence
        // if occur once, add to the result
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> result = new LinkedList<String>();
            if(s==null || s.length() <= 10)
                return result;
            int[] data = new int[0x000FFFFF];//2 bit for 1 char, 10 char = 20 bit = 5*hex
            int cur = 0;
            for(int i = 0; i < 10; i++){
                int newChar = charTo2Bit(s.charAt(i));
                cur = cur << 2;
                cur |= newChar;
            }//init cur = the first 10 char
            data[cur] = 1;//set occurence of first 10 char to 1

            for(int i = 10; i < s.length(); i++){
                int newChar = charTo2Bit(s.charAt(i));
                cur = cur << 2;
                cur &= 0x000FFFFF;//use cur & mask to change left 12 bit to 0;
                cur |= newChar;
                if(data[cur]++ == 1)
                    result.add(s.substring(i - 9, i + 1));
            }
            return result;
        }
        private int charTo2Bit(char c){
            switch(c){
                case 'A': return 0;
                case 'C': return 1;
                case 'G': return 2;
                case 'T': return 3;
            }
            return 0;
        }
    }
}
