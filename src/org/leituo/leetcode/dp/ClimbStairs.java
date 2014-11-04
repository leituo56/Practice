//You are climbing a stair case. It takes n steps to reach to the top.

//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
package org.leituo.leetcode.dp;

/**
 * Created by leituo56 on 11/3/14.
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if(n<=1)
            return 1;
        int[] list = new int[n+1];
        for (int i=2; i<=n; i++){
            list[0] = 1;
            list[1] = 1;

            int sum = 1;
            for (int j = i-2; j>=0; j--){
                sum += list[j];
            }
            list[i] = sum;
        }
        return list[n];
    }
    public int fibonacci(int n){
        if(n==0 || n == 1)
            return 1;
        int[] mem = new int[2];
        mem[0] = mem[1] = 1;
        int sum = 0;
        for (int i=2; i<=n; i++){
            sum = mem[0] + mem[1];
            mem[0] = mem[1];
            mem[1] = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        ClimbStairs test = new ClimbStairs();
        for (int i = 0; i < 10 ; i++) {
            System.out.println(test.climbStairs(i));
        }
    }
}
