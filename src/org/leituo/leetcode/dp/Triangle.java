//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to
// adjacent numbers on the row below.

//For example, given the following triangle
//[
//[2],
//[3,4],
//[6,5,7],
//[4,1,8,3]
//]
//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
//Note:
//Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
package org.leituo.leetcode.dp;

import java.util.List;

/**
 * Created by leituo56 on 11/9/14.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] temp = new int[triangle.size()];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<i+1;j++){
                int current = triangle.get(i).get(j);
                if(i==triangle.size()-1){
                    temp[j] = current;
                    continue;
                }
                int left = temp[j];
                int right = temp[j+1];
                temp[j] = current + Math.min(left, right);
            }
        }
        return temp[0];
    }
}
