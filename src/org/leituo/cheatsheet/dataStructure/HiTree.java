package org.leituo.cheatsheet.dataStructure;


import java.util.LinkedList;

/**
 * Created by leituo56 on 11/1/14.
 */
public class HiTree {

    public static void main(String[] args) {
        BST tree = new BST(50);
        for (int i = 0; i < 20 ; i++) {
            tree.put((int)Math.round(Math.random() * 100));
        }
        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
        System.out.println();
        tree.BFS();
    }
}
class BST{
    int key;
    BST left;
    BST right;
    boolean visited;

    BST(int key) {
        this.key = key;
        this.visited = false;
    }

    public boolean search(int key){
        return false;
    }
    public void put(int key){
        if (key <= this.key){
            if(this.left != null){
                this.left.put(key);
            }else {
                this.left = new BST(key);
            }
        }else {
            if (this.right != null){
                this.right.put(key);
            }else {
                this.right = new BST(key);
            }
        }

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
        LinkedList<BST> queue = new LinkedList<BST>();
        this.print();
        queue.add(this);
        while (!queue.isEmpty()){
            BST temp = queue.remove(0);
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
