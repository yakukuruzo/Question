package com.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.example.SearchQuestions.*;

/**
 * Created by levin on 3/10/17.
 */
public class SearchQuestionsTest {
    @Test
    public void testRotatedBinarySearch() throws Exception {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int key = 8;
        int i = rotatedBinarySearch(arr, 0, n-1, key);
        System.out.println(i);
    }

    @Test
    public void testBinarySearch() throws Exception {
        System.out.println(binarySearch(new int[]{1, 3, 5, 8, 9, 10, 11, 17, 20, 21, 24}, 4));
        System.out.println(binarySearch(new int[]{1, 3, 5, 8, 9, 10, 11, 17, 20, 21, 24}, 24));
        System.out.println(binarySearch(new int[]{1, 3, 5, 8, 9, 10, 11, 17, 20, 21, 24}, 1));
        System.out.println(binarySearch(new int[]{1, 3, 5, 8, 9, 10, 11, 17, 20, 21, 24}, 10));
        System.out.println(binarySearch(new int[]{1, 3, 5, 8, 9, 10, 11, 17, 20, 21, 24}, 13));
    }

}