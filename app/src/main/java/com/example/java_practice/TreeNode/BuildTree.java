package com.example.java_practice.TreeNode;


import com.example.java_practice.TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    Map<Integer, Integer> map = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length <= 0) {
            return null;
        }

        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

        return root;
    }

    TreeNode f(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1 && l2 > r2) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[l1]);
        int i = map.get(preorder[l1]);

        root.left = f(preorder, l1 + 1, l1 + (i - l2), inorder, l2, i - 1);
        root.right = f(preorder, l1 + (i - l2) + 1, r1, inorder, i + 1, r2);

        return root;
    }
}
