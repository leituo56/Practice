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
    public String convert(String s, int nRows) {
        if(nRows == 1)
            return s;
        StringBuffer buff = new StringBuffer();
        for(int i=0;i<nRows;i++){
            int j = i;
            if(i==0 || i==nRows-1){
                while(j<s.length()){
                    buff.append(s.charAt(j));
                    j += 2 * nRows - 2;
                }
            }else{
                boolean flag = false;
                while(j<s.length()){
                    buff.append(s.charAt(j));
                    if(flag){
                        j += 2*i;
                        flag = false;
                    }else{
                        j += 2 * (nRows - i - 1);
                        flag = true;
                    }
                }
            }
        }
        return buff.toString();
    }

    public static void main(String[] args) {

    }
}
