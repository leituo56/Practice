//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
package org.leituo.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leituo56 on 1/23/15.
 */
public class MaxPointsOnALine {
    /**
     * Definition for a point.
     * class Point {
     *     int x;
     *     int y;
     *     Point() { x = 0; y = 0; }
     *     Point(int a, int b) { x = a; y = b; }
     * }
     */
    class Solution{
        public int maxPoints(Point[] points) {
            if(points == null || points.length==0)
                return 0;
            int result = 1;
            double key;
            for (Point pointA : points) {
                Map<Double, Integer> map = new HashMap<Double, Integer>();
                int same = 1;
                for (Point pointB : points) {
                    if (pointA == pointB)//same reference
                        continue;
                    if (pointA.x == pointB.x && pointA.y == pointB.y){//same value
                        same++;
                        continue;
                    }
                    if (pointA.x == pointB.x && pointA.y != pointB.y)//vertical
                        key = Integer.MAX_VALUE;
                    else
                        key = (double) (pointA.y - pointB.y) / (double) (pointA.x - pointB.x);//slope
                    if (map.containsKey(key))
                        map.put(key, map.get(key) + 1);
                    else
                        map.put(key, 1);
                }
                int max = 0;
                for (Integer num : map.values()) {
                    max = Math.max(max, num);
                }
                result = Math.max(result, max + same);
            }
            return result;
        }
    }
    class Point{
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
}
