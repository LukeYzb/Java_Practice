package com.example.java_practice.HuaweiOD;

//描述
//        定义一个二维数组 N*M ，如 5 × 5 数组下所示：
//
//
//        int maze[5][5] = {
//        0, 1, 0, 0, 0,
//        0, 1, 1, 1, 0,
//        0, 0, 0, 0, 0,
//        0, 1, 1, 1, 0,
//        0, 0, 0, 1, 0,
//        };
//
//
//        它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
//
//
//        数据范围：
//        2≤n,m≤10  ， 输入的内容只包含
//        0≤val≤1
//
//        输入描述：
//        输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
//
//        输出描述：
//        左上角到右下角的最短路径，格式如样例所示。


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

class Maze {
    public int[][] directions = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };
    private Stack<int[]> path;
    private ArrayList<int[]> minPath;
    private int[][] matrix;
    private boolean[][] visited;

    public static void main(String[] args) throws Exception {
        Maze main = new Maze();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = null;

        while ((str1 = br.readLine()) != null) {
            String[] arr = str1.split(" ");
            int rows = Integer.parseInt(arr[0]);
            int cols = Integer.parseInt(arr[1]);
            main.path = new Stack<>();
            main.minPath = null;
            main.matrix = new int[rows][cols];
            main.visited = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                String[] str2 = br.readLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    main.matrix[i][j] = Integer.parseInt(str2[j]);
                }
            }
            main.dfs(0, 0);

            StringBuilder sb = new StringBuilder();
            for (int[] res : main.minPath) {
                sb.append('(').append(res[0]).append(',').append(res[1]).append(")\n");
            }

            System.out.print(sb);
        }
    }

    private void dfs(int i, int j) {
        if (i > matrix.length - 1 || i < 0 || j > matrix[0].length - 1 || j < 0 ||
                visited[i][j] || matrix[i][j] == 1 ||
                (minPath != null && path.size() >= minPath.size())) {
            return;
        }
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            path.add(new int[]{i, j});
            minPath = new ArrayList<>(path);
            path.pop();
            return;
        }
        path.add(new int[]{i, j});
        visited[i][j] = true;
        for (int[] direction : directions) {
            dfs(i + direction[0], j + direction[1]);
        }
        visited[i][j] = false;
        path.pop();
    }
}
