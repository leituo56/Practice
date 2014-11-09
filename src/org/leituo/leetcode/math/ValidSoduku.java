//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 11/9/14.
 */
public class ValidSoduku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length;i++){
            int[] row = new int[9];
            int[] col = new int[9];
            int[] sqr = new int[9];
            for(int j=0; j<board[i].length;j++){
                //row
                if(board[i][j]!='.'){
                    int num = board[i][j] - '1';
                    if(row[num]!=0)
                        return false;
                    else
                        row[num] = 1;
                }
                //col
                if(board[j][i]!='.'){
                    int num = board[j][i] - '1';
                    if(col[num]!=0)
                        return false;
                    else
                        col[num] = 1;
                }
                //sqr
                if(board[3*(i%3)+j%3][3*(i/3)+j/3]!='.'){
                    int num = board[3*(i%3)+j%3][3*(i/3)+j/3] - '1';
                    if(sqr[num]!=0)
                        return false;
                    else
                        sqr[num] = 1;
                }

            }
        }
        return true;
    }
}
