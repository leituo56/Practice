//Implement wildcard pattern matching with support for '?' and '*'.
//
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
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
//isMatch("aa", "*") → true
//isMatch("aa", "a*") → true
//isMatch("ab", "?*") → true
//isMatch("aab", "c*a*b") → false
package org.leituo.leetcode.dpHard;

/**
 * Created by leituo56 on 1/22/15.
 */
public class WildcardMatching {
    class SolutionDP2{
        //O(n^2) memory, straight forward
        public boolean isMatch(String s, String p) {
            int count = 0;
            //only for TLE
            for(int i = 0;i<p.length();i++){
                if(p.charAt(i)!='*')
                    count++;
                if(count>s.length())
                    return false;
            }
            boolean[][] data = new boolean[s.length() + 1][p.length() + 1];
            data[0][0] = true;
            for(int pi = 0;pi<=p.length();pi++){
                for(int si = 0;si<=s.length();si++){
                    if(si==0 && pi==0){
                        data[si][pi] = true;
                    }else if(si==0 && pi!=0){
                        data[si][pi] = data[si][pi-1] && p.charAt(pi-1)=='*';
                    }else if(pi==0 && si!=0) {
                        data[si][pi] = false;
                    }else{
                        if (p.charAt(pi-1) != '*') {
                            data[si][pi] = data[si - 1][pi - 1] && (p.charAt(pi - 1) == '?' || s.charAt(si - 1) == p.charAt(pi - 1));
                        } else {
                            data[si][pi] = data[si - 1][pi - 1] || data[si - 1][pi] || data[si][pi - 1];
                        }
                    }
                }
            }
            return data[s.length()][p.length()];
        }
    }

    class SolutionDP1{
        //O(n) memory, tricky corner case
        public boolean isMatch(String s, String p) {
            int count = 0;
            //only for TLE
            for(int i = 0;i<p.length();i++){
                if(p.charAt(i)!='*')
                    count++;
                if(count>s.length())
                    return false;
            }
            boolean[] data = new boolean[s.length() + 1];
            data[0] = true;
            boolean prev = true;
            for(int pi = 0;pi<p.length();pi++){
                for(int si = 0;si<s.length();si++){
                    if(si==0){
                        prev = data[si];//a new line
                        data[si] = data[si] && p.charAt(pi) == '*';
                    }
                    boolean temp = data[si + 1];
                    if(p.charAt(pi)!='*'){
                        data[si+1] = prev && (p.charAt(pi)=='?' || s.charAt(si)==p.charAt(pi));
                    }else{
                        data[si+1] = prev || data[si+1] || data[si];
                    }
                    prev = temp;
                }
            }
            return data[s.length()];
        }
    }
    public void test(){
//        System.out.println(new SolutionTLE().isMatch("aab", "c*a*b*"));
    }
    public static void main(String[] args) {
        WildcardMatching test = new WildcardMatching();
        test.test();
    }
}
