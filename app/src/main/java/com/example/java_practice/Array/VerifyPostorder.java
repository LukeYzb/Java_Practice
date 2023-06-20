package com.example.java_practice.Array;

public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) {
            return true;
        }

        return f(postorder, 0, postorder.length - 1);
    }

    boolean f(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }

        int root = postorder[j];
        int p = i;
        //get index of first value >= root
        while (postorder[p] < root) p++;
        //check value < root between p ~ j-1
        for (int k = p; k < j; k++) {
            if (postorder[k] < root) {
                return false;
            }
        }

        return f(postorder, i, p - 1) && f(postorder, p, j - 1);
    }
}
