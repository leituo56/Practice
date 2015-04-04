package org.leituo.utils;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by leituo56 on 3/28/15.
 * Test helper for Tree related questions
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    /**
     * print the tree vertically
     * input: 5, 3, 7, #, 4, 6
     * output: a printed tree
     */

    public void display(){
        printTree(this, 0, false, "");
    }
    private void printTree(TreeNode root, int level, boolean isRight, String indent){
        String str = String.valueOf(root==null?"#":root.val);
        boolean goOn = root != null && (root.left != null || root.right != null);

        String indentRight = indent + (isRight?"        ":"|       ");
        if(level <= 0) indentRight = "";
        if(goOn) printTree(root.right, level+1, true, indentRight);

        if(level!=0){
            System.out.print(indent);
            System.out.println((isRight?" /":" \\") + "------" + str);
        }
        else
            System.out.println(str);

        String indentLeft = indent + (isRight?"|       ":"        ");
        if(level <= 0) indentLeft = "";
        if(goOn) printTree(root.left, level+1, false, indentLeft);
    }

    /**
     * Generate a random BST for test
     * @param height height of the tree
     * @param start start range of BST
     * @param end end range of BST
     * @return a random BST
     */
    public static TreeNode randomBST(int height, int start, int end){
        if(height < 1 || start >= end)
            return null;
        Random r = new Random();
        int rnd = r.nextInt(end - start) + start;
        TreeNode result = new TreeNode(rnd);
        result.left = TreeNode.randomBST(height - 1, start, rnd - 1);
        result.right = TreeNode.randomBST(height - 1, rnd + 1, end);
        return result;
    }

    /**
     * Input string like "1, 2, 3, #, 4, #, 5, 6, 7, 8" to get a tree, {} is optional, # means null
     * @param s The string use to generate
     * @return A new Tree with this String pattern
     */
    public static TreeNode newByString(String s){
        if(s == null) return null;
        s = s.replaceAll("\\{","");
        s = s.replaceAll("}","");
        TreeNode result;
        String[] arr = s.split(",");
        if(arr.length == 0 || arr[0].trim().equals("#")) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        result = new TreeNode(Integer.valueOf(arr[0].trim()));
        queue.offer(result);
        boolean left = true;//next value to queue.poll().left
        for (int i = 1; i < arr.length; i++){
            if(queue.isEmpty())
                throw new Error(s + " is not a valid TreeNode String!!");
            String str = arr[i].trim();
            TreeNode cur = queue.peek();
            TreeNode inserted;
            if(str.equals("#")){
//                inserted = null;
            }else{
                inserted = new TreeNode(Integer.parseInt(str));
                if(left) {
                    cur.left = inserted;
                } else {
                    cur.right = inserted;
                }
                queue.offer(inserted);
            }
            if(!left)
                queue.poll();
            left = !left;
        }
        return result;
    }

    /**
     * Test Case
     */
    public static void main(String[] args) {
        // Test Basic Tree Display
        TreeNode test1 = new TreeNode(5);
        test1.left = new TreeNode(3);
        test1.right = new TreeNode(7);
        test1.left.right = new TreeNode(4);
        test1.right.left = new TreeNode(6);
        test1.display();

        // Test Random BST
        TreeNode test2 = TreeNode.randomBST(5, 0, 100);
        test2.display();

        // Test generate Tree by String
        TreeNode test3 = TreeNode.newByString("1, 2, 3, 4, 5, 6, 7, 8");
        test3.display();
        TreeNode test4 = TreeNode.newByString("1, 2, 3, #, 4, #, 5, 6, 7, 8");
        test4.display();
        TreeNode test5 = TreeNode.newByString("{41,37,44,24,39,42,48,1,35,38,40,#,43,46,49,0,2,30,36,#,#,#,#,#,#,45,47,#,#,#,#,#,4,29,32,#,#,#,#,#,#,3,9,26,#,31,34,#,#,7,11,25,27,#,#,33,#,6,8,10,16,#,#,#,28,#,#,5,#,#,#,#,#,15,19,#,#,#,#,12,#,18,20,#,13,17,#,#,22,#,14,#,#,21,23}");
        test5.display();
    }
}
