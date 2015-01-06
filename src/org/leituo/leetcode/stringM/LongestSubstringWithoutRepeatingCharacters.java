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
    public int lengthOfLongestSubstring(String s) {
        //save index of last occurence of the char
        //max to track longest result by now
        // always make [maxLeft ~ i], no duplicates
        //update max if pos(char) - lastTimePos(char) > max
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int maxLeft = 0;
        for(int i = 0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur) && map.get(cur) >= maxLeft){
                maxLeft = map.get(cur) + 1;//update the posible left
            }
            max = Math.max(max, i - maxLeft + 1);
            map.put(cur, i);
        }
        return max;
    }
}
