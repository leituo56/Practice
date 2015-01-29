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
    class Solution{
        // numtree(n) could use 1..n as root
        // for each root k, uniq number = numTree(left) * numTree(right)
        // that is, numTree(k-1) * numTree(n-k)
        public int numTrees(int n) {
            if(n==1 || n==0)
                return 1;
            int[] data = new int[n+1];
            data[0] = 1;
            data[1] = 1;
            for(int i=2;i<=n;i++){
                for(int root = 1;root <= i; root++){
                    data[i] += data[root-1] * data[i - root];
                }
            }
            return data[n];
        }
    }
}
