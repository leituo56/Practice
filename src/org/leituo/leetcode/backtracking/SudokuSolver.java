//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//Empty cells are indicated by the character '.'.
//
//You may assume that there will be only one unique solution.
package org.leituo.leetcode.backtracking;

/**
 * Created by leituo56 on 1/19/15.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if(board == null)
            return;
        solve(board);
    }
    private boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c<='9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            if(solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int i, int j, char val){
        for(int row = 0; row < board.length; row++){
            if(board[row][j] == val && row!= i)
                return false;
        }
        for(int col = 0; col < board[0].length; col++){
            if(board[i][col] == val && col!= j)
                return false;
        }
        for(int row = i/3*3; row < i/3*3+3; row++){
            for(int col = j/3*3; col < j/3*3+3; col++){
                if(board[row][col] == val && row!=i && col!=j)
                    return false;
            }
        }
        return true;
    }
}
