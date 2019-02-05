package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

import static com.example.RandomQuestions.*;

/**
 * Created by levin on 3/27/17.
 */
public class RandomQuestionsTest {
    @Test
    public void testShuffle() throws Exception {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        shuffle(arr);
        System.out.println();

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

}