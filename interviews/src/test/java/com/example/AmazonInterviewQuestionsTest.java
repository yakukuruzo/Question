package com.example;

import org.junit.Test;

import static com.example.AmazonInterviewQuestions.printNGE;
import static org.junit.Assert.*;

public class AmazonInterviewQuestionsTest {

    @Test
    public void testPrintNGE() {
        int arr[] = { 11, 13, 21, 3, 2, 1, 12};
        int n = arr.length;
        printNGE(arr, n);
    }
}