package com.example.java_practice.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeToDoublyList {
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        inOrder(root, queue);
        TreeNode head = queue.poll();
        TreeNode pre = head;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }

        pre.right = head;
        head.left = pre;

        return head;
    }

    void inOrder(TreeNode root, Queue<TreeNode> queue) {
        if (root == null) {
            return;
        }

        inOrder(root.left, queue);
        queue.add(root);
        inOrder(root.right, queue);
        return;//can be ignored
    }
}
