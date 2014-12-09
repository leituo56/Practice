//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
// n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
// which together with x-axis forms a container, such that the container contains the most water.

//Note: You may not slant the container.
package org.leituo.leetcode.arraysM;

/**
 * Created by leituo56 on 12/8/14.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            max = Math.max(max, area(height, left, right));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
    private int area(int[] height, int left, int right){
        return (right - left) * Math.min(height[left], height[right]);
    }
}
