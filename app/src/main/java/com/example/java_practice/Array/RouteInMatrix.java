package com.example.java_practice.Array;

public class RouteInMatrix {
    int n, m, len;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        this.m = board[0].length;
        this.len = word.length();
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dsf(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dsf(char[][] board, int i, int j, String word, int k) {
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }

        //last word
        if (k == len - 1) {
            return true;
        }

        visited[i][j] = true;
        boolean res = dsf(board, i, j + 1, word, k + 1) ||
                dsf(board, i + 1, j, word, k + 1) ||
                dsf(board, i, j - 1, word, k + 1) ||
                dsf(board, i - 1, j, word, k + 1);
        visited[i][j] = false;
        return res;
    }
}
