package com.example.java_practice.TreeNode;

import com.example.java_practice.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    List<List<Integer>> res;
    List<Integer> tmp;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        tmp = new ArrayList<>();

        dsf(root, target);

        return res;
    }

    void dsf(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        tmp.add(root.val);
        target = target - root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(tmp));
        }

        dsf(root.left, target);
        dsf(root.right, target);

        tmp.remove(tmp.size() - 1);
    }
}
