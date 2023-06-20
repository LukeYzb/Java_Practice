package com.example.java_practice.TreeNode;

import com.example.java_practice.TreeNode.TreeNode;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        return f(root.left, root.right);
    }

    public boolean f(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        return f(a.left, b.right) && f(a.right, b.left);
    }
}
