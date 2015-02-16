//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//You may assume that the intervals were initially sorted according to their start times.
//
//Example 1:
//Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
//Example 2:
//Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//
//This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
package org.leituo.leetcode.sort;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 1/19/15.
 */
public class InsertInterval {
    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null)
            return null;
        List<Interval> result = new LinkedList<Interval>();
        boolean added = false;
        for(Interval elem:intervals){
            if(added || elem.start > newInterval.end || elem.end < newInterval.start){
                if(!added && elem.start > newInterval.end){
                    result.add(newInterval);
                    added = true;
                }
                result.add(elem);
            }else{
                newInterval.start = Math.min(elem.start, newInterval.start);
                newInterval.end = Math.max(elem.end, newInterval.end);
            }
        }
        if(!added)
            result.add(newInterval);
        return result;
    }
}
