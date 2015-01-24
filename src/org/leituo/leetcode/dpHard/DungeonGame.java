//The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
//
//The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
//
//Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
//
//In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
//
//
//Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
//
//For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
//
//-2 (K)	-3	    3
//-5	    -10	    1
//10	    30	    -5 (P)
//
//Notes:
//
//The knight's health has no upper bound.
//Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
package org.leituo.leetcode.dpHard;

/**
 * Created by leituo56 on 1/23/15.
 */
public class DungeonGame {
    class Solution{
        public int calculateMinimumHP(int[][] dungeon) {
            int rowL = dungeon.length;
            int colL = dungeon[0].length;
            int[][] hp = new int[rowL+1][colL+1];//min hp need before step on i, j point.
            for(int i=0; i<=rowL;i++)
                for(int j=0; j<=colL;j++)
                    hp[i][j] = Integer.MAX_VALUE;//like a wall
            hp[rowL][colL-1] = 1;//remian at least 1 health
            hp[rowL-1][colL] = 1;
            for(int row = rowL-1; row >=0 ; row--){
                for(int col = colL-1; col >=0; col--){
                    int needed = Math.min(hp[row+1][col], hp[row][col+1]) - dungeon[row][col];
                    hp[row][col] = needed <= 0? 1 : needed;
                }
            }
            return hp[0][0];
        }
    }
}
