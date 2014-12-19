package org.leituo.leetcode.arraysH;

import java.util.Stack;

/**
 * Created by leituo56 on 12/19/14.
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        int sum = 0;
        int left = 0;
        int right = A.length - 1;
        int leftMax=0, rightMax = 0;
        while(left < right){
            leftMax = Math.max(A[left], leftMax);
            rightMax = Math.max(A[right], rightMax);
            if(leftMax < rightMax){
                sum += leftMax - A[left];
                left++;
            }else{
                sum += rightMax - A[right];
                right--;
            }
        }
        return sum;
    }

    public int trap2(int[] A) {
        int startH = 0;
        Stack<Integer> stack = new Stack<Integer>();

        int sum = 0;
        for (int wall : A) {
            if (stack.isEmpty()) {
                if (wall > 0) {
                    startH = wall;
                    stack.push(wall);
                }
            } else {
                if (wall >= startH) {
                    stack.push(wall);
                    sum += collect(stack, startH);
                    startH = wall;
                }
                stack.push(wall);
            }
        }
        sum += collect(stack, startH);
        return sum;
    }
    private int collect(Stack<Integer> stack, int startH){
        if (stack.size() <= 2) {
            stack.clear();
            return 0;
        }
        int sum = 0;
        int endH = stack.pop();
        if(endH > startH)
            endH = startH;
        while (!stack.isEmpty()){
            if (endH > stack.peek()) {
                int cur = stack.pop();
                sum += endH - cur;
            }else{
                endH = stack.pop();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater test = new TrappingRainWater();
        int[] data = {1,7,5};
        System.out.println(test.trap2(data));
    }
}
