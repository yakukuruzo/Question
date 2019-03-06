package com.example;

import java.net.Inet4Address;
import java.util.HashSet;
import java.util.Set;

public class ConeredRectangularInMatrix {

    public static int calculateNumberOfRectangulars(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        Set<Integer>[] cornerIndexesByRows = new Set[rows];
        for (int i = 0; i < rows; i++) {
            cornerIndexesByRows[i] = new HashSet();
        }

        // O(MN)
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (matrix[row][column] == 1) {
                    cornerIndexesByRows[row].add(column);
                }
            }
            if (cornerIndexesByRows[row].size() <= 1) {
                cornerIndexesByRows[row].clear();
            }
        }

        int numberOfRects = 0;
        for (int row = 0; row < rows - 1; row++) {
            if (cornerIndexesByRows[row].isEmpty()) continue;
            for (int nextRow = row + 1; nextRow < rows; nextRow++) {
                boolean pairFound = false;
                for (int cornerIndex : cornerIndexesByRows[row]) {
                    if (cornerIndexesByRows[nextRow].contains(cornerIndex)) {
                        if (pairFound) numberOfRects++;
                        pairFound = true;
                    }
                }
            }
        }
        return numberOfRects;
    }
}
