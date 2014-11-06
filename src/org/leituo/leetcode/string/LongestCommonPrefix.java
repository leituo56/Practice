//Write a function to find the longest common prefix string amongst an array of strings.
package org.leituo.leetcode.string;

/**
 * Created by leituo56 on 11/6/14.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length < 1)
            return "";
        if(strs.length == 1)
            return strs[0];
        String temp = strs[0];
        int index = temp.length() -1;
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length()==0)
                return "";
            if(strs[i].length() < index + 1){
                index = strs[i].length()-1;
            }
        }//get the shortest string right index
        int sameIndex = 0;
        while(sameIndex <= index){
            for(int j = 1; j< strs.length;j++){
                if(strs[j].charAt(sameIndex) != temp.charAt(sameIndex)){
                    return temp.substring(0,sameIndex);
                }
            }
            sameIndex++;
        }
        return temp.substring(0,sameIndex);
    }

    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] strs = {"bbbc", "bbba"};
        System.out.println(test.longestCommonPrefix(strs));
    }
}
