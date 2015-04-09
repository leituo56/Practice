// https://www.hackerrank.com/challenges/utopian-tree
// a tree height 1
// on spring, double its height
// on fall, plus 1 height
// input: num of test cases * {cycles}
// output: height of the three
package org.leituo.hackerRank.warmup;

import java.util.Scanner;

/**
 * Created by leituo56 on 4/7/15.
 */
public class UtopianTree {
    static int utpianTree(int cycle){
        int init = 1;
        for(int j=0; j<cycle; j++){
            if(j%2==0)
                init = init * 2;
            else
                init = init + 1;
        }
        return init;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            int cycle = in.nextInt();
            System.out.println(utpianTree(cycle));
        }
    }
}
