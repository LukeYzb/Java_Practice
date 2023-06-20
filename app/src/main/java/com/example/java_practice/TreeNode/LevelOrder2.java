package com.example.java_practice.TreeNode;

import com.example.java_practice.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int k = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                TreeNode t = queue.poll();
                temp.add(t.val);
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
            res.add(temp);
        }

        return res;
    }
}
