//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
//Given an integer n, return all distinct solutions to the n-queens puzzle.
//
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
//For example,
//There exist two distinct solutions to the 4-queens puzzle:
//
//[
//[".Q..",  // Solution 1
//"...Q",
//"Q...",
//"..Q."],
//
//["..Q.",  // Solution 2
//"Q...",
//"...Q",
//".Q.."]
//]
package org.leituo.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 1/3/15.
 */
public class NQueens {
    private List<String[]> result;
    private int limit;

    public List<String[]> solveNQueens(int n) {
        int[] queens = new int[n];
        this.limit = n;
        result = new LinkedList<String[]>();
        solveNQueens(queens, 0, 0);
        return result;
    }
    private void solveNQueens(int[] queens, int row, int col){
        if(row>=limit) {
            this.result.add(queensToString(queens));
        } else {
            for (int c = col; c<queens.length; c++){
                if(isSafe(queens, row, c)) {
                    queens[row] = c;
                    solveNQueens(queens, row + 1, 0);
                }
            }
        }
    }
    private boolean isSafe(int[] queens, int row, int col){
        for (int i=0; i<row; i++){
            if(queens[i] == col)
                return false;
            if(queens[i] + (row - i) == col)
                return false;
            if(queens[i] - (row - i) == col)
                return false;
        }
        return true;
    }
    private String[] queensToString(int[] queens){
        String[] result = new String[queens.length];
        for(int row = 0; row < queens.length; row++){
            StringBuilder line = new StringBuilder();
            for (int i =0; i<queens.length; i++){
                if(i==queens[row])
                    line.append("Q");
                else
                    line.append(".");
            }
            result[row] = line.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        NQueens test = new NQueens();
        List<String[]> result = test.solveNQueens(6);
        for (String[] solution:result){
            System.out.println("==================");
            for (String line:solution){
                System.out.println(line);
            }
        }
    }
}
