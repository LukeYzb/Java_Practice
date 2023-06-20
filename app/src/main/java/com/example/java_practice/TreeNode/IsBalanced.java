package com.example.java_practice.TreeNode;

public class IsBalanced {
    //time complexity O(nlogn)
    //space complexity O(n)
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return Math.abs(l - r) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
