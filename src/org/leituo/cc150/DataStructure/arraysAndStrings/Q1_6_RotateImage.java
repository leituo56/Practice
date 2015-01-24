//  1.6 Given an image represented by an NxN matrix, where each pixel in the image is 4
//  bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
package org.leituo.cc150.DataStructure.arraysAndStrings;

import java.util.Arrays;

/**
 * Created by leituo56 on 10/28/14.
 */
public class Q1_6_RotateImage {
    //O(n^2)
    public void rotateImage(int[][] image, int size){
        for (int layer = 0; layer <size/2 ; layer++) {
            int first = layer;
            int last = size - layer - 1;
            for (int i = first; i <last; i++){
                int offset = i - first;
                int top = image[layer][i];
                //left->top
                image[first][i] = image[last-offset][first];
                //bottom->left
                image[last-offset][first] = image[last][last - offset];
                //right->bottom
                image[last][last - offset] = image[i][last];
                //top->right
                image[i][last] = top;
            }
        }
    }
    public static void main(String[] args) {
        Q1_6_RotateImage test = new Q1_6_RotateImage();
        int[][] image = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        test.rotateImage(image, 4);
        System.out.println(Arrays.deepToString(image));
    }
}
