//顺时针螺旋打印矩阵
package org.leituo.Other;

/**
 * Created by leituo56 on 11/16/14.
 */
public class PrintMatrixRotately {
    public void printMatrix(int n){
        n = n - 1;
        int layer = n / 2;
        for(int i=0;i<=layer;i++){
            //print top
            for(int j=i;j<n-i;j++){
                print(j, i);
            }

            //print right;
            for(int j=i;j<n-i;j++){
                print(n-i, j);
            }
            //print bottom
            for(int j=i;j<n-i;j++){
                print(n-j, n-i);
            }

            //print left;
            for(int j=i;j<n-i;j++){
                print(i, n-j);
            }
        }
        //middle condition
        if((n%2)==0){
            print(layer, layer);
        }

    }
    public void print(int a, int b){
        System.out.print(a+","+b + " ");
    }

    public static void main(String[] args) {
        PrintMatrixRotately test = new PrintMatrixRotately();
        test.printMatrix(2);
    }
}
