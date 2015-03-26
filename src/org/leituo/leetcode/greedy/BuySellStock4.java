//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete at most k transactions.
//
//Note:
//You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
package org.leituo.leetcode.greedy;

/**
 * Created by leituo56 on 3/24/15.
 */
public class BuySellStock4 {
    //买卖股票，最多交易K次，求最大利润
    class Solution {
        //dp[times][day]
        //max profit if sell today = max( [time-1, yesterday + buy yesterday sell today], [do nothing] )
        //max profit till today = max(yesterday, max profit if sell today)
        public int maxProfit(int k, int[] prices) {
            if(k > prices.length / 2) {
                int profit = 0;
                for(int i = 1; i < prices.length; ++i) {
                    profit += Math.max(0, prices[i] - prices[i - 1]);
                }
                return profit;
            }// if k > len/2, then means you can do as many trasaction as possible
            //dp, data[how many trasaction you can do][days]
            int[][] data = new int[k + 1][prices.length];
            for(int time = 1; time <= k; ++time) {
                int maxProfitIfSellToday = 0;
                for(int day = 1; day < prices.length; ++day) {
                    int diff = prices[day] - prices[day - 1];//new change if do nothing today
                    //use a transaction to buy yesterday and sell today, vs. do nothing(sell today instead of yesterday)
                    maxProfitIfSellToday = Math.max(data[time-1][day-1] + diff, maxProfitIfSellToday + diff);
                    //max profit if sell today, vs. max profit if not sell today(maxProfit yesterday)
                    data[time][day] = Math.max(maxProfitIfSellToday, data[time][day - 1]);
                }
            }
            return data[k][prices.length - 1];
        }
    }
}
