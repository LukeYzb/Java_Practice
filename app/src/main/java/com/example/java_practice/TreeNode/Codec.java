package com.example.java_practice.TreeNode;

import com.example.java_practice.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder build = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t != null) {
                queue.add(t.left);
                queue.add(t.right);
                build.append(t.val + ",");
            } else {
                build.append("null,");
            }
        }

        return build.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() <= 0) {
            return null;
        }

        String[] s = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(s[i]));
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            //build left node
            if (!s[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(s[i]));
                t.left = left;
                queue.add(left);
            }
            i++;
            //build right node
            if (!s[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(s[i]));
                t.right = right;
                queue.add(right);
            }
            i++;
        }

        return root;
    }
}
