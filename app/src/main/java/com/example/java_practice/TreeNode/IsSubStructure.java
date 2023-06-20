package com.example.java_practice.TreeNode;

import com.example.java_practice.TreeNode.TreeNode;

public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        if (isSubTree(A, B)) {
            return true;
        }

        if (isSubStructure(A.left, B) || isSubStructure(A.right, B)) {
            return true;
        }

        return false;
    }

    public boolean isSubTree(TreeNode Ta, TreeNode Tb) {
        if (Tb == null) {
            return true;
        }
        if (Ta == null) {
            return false;
        }
        if (Ta.val != Tb.val) {
            return false;
        }

        return isSubTree(Ta.left, Tb.left) && isSubTree(Ta.right, Tb.right);
    }
}
