package com.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.example.MathQuestions.*;

/**
 * Created by levin on 3/10/17.
 */
public class MathQuestionsTest {
    @Test
    public void testIsSumToZero() throws Exception {
        isSumToZero(new int[]{1, 2, -3, 1});
        isSumToZero(new int[]{1, 2, 1, -3, -4});
        isSumToZero(new int[]{-1, -1, -3, 4});
        isSumToZero(new int[]{100, 7, 1, 2, -3});
        isSumToZero(new int[]{-7, -3, -2, 5, 8});
    }

    @Test
    public void testIsSubsetSum() throws Exception {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }

    @Test
    public void testIsSubsetSum2() throws Exception {
        System.out.println(isSubsetSum(new int[]{1, 2, -3, 1}, 4, 0));
        System.out.println(isSubsetSum(new int[]{1, 2, 1, -3, -4}, 5, 0));
        System.out.println(isSubsetSum(new int[]{-1, -1, -3, 4}, 4, 0));
        System.out.println(isSubsetSum(new int[]{100, 7, 1, 2, -3}, 5, 0));
        System.out.println(isSubsetSum(new int[]{-7, -3, -2, 5, 8}, 5, 0));
    }

    @Test
    public void testIsScorePossible() throws Exception {
        int[] points = new int[]{3, 7};

        System.out.println(isScorePossible(10, points));
        System.out.println(isScorePossible(points, 10));

        System.out.println(isScorePossible(9, points));
        System.out.println(isScorePossible(points, 9));

        System.out.println(isScorePossible(11, points));
        System.out.println(isScorePossible(points, 11));
    }

    @Test
    public void testFibonacciRecursive() throws Exception {
        System.out.print(fibonacciRecursive(0) + " ");
        System.out.print(fibonacciRecursive(1) + " ");
        System.out.print(fibonacciRecursive(2) + " ");
        System.out.print(fibonacciRecursive(3) + " ");
        System.out.print(fibonacciRecursive(4) + " ");
        System.out.print(fibonacciRecursive(5) + " ");
        System.out.print(fibonacciRecursive(6) + " ");
        System.out.print(fibonacciRecursive(7) + " ");
        System.out.print(fibonacciRecursive(8) + " ");
    }

    @Test
    public void testFibonacciLinear() throws Exception {
        fibonacciLinear(1);
        fibonacciLinear(2);
        fibonacciLinear(3);
        fibonacciLinear(4);
        fibonacciLinear(5);
        fibonacciLinear(6);
        fibonacciLinear(7);
        fibonacciLinear(8);
    }

    @Test
    public void testCheckNumberIfFibonacci() throws Exception {
        checkNumberIfFibonacci(1);
        checkNumberIfFibonacci(2);
        checkNumberIfFibonacci(3);
        checkNumberIfFibonacci(4);
        checkNumberIfFibonacci(5);
        checkNumberIfFibonacci(6);
        checkNumberIfFibonacci(7);
        checkNumberIfFibonacci(8);
        checkNumberIfFibonacci(9);
        checkNumberIfFibonacci(10);
        checkNumberIfFibonacci(11);
        checkNumberIfFibonacci(12);
        checkNumberIfFibonacci(13);
        checkNumberIfFibonacci(14);
        checkNumberIfFibonacci(15);
    }

    @Test
    public void fourSum() throws Exception {
        MathQuestions.fourSum(new int[]{2, 4, 3, 1, 5, 6, 7, 8, 5, 0}, 6);
    }

    @Test
    public void sumTo3() throws Exception {
        MathQuestions.sumTo3(new int[]{2, 4, 3, 1, 5, 6, 7, 8, 5, 0}, 6);
        System.out.println("With negative numbers:");
        MathQuestions.sumTo3(new int[]{2, 4, -3, 1, 5, -6, 7, 8, -5, 0}, 6);
        System.out.println("Fault case:");
        MathQuestions.sumTo3(new int[]{0, 0, 0, 1, 1, 1, 1, 1, 1, 0}, 6);
        System.out.println("Empty array case:");
        MathQuestions.sumTo3(new int[]{}, 6);
        System.out.println("Null case:");
        MathQuestions.sumTo3(null, 6);
    }

    @Test
    public void sumTo2WithPointers() throws Exception {
        MathQuestions.sumTo2WithPointers(new int[]{2, 4, 3, 1, 5, 6, 7, 8, 5, 0}, 6);
    }

    @Test
    public void twoSumFromInternet() throws Exception {
        MathQuestions.twoSumFromInternet(new int[]{2, 4, 3, 1, 5, 6, 7, 8, 5, 0}, 6);
    }

    @Test
    public void sumTo2HashMap() throws Exception {
        MathQuestions.sumTo2HashMap(new int[]{2, 4, 3, 1, 5, 6, 7, 8, 5, 0}, 6);
    }

    @Test
    public void sumTo2() throws Exception {
        MathQuestions.sumTo2(new int[]{2, 4, 3, 1, 5, 6, 7, 8, 5, 0}, 6);
    }

}