package com.example.java_practice.TreeNode;

import com.example.java_practice.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            res.add(t.val);
            if (t.left != null) queue.add(t.left);
            if (t.right != null) queue.add(t.right);
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }
}
