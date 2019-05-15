package com.example;

import org.junit.Test;

import static com.example.AmazonInterviewQuestions.carAssembly;
import static com.example.AmazonInterviewQuestions.printNGE;
import static com.example.AmazonInterviewQuestions.FindMaxSum;
import static com.example.AmazonInterviewQuestions.editDistDP;

public class AmazonInterviewQuestionsTest {

    @Test
    public void testPrintNGE() {
        int arr[] = {11, 13, 21, 3, 2, 1, 12};
        int n = arr.length;
        printNGE(arr, n);
    }

    @Test
    public void testFindMaxSum() {
        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println(FindMaxSum(arr, arr.length));

    }

    @Test
    public void testEditDistance() {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(editDistDP(str1, str2, str1.length(), str2.length()));
    }

    @Test
    public void testCarAssemblyLine() {
        int a[][] = {{4, 5, 3, 2},
                {2, 10, 1, 4}};
        int t[][] = {{0, 7, 4, 5},
                     {0, 9, 2, 8}};
        int e[] = {10, 12}, x[] = {18, 7};

        System.out.println(carAssembly(a, t, e, x));
    }
}