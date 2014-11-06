package org.leituo.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leituo56 on 11/6/14.
 */
public class Roman2Int {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] arr = s.toCharArray();
        int res = map.get(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (map.get(arr[i]) > map.get(arr[i - 1])) {
                res -= 2 * map.get(arr[i - 1]);
            }
            res += map.get(arr[i]);
        }
        return res;
    }
}
