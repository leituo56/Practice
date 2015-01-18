//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//For example,
//Given height = [2,1,5,6,2,3],
//return 10.
package org.leituo.leetcode.others;

import java.util.Stack;

/**
 * Created by leituo56 on 1/16/15.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i<=height.length; i++){
            int compare = (i==height.length) ? 0 : height[i];
            if(!stack.isEmpty() && compare < height[stack.peek()]){
                while(!stack.isEmpty() && compare < height[stack.peek()]){
                    int h = height[stack.peek()];
                    stack.pop();
                    int start = stack.isEmpty()? 0 :stack.peek() + 1;
                    int len = i - start;
                    result = Math.max(result, h * len);
                }
            }
            stack.push(i);
        }
        return result;
    }
}
