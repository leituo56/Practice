//Design and implement a TwoSum class. It should support the following operations: add and find.
//
//        add - Add the number to an internal data structure.
//        find - Find if there exists any pair of numbers which sum is equal to the value.
//
//        For example,
//        add(1); add(3); add(5);
//        find(4) -> true
//        find(7) -> false
package org.leituo.leetcode.arraysM;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leituo56 on 1/1/15.
 */
public class TwoSumClass {
    // 2 SUM 的类版本，Map迭代，Map.Entry用法
    // Map(number, occurrence) to store data
    // add to map, and plus one occurrence
    // for find, iterate map, and try to find the target
    // notice if cur==target, occurrence need to > 1
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public void add(int number) {
        if(map.containsKey(number))
            map.put(number, map.get(number) + 1);
        else
            map.put(number, 1);
    }

    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int current = entry.getKey();
            int target = value - current;
            if(current == target && entry.getValue() > 1)
                return true;
            if(current != target && map.containsKey(target))
                return true;
        }
        return false;
    }
}
