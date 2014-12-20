//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//        For example,
//        Given [100, 4, 200, 1, 3, 2],
//        The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//        Your algorithm should run in O(n) complexity.
package org.leituo.leetcode.arraysH;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by leituo56 on 12/19/14.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        int maxLen = 0;
        for(int elem:num){
            set.add(elem);
        }
        for (int elem:num){
            if (set.contains(elem)) {
                int len = 0;
                int next = elem;
                while (set.contains(next)) {
                    set.remove(next);
                    len++;
                    next--;

                }
                next = elem + 1;
                while (set.contains(next)) {
                    set.remove(next);
                    len++;
                    next++;

                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence test = new LongestConsecutiveSequence();
        int[] data = new int[10000];
        for(int i=0; i<10000; i++){
            data[i] = i;
        }
        long time;
        for(int i=0; i<10; i++) {
            time = System.currentTimeMillis();
            System.out.print(test.longestConsecutive(data) + ",");
            time = System.currentTimeMillis() - time;
            System.out.print(time + "\n");
        }
    }
}
