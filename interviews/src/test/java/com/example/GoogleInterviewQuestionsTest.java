package com.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.example.GoogleInterviewQuestions.*;

/**
 * Created by levin on 5/11/17.
 */
public class GoogleInterviewQuestionsTest {

    @Test
    public void testPrintLargerSmaller() throws Exception {
        int[] v = {3, 4, 7, 1, 8, 12};
        printLargerSmaller(v);

        System.out.println();
        int a[] = {6, 5, 4, 3, 9, 100, 87, 64, 34, 101};
        printLargerSmaller(a);
    }

}