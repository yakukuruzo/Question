package com.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.example.ConeredRectangularInMatrix.calculateNumberOfRectangulars;

public class ConeredRectangularInMatrixTest {


    @Test
    public void testOneRectangular() {

        int result = calculateNumberOfRectangulars(new int[][]{{1, 0, 1},
                                                               {1, 0, 0},
                                                               {1, 1, 1}});
        System.out.println("Result = " + result);
    }

    @Test
    public void testZeroRectangular() {

        int result = calculateNumberOfRectangulars(new int[][]{{1, 0, 1},
                                                               {1, 0, 0},
                                                               {1, 1, 0}});
        System.out.println("Result = " + result);
    }

    @Test
    public void testSeveralRectangulars() {

        int result = calculateNumberOfRectangulars(new int[][]{{1, 0, 1},
                                                               {1, 1, 0},
                                                               {1, 1, 1}});
        System.out.println("Result = " + result);
    }

    @Test
    public void testAllRectangulars() {

        int result = calculateNumberOfRectangulars(new int[][]{{1, 1, 1},
                                                               {1, 1, 1},
                                                               {1, 1, 1}});
        System.out.println("Result = " + result);
    }
}