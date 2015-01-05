//Follow up for N-Queens problem.
//
//Now, instead outputting board configurations, return the total number of distinct solutions.
package org.leituo.leetcode.backtracking;

/**
 * Created by leituo56 on 1/4/15.
 */
public class NQueens2 {
    private int count;
    private int limit;
    public int totalNQueens(int n) {
        this.count = 0;
        this.limit = n;
        int[] queens = new int[n];
        totalNQueens(queens, 0, 0);
        return count;
    }
    private void totalNQueens(int[] queens, int row, int col){
        if(row>=limit){
            count++;
            return;
        }
        for(int c = col; c<queens.length; c++){
            if(isValid(queens, row, c)){
                queens[row] = c;
                totalNQueens(queens, row+1, 0);
            }
        }
    }
    private boolean isValid(int[] queens, int row, int col){
        for(int i=0; i<row; i++){
            if(col == queens[i])
                return false;
            if(col == queens[i] + row - i)
                return false;
            if(col == queens[i] - (row - i))
                return false;
        }
        return true;
    }

    //bit manipulation, not fast at all!!
    private int queens;
    private int dd;
    private int du;

    public int totalNQueens2(int n){
        queens = -1;
        dd = -1;
        du = -1;
        return solve(n-1, queens, dd, du, 0);
    }
    private int solve(int n, int queens, int dd, int du, int col){
        if(col > n)
            return 1;
        int result = 0;
        for (int row = 0; row<=n; row++){
            int x = row + n - col;
            int y = row + col;
            if ((queens&(1<<row)) != 0 && (dd&(1<<x)) !=0 && (du&(1<<y))!=0) {
                queens ^= (1 << row);
                dd ^= (1 << x);
                du ^= (1 << y);

                result += solve(n, queens, dd, du, col+1);

                queens ^= (1 << row);
                dd ^= (1 << x);
                du ^= (1 << y);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NQueens2 test = new NQueens2();
        for (int i = 0; i<7; i++){
            System.out.println(test.totalNQueens2(i));
        }
    }
}
