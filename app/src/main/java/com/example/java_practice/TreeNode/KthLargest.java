package com.example.java_practice.TreeNode;

public class KthLargest {
    int k = 0, target = 0;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        right_root_left(root);
        return target;
    }

    void right_root_left(TreeNode root) {
        if (root == null || k <= 0) return;

        right_root_left(root.right);
        k--;
        if (k == 0) {
            target = root.val;
        }
        right_root_left(root.left);
    }
}
