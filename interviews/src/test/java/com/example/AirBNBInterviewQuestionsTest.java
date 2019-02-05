package com.example;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static com.example.AirBNBInterviewQuestions.*;

/**
 * Created by levin on 4/13/17.
 */
public class AirBNBInterviewQuestionsTest {
    @Test
    public void testFindPossibleAlphabetOrdering() throws Exception {
        String[] sample = {"xza", "ayh", "ples", "plares", "bhaaz", "bnc"};
        System.out.println(findPossibleAlphabetOrdering(sample));
    }

    @Test
    public void testFindLongestIsland() throws Exception {
        Character[] input1 = {'L', 'W', 'L', 'W', 'W', 'L', 'W'};
        Character[] input2 = {'L', 'W', 'L', 'W', 'W', 'L', 'L'};
        Character[] input3 = {'W', 'W', 'L', 'W', 'W', 'L', 'L'};
        Character[] input4 = {'W', 'W', 'W', 'W', 'W', 'W', 'W'};
        Character[] input5 = {'W', 'L', 'L', 'W', 'W', 'L', 'L'};
        Character[] input6 = {'W', 'L', 'L', 'W', 'L', 'W'};
        System.out.println("Longest island is: " + findLongestIsland(input1));
        System.out.println("Longest island is: " + findLongestIsland(input2));
        System.out.println("Longest island is: " + findLongestIsland(input3));
        System.out.println("Longest island is: " + findLongestIsland(input4));
        System.out.println("Longest island is: " + findLongestIsland(input5));
        System.out.println("Longest island is: " + findLongestIsland(input6));
    }

    @Test
    public void testFindPalindromePairs() throws Exception {

        String input[] = {"cat","tac", "rac","car", "ta","abc"};

        ArrayList<String> output = findPalindromePairs(input);

        for(String palPair : output) {
            String pair[] = palPair.split(" : ");

            System.out.println(pair[0] + "\t" + " : " + "\t" + pair[1]);
        }
    }

}