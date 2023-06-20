package com.example.java_practice.TreeNode;

import com.example.java_practice.TreeNode.TreeNode;

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
