package com.example.java_practice.Array;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int i = 1, j = 1, sum = 1;

        while (i <= target / 2) {
            if (sum < target) {
                j++;
                sum += j;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] temp = new int[j - i + 1];
                int index = 0;
                for (int k = i; k <= j; k++) {
                    temp[index++] = k;
                }
                sum -= i;
                i++;
                j++;
                sum += j;
                res.add(temp);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
