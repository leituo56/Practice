//Given a collection of intervals, merge all overlapping intervals.
//
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18]
package org.leituo.leetcode.others;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 1/17/15.
 */
public class MergeIntervals {
    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<Interval>();
        if(intervals == null || intervals.size()==0)
            return result;
        Comparator<Interval> comparator = new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        };
        Collections.sort(intervals, comparator);
        Interval cur = intervals.remove(0);
        for(Interval elem:intervals){
            if(elem.start <= cur.end){
                cur.end = Math.max(elem.end, cur.end);
            }else{
                result.add(cur);
                cur = elem;
            }
        }
        result.add(cur);
        return result;
    }
}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
