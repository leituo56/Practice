//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete as many transactions as you like
// (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
// transactions at the same time (ie, you must sell the stock before you buy again).

package org.leituo.leetcode.greedy;

/**
 * Created by leituo56 on 11/3/14.
 */
public class BuySellStock1 {
    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i=1; i<prices.length; i++){
            int profit = prices[i] - prices[i-1];
            if(profit > 0)
                result += profit;
        }
        return result;
    }
}
