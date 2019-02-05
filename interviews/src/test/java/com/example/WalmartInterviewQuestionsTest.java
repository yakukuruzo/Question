package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by levin on 5/9/17.
 */
public class WalmartInterviewQuestionsTest {

    @Test
    public void testGetKmax() throws Exception {
        int[] array = new int[] { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};

        Integer[] result = WalmartInterviewQuestions.getKmax(array);

        System.out.println(result);
    }

}