//4.9 You are given a binary tree in which each node contains a value. Design an algo-
// rithm to print all paths which sum to a given value. The path does not need to start or end at the root or a leaf.
package org.leituo.cc150.DataStructure.TreesAndGraphs;

/**
 * Created by leituo56 on 11/14/14.
 */
public class Q4_9_InnerPathSum {
    public static void findSum(Tree node, int sum, int[] path, int level) {
        if (node == null) {
            return;
        }
		/* Insert current node into path */
        path[level] = node.key;

        int t = 0;
        for (int i = level; i >= 0; i--){
            t += path[i];
            if (t == sum) {
                print(path, i, level);
            }
        }

        findSum(node.left, sum, path, level + 1);
        findSum(node.right, sum, path, level + 1);

		/* Remove current node from path. Not strictly necessary, since we would
		 * ignore this value, but it's good practice.
		 */
        path[level] = Integer.MIN_VALUE;
    }

    public static int depth(Tree node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(node.left), depth(node.right));
        }
    }

    public static void findSum(Tree node, int sum) {
        int depth = depth(node);
        int[] path = new int[depth];
        findSum(node, sum, path, 0);
    }

    private static void print(int[] path, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public static void main(String [] args){
        Tree root = new Tree(5);
        root.left = new Tree(3);
        root.right = new Tree(1);
        root.left.left = new Tree(4);
        root.left.right = new Tree(8);
        root.right.left = new Tree(2);
        root.right.right = new Tree(6);
        findSum(root, 8);
    }
}
