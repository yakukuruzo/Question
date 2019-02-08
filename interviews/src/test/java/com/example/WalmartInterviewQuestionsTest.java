package com.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.example.WalmartInterviewQuestions.findKthLargest;

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

    @Test
    public void findKthLargestTest() {
        System.out.println(findKthLargest(new int[] {4,1,0,0,0,0,0, 7, 9}, 2));
        System.out.println(findKthLargest(new int[] {4,1,0,0,0,0,0, 7, 9}, 3));
        System.out.println(findKthLargest(new int[] {4,1,0,0,0,0,0, 7, 9}, 7));
        System.out.println(findKthLargest(new int[] {4,1,0,0,0,0,0, 7, 9}, 10));
    }
}