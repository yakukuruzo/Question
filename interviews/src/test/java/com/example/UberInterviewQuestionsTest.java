package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.UberInterviewQuestions.*;

/**
 * Created by levin on 4/10/17.
 */
public class UberInterviewQuestionsTest {

    @Test
    public void testSerialize() throws Exception {
        Node root = new Node('A');

        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');

        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');

        b.children.add(e); b.children.add(f); d.children.add(g);
        root.children.add(b); root.children.add(c); root.children.add(d);

        String serialize = serialize(root);
        System.out.println(serialize);

        Node test = deserialize(serialize);
        System.out.println(test.value);
    }

    @Test
    public void testArrayOfArraysPermutation() throws Exception {

        ArrayList<String> first = new ArrayList<>(Arrays.asList("Customer 1_1", "Customer 1_2", "Customer 1_3"));
        ArrayList<String> second = new ArrayList<>(Arrays.asList("Customer 2_1", "Customer 2_2"));
        ArrayList<String> third = new ArrayList<>(Arrays.asList("Customer 3_1", "Customer 3_2", "Customer 3_3"));

        ArrayList<ArrayList<String>> input = new ArrayList<>();
        input.add(first);input.add(second);input.add(third);

        ArrayList<ArrayList<String>> output = arrayOfArraysPermutation(input, 0);

        for ( ArrayList<String> output_line : output) {

        }
    }

    @Test
    public void tesPrintCombination() throws Exception {
        int arr[] = {1, 2, 3, 4, 5};
        int r = 3;
        int n = arr.length;
        printCombination(arr, n, r);
    }

    @Test
    public void testPermute() throws Exception {
        permute(new int[]{4, 5, 6, 3, 7, 9});
    }

    @Test
    public void testBrackets2() throws Exception {
        brackets2(3);
    }

    @Test
    public void testBrackets() throws Exception {
        brackets(3, 0, "");
    }

    @Test
    public void testSumUp() throws Exception {
        Integer[] numbers = {3, 9, 8, 4, 5, 7, 10};
        int target = 15;
        sum_up(new ArrayList<>(Arrays.asList(numbers)), target);
    }

}