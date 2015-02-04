//Implement regular expression matching with support for '.' and '*'.
//
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
//
//The matching should cover the entire input string (not partial).
//
//The function prototype should be:
//bool isMatch(const char *s, const char *p)
//
//Some examples:
//isMatch("aa","a") → false
//isMatch("aa","aa") → true
//isMatch("aaa","aa") → false
//isMatch("aa", "a*") → true
//isMatch("aa", ".*") → true
//isMatch("ab", ".*") → true
//isMatch("aab", "c*a*b") → true
package org.leituo.leetcode.dpHard;

/**
 * Created by leituo56 on 1/20/15.
 */
public class RegularExpressionMatching {
    class Solution{
        // dp, use 2D array [i, j] to store s.substring(0, i) is match p.substring(0, j)
        // init: "" == "" , so dp[0][0] is always true;
        // init: for "" match a*b*c*d*, set dp[0][2,4,6,8] = true
        // start double loop
        // find if there's a star after the pattern and cur pattern char is '.'
        // when star, there are 3 cases, use {str}{char} and {pattern}{char}* as example
        // 1. [i+1, j]: {str}{char} match {pattern}, last {char}* means 0 occurrence of char
        // 2. char match && [i, j]: {str} matches {pattern}, and {char} matches {char}
        // 3. char match && [i, j+2]: {str} matches {pattern}{char}*, and {char} matches {char}, means if str matches
        //      already, add as many {char} as you want
        // when not star, only 2 is acceptable
        public boolean isMatch(String s, String p) {
            if(s==null || p==null)
                return false;
            int sLen = s.length();
            int pLen = p.length();
            boolean[][] data = new boolean[sLen+1][pLen+1];
            data[0][0] = true;//"" match "" is true
            for(int i = 1; i<pLen; i++){
                if(p.charAt(i)!='*')
                    break;
                data[0][i+1] = true;
                i++;
            }
            for(int i=0; i<sLen; i++){
                for(int j=0; j<pLen; j++){
                    if(p.charAt(j)=='*')
                        continue;
                    boolean dot = p.charAt(j) == '.';
                    boolean star = (j+1 < pLen && p.charAt(j+1) == '*');
                    if(star){//(prev match prev || prev match prev+cur) && cur match, || prev + cur match prev
                        data[i+1][j+2] = ((data[i][j] || data[i][j+2]) && (dot || s.charAt(i) == p.charAt(j))) || data[i+1][j];
                    }else{//prev match && current char match
                        data[i+1][j+1] = data[i][j] && (dot || s.charAt(i) == p.charAt(j));
                    }
                }
            }
            return data[sLen][pLen];
        }
    }

    class SolutionRec{
        //not efficient enough, but easy to read
        //use {curS}{restS} and {curP}*{restP} as example
        //when star, there are two cases
        // 1. isMatch({curS}{restS}, {restP}) // 0 occur
        // 2. {curS} == {curP} and isMatch({restS}, {curP}*{restP})
        //else, {curS} == {curP} and isMatch({restS}, {restP})
        public boolean isMatch(String s, String p) {
            if(p.length() == 0)
                return s.length() == 0;
            if(p.length() == 1)
                return s.length() == 1 && (p.equals(s) || p.charAt(0)== '.');
            else{//2 or more chars pattern
                if(p.charAt(1) == '*'){// X*
                    if(isMatch(s, p.substring(2)))//0 occurance
                        return true;
                    return s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0)=='.')
                            && isMatch(s.substring(1), p);//
                }else{//not *, s not empty && first char match && remains match
                    return s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0)=='.')
                            && isMatch(s.substring(1), p.substring(1));
                }
            }
        }
    }

}
