//Write a function to find the longest common prefix string amongst an array of strings.
package org.leituo.leetcode.string;

/**
 * Created by leituo56 on 11/6/14.
 */
public class LongestCommonPrefix {
    class Solution{
        //brute force
        //find the shortest str
        //for each pos, find each row of strs[], make sure they're equal
        //for every inner loop passed, add to result
        public String longestCommonPrefix(String[] strs) {
            if(strs.length < 1)
                return "";
            if(strs.length == 1)
                return strs[0];
            int shortest = Integer.MAX_VALUE;
            for(String str:strs){
                shortest = Math.min(shortest, str.length());
            }//find the shortest string len
            boolean stop = false;
            StringBuilder result = new StringBuilder();
            for(int i=0; i<shortest; i++){
                for(int row=0; row<strs.length-1; row++){
                    if(strs[row].charAt(i)!=strs[row+1].charAt(i))
                        stop = true;
                }
                if(!stop)
                    result.append(strs[0].charAt(i));
            }
            return result.toString();
        }
    }
}
