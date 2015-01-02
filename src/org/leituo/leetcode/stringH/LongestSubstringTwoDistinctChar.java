//Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//
//For example, Given s = “eceba”,
//
//T is "ece" which its length is 3.
package org.leituo.leetcode.stringH;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 1/1/15.
 */
public class LongestSubstringTwoDistinctChar {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length()==0)
            return 0;
        int max = 1;
        int oneStart = 0;
        int twoStart = 0;
        List<Character> queue = new LinkedList<Character>();
        queue.add(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            char current = s.charAt(i);
            if(current != s.charAt(i-1)){
                if(!queue.contains(current)){
                    twoStart = oneStart;
                }
                oneStart = i;
                if(queue.size() >= 2)
                    queue.remove(0);
                queue.add(current);
            }
            max = Math.max(max, i - twoStart + 1);
        }
        return max;
    }
}
