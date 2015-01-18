//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
package org.leituo.leetcode.dpHard;

import java.util.Stack;

/**
 * Created by leituo56 on 1/16/15.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int result = 0;
        int[] data = new int[matrix.length];
        int rowL = matrix.length;
        int colL = matrix[0].length;
        for(int col = 0; col < colL; col++){
            for(int row = 0; row < rowL; row++){
                int cur = matrix[row][col] - '0';
                if(cur != 0){
                    data[row] += cur;
                }else{
                    data[row] = 0;
                }
            }
            result = Math.max(result, largestRectangleArea(data));
        }
        return result;
    }
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
