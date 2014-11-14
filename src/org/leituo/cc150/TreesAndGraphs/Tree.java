package org.leituo.cc150.TreesAndGraphs;

import java.util.LinkedList;

/**
 * Created by leituo56 on 11/1/14.
 */
public class Tree {
    int key;
    Tree left;
    Tree right;
    Tree parent;//just for q4.6
    boolean visited;

    Tree(int key) {
        this.key = key;
    }
    public void inOrder(){
        if(this.left!=null) this.left.inOrder();
        System.out.print("[" + this.key + "]");
        if(this.right!=null) this.right.inOrder();
    }
    public void preOrder(){
        System.out.print("[" + this.key + "]");
        if(this.left!=null) this.left.preOrder();
        if(this.right!=null) this.right.preOrder();
    }
    public void postOrder(){
        if(this.left!=null) this.left.postOrder();
        if(this.right!=null) this.right.postOrder();
        System.out.print("[" + this.key + "]");
    }
    public void BFS(){
        LinkedList<Tree> queue = new LinkedList<Tree>();
        this.print();
        queue.add(this);
        while (!queue.isEmpty()){
            Tree temp = queue.remove(0);
            if (temp.left == null){
                System.out.print("[-]");
            }else {
                queue.add(temp.left);
                temp.left.print();
            }
            if (temp.right == null){
                System.out.print("[-]");
            }else {
                queue.add(temp.right);
                temp.right.print();
            }
        }
    }
    private void print(){
        System.out.print("[" + this.key + "]");
    }
}
