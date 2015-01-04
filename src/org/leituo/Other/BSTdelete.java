package org.leituo.Other;

/**
 * Created by leituo56 on 1/4/15.
 */
public class BSTdelete {
    public TreeNode removeNode(TreeNode root, int value) {
        if (root == null) return null;
        TreeNode helper = new TreeNode(0);
        helper.left = root;
        searchAndRemove(helper, root, value);
        return helper.left;
    }

    private void searchAndRemove(TreeNode parent, TreeNode runner, int value) {
        if (runner == null) return;
        if (runner.val == value)
            remove(parent, runner);
        else if (runner.val > value)
            searchAndRemove(runner, runner.left, value);
        else
            searchAndRemove(runner, runner.right, value);
    }

    public void remove(TreeNode parent, TreeNode runner) {
        if (runner.left == null && runner.right == null) {
            replace(parent, runner, null);
        } else if (runner.left == null || runner.right == null) {
            TreeNode newNode = (runner.left == null) ? runner.right : runner.left;
            replace(parent, runner, newNode);
        } else {
            TreeNode subParent = runner;
            TreeNode subRunner = runner.left;
            while (subRunner.right != null) {
                subParent = subRunner;
                subRunner = subRunner.right;
            }
            replace(subParent, subRunner, subRunner.left);
            subRunner.left = runner.left;
            subRunner.right = runner.right;
            replace(parent, runner, subRunner);
        }
    }

    private void replace(TreeNode parent, TreeNode runner, TreeNode value) {
        if (parent.left == runner)
            parent.left = value;
        else
            parent.right = value;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
