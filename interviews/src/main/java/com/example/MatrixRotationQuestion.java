package com.example;

/**
 * Created by levin on 3/31/17.
 */

public class MatrixRotationQuestion {

    public static void rotateMatrix(int[][] matrix, int n) { // Should be a square matrix

        for (int layer = 0; layer < n/2; layer++) {

            int first = layer;
            int last = n - layer - 1;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;
            }
        }

    }
}
