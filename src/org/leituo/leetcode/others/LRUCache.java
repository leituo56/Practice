//Design and implement a data structure for Least Recently Used (LRU) cache.
// It should support the following operations: get and set.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//set(key, value) - Set or insert the value if the key is not already present.
// When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
package org.leituo.leetcode.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leituo56 on 1/22/15.
 */
public class LRUCache {
    Map<Integer, Pair> map;
    ArrayList<Pair> order;
    int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Pair>();
        order = new ArrayList<Pair>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Pair cur = map.get(key);
            order.remove(cur);
            order.add(cur);
            return cur.value;
        }else{
            return -1;
        }
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            Pair cur = map.get(key);
            cur.value = value;
            order.remove(cur);
            order.add(cur);
        }else{
            Pair cur = new Pair(key, value);
            if(map.size() >= this.capacity){
                Pair delete = order.remove(0);
                map.remove(delete.key);
            }
            map.put(cur.key, cur);
            order.add(cur);
        }
    }
    class Pair{
        int key;
        int value;
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
