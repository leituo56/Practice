//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//For example, given
//s = "leetcode",
//dict = ["leet", "code"].
//
//Return true because "leetcode" can be segmented as "leet code".
package org.leituo.leetcode.dp;

import java.util.Set;

/**
 * Created by leituo56 on 1/9/15.
 */
public class WordBreak {
    //DP, not retry proved substring from i to end;
    int[] noRetry;//from i index, there's no possible wordBreak;
    public boolean wordBreak(String s, Set<String> dict) {
        noRetry = new int[s.length()];
        return wordBreak(s, dict, 0);
    }
    private boolean wordBreak(String s, Set<String> dict, int start){
        if(noRetry[start] == 1)
            return false;
        for(int i = start; i < s.length(); i++){
            if(dict.contains(s.substring(start, i+1))){
                if(i+1 == s.length())
                    return true;//return statement
                if(wordBreak(s, dict, i + 1))
                    return true;
            }
        }
        noRetry[start] = 1;
        return false;
    }
}
