package com.example;

/**
 * Created by levin on 4/19/17.
 */

public class GoogleInterviewQuestions {

    public static class Lamps {

        private boolean[] columns, rows, diagonalsLeft, diagonalsRight;

        private int N;

        public Lamps(int size, int[][] lamps) {
            this.columns = new boolean[size];
            this.rows = new boolean[size];
            this.diagonalsLeft = new boolean[(size - 1) * 2 + 1];
            this.diagonalsRight = new boolean[(size - 1) * 2 + 1];
            this.N = size - 1;


            for (int[] lampcoor : lamps) {
                int col = lampcoor[0];
                int row = lampcoor[1];

                this.columns[col] = true;
                this.rows[row] = true;
                this.diagonalsLeft[col + row] = true;
                this.diagonalsRight[N - col + row] = true;
            }
        }

        public boolean query(int x, int y) {
            if (columns[x] || rows[y] || diagonalsLeft[x + y] || diagonalsRight[N - x + y])
                return true;
            else
                return false;
        }
    }


    public static void printLargerSmaller(int[] v) {
        int n = v.length;
        int[] leftMax = new int[n];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], v[i - 1]);
        }
        int rightMin = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            if (i < n - 1) rightMin = Math.min(rightMin, v[i + 1]);
            if (v[i] > leftMax[i] && v[i] < rightMin) {
                System.out.print(v[i] + " ");
            }
        }
    }
}