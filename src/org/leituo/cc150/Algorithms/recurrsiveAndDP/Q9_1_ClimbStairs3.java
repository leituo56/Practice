//A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time.
// Implement a method to count how many possible ways the child can run up the stairs.

package org.leituo.cc150.Algorithms.recurrsiveAndDP;

/**
 * Created by leituo56 on 1/23/15.
 */
public class Q9_1_ClimbStairs3 {
    //cs[i] = cs[i-1] + cs[i-2] + cs[i-3]
    class Solution{
        public int climbStairs3(int stairs){
            int[] dp = {1, 1, 2};
            if(stairs < 3)
                return dp[stairs];
            int curStair = 3;
            int result = 0;
            while(curStair <= stairs){
                result = dp[0] + dp[1] + dp[2];
                dp[0] = dp[1];
                dp[1] = dp[2];
                dp[2] = result;
                curStair++;
            }
            return result;
        }
    }

}
