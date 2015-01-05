//Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//
//A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//For example,
//X X X X
//X O O X
//X X O X
//X O X X
//After running your function, the board should be:
//
//X X X X
//X X X X
//X X X X
//X O X X
package org.leituo.leetcode.others;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by leituo56 on 1/4/15.
 */
public class SurroundedRegions {
    private int rowLen;
    private int colLen;
    private boolean[][] visited;
    private char[][] board;

    public void solve(char[][] board) {
        if(board==null || board.length < 3 || board[0].length < 3)
            return;
        this.rowLen = board.length;
        this.colLen = board[0].length;
        this.visited = new boolean[rowLen][colLen];
        this.board = board;
        for(int row = 0; row < rowLen; row++){
            if(board[row][0] == 'O')
                fill(board, row, 0);
            if(board[row][colLen - 1] == 'O')
                fill(board, row, colLen - 1);
        }
        for(int col = 0; col < colLen; col++){
            if(board[0][col] == 'O')
                fill(board, 0, col);
            if(board[rowLen - 1][col] == 'O')
                fill(board, rowLen - 1, col);
        }
        for(int row = 0; row < rowLen; row++){
            for(int col = 0; col < colLen; col++){
                if(!visited[row][col] && board[row][col] == 'O')
                    board[row][col] = 'X';
            }
        }
    }
    private void fill(char[][] board, int row, int col){
        if(visited[row][col])
            return;
        Pair cur = new Pair(row, col);
        LinkedList<Pair> queue = new LinkedList<Pair>();
        queue.addLast(cur);
        while (!queue.isEmpty()){
            cur = queue.remove(0);
            if(!visited[cur.row][cur.col]) {
                visited[cur.row][cur.col] = true;
                if (worthVisit(cur.row + 1, cur.col))
                    queue.addLast(new Pair(cur.row + 1, cur.col));
                if (worthVisit(cur.row - 1, cur.col))
                    queue.addLast(new Pair(cur.row - 1, cur.col));
                if (worthVisit(cur.row, cur.col + 1))
                    queue.addLast(new Pair(cur.row, cur.col + 1));
                if (worthVisit(cur.row, cur.col - 1))
                    queue.addLast(new Pair(cur.row, cur.col - 1));
            }
        }
    }
    private boolean worthVisit(int row, int col){
        if(row < 0 || col < 0 || row >= rowLen || col >= colLen)
            return false;
        return !visited[row][col] && board[row][col] == 'O';
    }
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        SurroundedRegions test = new SurroundedRegions();
        char[][] map = {
                {'X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','X','X'},
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','X'},
                {'O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},
                {'O','O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','X','O','O','X'},
                {'X','O','O','O','X','O','O','O','O','O','X','O','X','O','X','O','X','O','X','O'},
                {'O','O','O','O','X','O','O','X','O','O','O','O','O','X','O','O','X','O','O','O'},
                {'X','O','O','O','X','X','X','O','X','O','O','O','O','X','X','O','X','O','O','O'},
                {'O','O','O','O','O','X','X','X','X','O','O','O','O','X','O','O','X','O','O','O'},
                {'X','O','O','O','O','X','O','O','O','O','O','O','X','X','O','O','X','O','O','X'},
                {'O','O','O','O','O','O','O','O','O','O','X','O','O','X','O','O','O','X','O','X'},
                {'O','O','O','O','X','O','X','O','O','X','X','O','O','O','O','O','X','O','O','O'},
                {'X','X','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','X','O','X','O','O','O','X','O','X','O','O','O','X','O','X','O','X','O','O'},
                {'O','O','X','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','X','O'},
                {'X','X','O','O','O','O','O','O','O','O','X','O','X','X','O','O','O','X','O','O'},
                {'O','O','X','O','O','O','O','O','O','O','X','O','O','X','O','X','O','X','O','O'},
                {'O','O','O','X','O','O','O','O','O','X','X','X','O','O','X','O','O','O','X','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','O','O','X','O','O','O','X','X','O','O','X','O','X','O','X','O','O'}
        };
        char[][] map2 = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','O','X'}
        };
        long time = System.currentTimeMillis();
        test.solve(map);
        for (char[] row:map){
            System.out.println(Arrays.toString(row));
        }
        time = System.currentTimeMillis() - time;
        System.out.println(time);
    }
}
