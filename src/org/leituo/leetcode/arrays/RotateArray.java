//Rotate an array of n elements to the right by k steps.
//
//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//
//Note:
//Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
package org.leituo.leetcode.arrays;

/**
 * Created by leituo56 on 3/23/15.
 */
public class RotateArray {
    //旋转数组，把数组向右旋转K个INDEX
    class Solution {
        //brute force solution, move pointer to copyFrom Index
        //rotate will form several circles
        //use tmp val for each circle, and right shift after circle
        public void rotate(int[] nums, int k) {
            if (nums==null || nums.length==0) return;
            int len = nums.length;
            k = k % len;

            int cur = 0;
            int loopStart = cur;
            int tmp = nums[loopStart];
            for (int i=0; i < len; i++) {
                int copyFrom = (cur + len - k) % len;
                if(copyFrom == loopStart){//when circle
                    nums[cur] = tmp;
                    cur = (copyFrom + 1) % len;
                    loopStart = cur;
                    tmp = nums[loopStart];
                }else{
                    nums[cur] = nums[copyFrom];
                    cur = copyFrom;
                }
            }
        }
    }

    class SolutionRev {
        //think as reverse word
        //for len and k, move the right most k chars to the left
        //use reverse helper
        public void rotate(int[] nums, int k) {
            if (nums==null || nums.length==0) return;
            int len = nums.length;
            k = k % len;
            if(k==0) return;

            reverse(nums, 0, len - k - 1);
            reverse(nums, len - k, len - 1);
            reverse(nums, 0, len - 1);
        }
        private void reverse(int[] nums, int start, int end){
            while(start < end){
                int tmp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = tmp;
            }
        }
    }
}
