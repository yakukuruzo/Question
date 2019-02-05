package com.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.example.TenXInterviewQuestions.*;

/**
 * Created by levin on 4/5/17.
 */
public class TenXInterviewQuestionsTest {
    @Test
    public void testSubArraySum() throws Exception {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 23;
        subArraySum(arr, sum);
    }

    @Test
    public void testFindSum() throws Exception {

        int[] array = new int[5];
        array = null;
        findSum(array, 4);
    }

}