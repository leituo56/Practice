//Say you have an array for which the ith element is the price of a given stock on day i.

//If you were only permitted to complete at most one transaction (ie, buy one and sell one
// share of the stock), design an algorithm to find the maximum profit.
package org.leituo.leetcode.greedy;

/**
 * Created by leituo56 on 11/9/14.
 */
public class BuySellStock1 {
    public int maxProfit(int[] prices) {
        if(prices.length<2)
            return 0;
        int min = prices[0];
        int profit = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else{
                if((prices[i] - min)>profit)
                    profit = prices[i] - min;
            }
        }
        return profit;
    }
}
