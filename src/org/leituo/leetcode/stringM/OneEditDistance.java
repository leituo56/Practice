//Given two strings S and T, determine if they are both one edit distance apart.
//Insert, delete or update 1 char
package org.leituo.leetcode.stringM;

/**
 * Created by leituo56 on 12/20/14.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(Math.abs(sLen - tLen) > 1)
            return false;
        else if(sLen == tLen){
            if(s.equals(t)) return false;
            int diff = 0;
            for(int i = 0; i<sLen; i++){
                if(s.charAt(i)!=t.charAt(i))
                    diff++;
                if(diff > 1)
                    return false;
            }
        }else{
            int diff = 0;
            for(int i=0, j=0; i<sLen && j<tLen; i++, j++){
                if(s.charAt(i) != t.charAt(j)){
                    diff++;
                    if(diff > 1)
                        return false;
                    if(sLen > tLen)
                        j--;
                    else
                        i--;
                }
            }
        }
        return true;
    }
}
