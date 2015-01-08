//Given a 2D board and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//For example,
//Given board =
//
//[
//["ABCE"],
//["SFCS"],
//["ADEE"]
//]
//word = "ABCCED", -> returns true,
//word = "SEE", -> returns true,
//word = "ABCB", -> returns false.
package org.leituo.leetcode.backtracking;

/**
 * Created by leituo56 on 1/7/15.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(exist(board, word, row, col))
                    return true;
            }
        }
        return false;
    }
    private boolean exist(char[][] board, String word, int row, int col){
        if(word.length() == 0)
            return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        if(board[row][col] != word.charAt(0))
            return false;
        String next = word.substring(1);
        board[row][col] = 0; //set to null
        boolean result = exist(board, next, row + 1, col)
                || exist(board, next, row - 1, col)
                || exist(board, next, row, col + 1)
                || exist(board, next, row, col - 1);
        board[row][col] = word.charAt(0);
        return result;
    }
}
