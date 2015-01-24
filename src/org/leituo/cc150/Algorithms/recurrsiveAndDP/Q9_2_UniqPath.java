//Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can only move in two directions:
// right and down. How many possible paths are there for the robot to go from (0,0) to (X,Y)?


//FOLLOW UP
//Imagine certain spots are "off limits," such that the robot cannot step on them. Design an algorithm to find
// a path for the robot from the top left to the bottom right.
package org.leituo.cc150.Algorithms.recurrsiveAndDP;

/**
 * Created by leituo56 on 1/23/15.
 */
public class Q9_2_UniqPath {
    class Solution{
        public int uniqPath(int rowL, int colL){
            int[][] data = new int[rowL][colL];
            for (int i = 0; i < rowL; i++){
                data[i][0] = 1;
            }
            for (int i = 0; i < colL; i++){
                data[0][i] = 1;
            }
            for(int row = 1; row < rowL; row++){
                for (int col = 1; col < colL; col++){
                    data[row][col] = data[row-1][col] + data[row][col-1];
                }
            }
            return data[rowL-1][colL-1];
        }
    }
}
