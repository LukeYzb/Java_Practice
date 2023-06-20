package com.example.java_practice.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    List<Character> path;
    List<String> res;
    boolean[] visited;

    public String[] permutation(String s) {
        this.path = new ArrayList<>();
        this.res = new ArrayList<>();
        this.visited = new boolean[s.length()];

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        dfs(arr, 0);

        String[] ss = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ss[i] = res.get(i);
        }

        return ss;
    }

    //time complexity: O(n*n!)
    //space complexity: O(n)
    void dfs(char[] arr, int k) {
        if (arr.length == k) {
            res.add(ListToString(path));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1] && visited[i - 1] == false) {
                continue;
            }
            if (visited[i] == false) {
                visited[i] = true;
                path.add(arr[i]);
                dfs(arr, k + 1);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    String ListToString(List<Character> list) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            b.append(list.get(i));
        }

        return b.toString();
    }
}
