package com.example.java_practice.TreeNode;

import com.example.java_practice.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        int sum = 1;

        queue.add(root);
        while (!queue.isEmpty()) {
            int k = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                TreeNode t = queue.poll();
                if (sum % 2 == 1) {
                    temp.add(t.val);
                } else {
                    temp.addFirst(t.val);
                }

                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
            res.add(temp);
            sum++;
        }

        return res;
    }
}
