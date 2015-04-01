//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
// the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
// it will automatically contact the police if two adjacent houses were broken into on the same night.
//
// Given a list of non-negative integers representing the amount of money of each house,
// determine the maximum amount of money you can rob tonight without alerting the police.
package org.leituo.leetcode.dp;

/**
 * Created by leituo56 on 3/31/15.
 */
public class HouseRobber {
    // 抢一串房子，知道房子里有多少钱，两个挨着的房子被抢就会报警，求能抢的最大钱数
    class Solution {
        // use dp, store the max gold robbin until x.
        // dp[x] = max(dp[x-2] + num[x], dp[x-1])
        // return the last elem of dp
        // can write concise with only two temp var indead of dp[], 2 to left and 1 to left
        public int rob(int[] num) {
            if(num == null || num.length == 0)
                return 0;
            if(num.length == 1)
                return num[0];
            int pre = num[0];//max gold robbed till 2 left to cur
            int adj = Math.max(num[0], num[1]);//max gold robbed till 1 left to cur
            for(int i = 2; i < num.length; i++){
                int op1 = pre + num[i];//option 1, choose cur + 2 to left
                int op2 = adj;//option 2, just choose left
                pre = adj;
                adj = Math.max(op1, op2);
            }
            return adj;
        }
    }
}
