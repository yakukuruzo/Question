package com.example;

/**
 * Created by levin on 3/31/17.
 */

public class CountPathsDynamicProgrammingQuestion {


    // TODO: Check correctness
    public static int countPaths(boolean[][] grid, int row, int col, int[][] paths) { // O(N^2) vs O(2^N^2)
        //if (!isValid(grid, row, col)) return 0;
        //if (isAtEnd(grid, row, col)) return 1;

        if (paths[row][col] == 0) {
            paths[row][col] = countPaths(grid, row + 1, col, paths) + countPaths(grid, row, col + 1, paths);
        }

        return paths[row][col];
    }
}
