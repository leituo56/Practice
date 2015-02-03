//Given a string, find the length of the longest substring without repeating characters. For example, the longest
// substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the
// longest substring is "b", with the length of 1.
package org.leituo.leetcode.stringM;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leituo56 on 1/6/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    class Solution{
        //save index of last occurence of the char
        //max to track longest result by now
        // always make [left ~ i], no duplicates
        //update max if pos(char) - lastTimePos(char) > max
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 0;
            int left = -1;//last non-repeating left index till now
            for(int i=0; i<s.length(); i++){
                char cur = s.charAt(i);
                if(map.containsKey(cur)){
                    if(map.get(cur) > left)
                        left = map.get(cur);
                }
                max = Math.max(max, i - left);
                map.put(cur, i);
            }
            return max;
        }
    }

}
