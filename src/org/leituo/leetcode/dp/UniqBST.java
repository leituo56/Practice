//Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

//For example,
//Given n = 3, there are a total of 5 unique BST's.
//
//1         3     3      2      1
//\       /     /      / \      \
//3     2     1      1   3      2
///     /       \                 \
//2     1         2                 3
package org.leituo.leetcode.dp;

/**
 * Created by leituo56 on 11/16/14.
 */
public class UniqBST {
    //Tuo's solution
    public int numTrees(int n) {
        if(n==1)
            return 1;
        int[] table = new int[n];
        table[0] = 1;
        for(int i=1;i<n;i++){
            for(int j=i;j>=0;j--){
                table[j] = tableSum(j+1, table);
            }
        }
        return tableSum(n, table);
    }
    public int tableSum(int num, int[] arr){
        int sum = 0;
        for(int i=0;i<num;i++){
            sum += arr[i];
        }
        return sum;
    }

    //Optimized
    public int numTrees2(int n) {
        if(n==1 || n==0)
            return 1;
        int[] table = new int[n+1];
        table[0] = 1;
        table[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                table[i] += table[j] * table[i-j-1];
            }
        }
        return table[n];
    }
}
