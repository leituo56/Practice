//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//Write the code that will take a string and make this conversion given a number of rows:
package org.leituo.leetcode.string;

/**
 * Created by leituo56 on 11/7/14.
 */
public class ZigZagConversion {
    class Solution{
        //interval is 2*nRows - 2;
        //double loop, write row by row, i for rows, j for pair number of each row
        //patterns goes by i, i+Interval, i+2*Interval if i is first and last line
        //add an extra (Interval - i) + kInterval is they're in the middle
        public String convert(String s, int nRows) {
            if(nRows == 1)
                return s;
            StringBuilder buff = new StringBuilder();
            int interval = nRows * 2 - 2;
            for(int i = 0; i < nRows; i++){
                for(int j = 0; i + j * interval < s.length(); j++){
                    buff.append(s.charAt(i+j*interval));
                    if(i!=0 && i!= nRows - 1 && (interval-i) + j*interval < s.length())
                        buff.append(s.charAt((interval-i) + j*interval));
                }
            }
            return buff.toString();
        }
    }
}
