package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static com.example.FacebookInterviewQuestions.*;

/**
 * Created by levin on 4/12/17.
 */
public class FacebookInterviewQuestionsTest {

    @Test
    public void testBinaryTreeToCList() throws Exception {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        // head refers to the head of the Link List
        Node head = bTreeToCList(root);

        Node itr = head;
        do {
            System.out.print(itr.key + " ");
            itr = itr.right;
        }
        while (itr != head);
        System.out.println();
    }

    @Test
    public void testBintree2list() throws Exception {
        // Let us create the tree shown in above diagram
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        // Convert to DLL
        Node head = bintree2list(root);

        while (head != null) {
            System.out.print(head.key + " ");
            head = head.right;
        }
    }

    @Test
    public void testMaxSlidingWindow() throws Exception {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{4, 2, 5, 3, 7, 9, 5, 3, 7, 12, 11, 13, 4, 5, 6, 20, 12, 3, 4, 1, 1, 1, 1, 1}, 3)));
    }

    @Test
    public void testGetpowerset() throws Exception {
        List<String> ps = getpowerset(new int[]{1, 2, 3}, 3, new ArrayList<>());
        System.out.println(ps);
    }

    @Test
    public void testTreeDiameter() throws Exception {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("The diameter of given binary tree is : "
                + treeDiameter(root));
    }

    @Test
    public void testLongestValidParentheses() throws Exception {
        System.out.println(longestValidParentheses(")()())((()))))()((())())"));
    }

    @Test
    public void testPrintZeroSumSubarray() throws Exception {
        int arr[] = {4, 2, -3, 1, 6};
        if (printZeroSumSubarray(arr))
            System.out.println("Found a subarray with 0 sum");
        else
            System.out.println("No Subarray with 0 sum");
    }

    @Test
    public void testMaxLenSumTo0() throws Exception {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of the longest 0 sum subarray is " + maxLenSumTo0(arr));
    }

    @Test
    public void testPushZerosToEnd() throws Exception {
        int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;
        pushZerosToEnd(arr, n);
        System.out.println("Array after pushing zeros to the back: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    @Test
    public void testCountDecoding() throws Exception {
        char digits[] = new String("1234").toCharArray();
        int n = digits.length;
        System.out.println(countDecoding(digits, n));
        System.out.println(countDecodingDP(digits, n));
    }

    @Test
    public void testFindMaxSum() throws Exception {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(100);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " + findMaxSum(root));
    }

    @Test
    public void testMinimumDepth() throws Exception {
        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("The minimum depth of " +
                "binary tree is : " + minimumDepth(root));
    }

    @Test
    public void testIsMirror() throws Exception {
        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        System.out.println(isTreeSymmetric(root));
    }

    @Test
    public void testFindDistance() throws Exception {
        char[][] matrix = {
                {'o', 'o', 'o', 'g', 'o'},
                {'o', 'o', 'w', 'o', 'o'},
                {'o', 'g', 'o', 'o', 'w'},
                {'o', 'w', 'g', 'o', 'o'},
                {'w', 'o', 'o', 'o', 'g'}};

        int[][] result = findDistance(matrix);

        if (result == null) {
            System.out.println("Invalid input Matrix");
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    @Test
    public void testConvert() throws Exception {
        System.out.println(convert(123456789));
        System.out.println(convert(-55));
    }

    @Test
    public void testCanStringBeSplitted() throws Exception {

        Set<String> dict = new HashSet<>();
        dict.add("bed");
        dict.add("bath");
        dict.add("and");
        dict.add("beyond");
        System.out.println(canStringBeSplitted("bedbathandbeyond", dict));

    }

    @Test
    public void testConsecutiveOnes() throws Exception {
        int max = 17;
        int length = Integer.toBinaryString(max).length();
        int bitmask = (1 << length) - 1;
        int counter = 0;
        for (int i = 0; i <= max; i++) {
            if (!isConsecutiveOnes(i, bitmask)) {
                System.out.println(Integer.toBinaryString(i));
                counter++;
            }
        }
        System.out.print(counter);
    }

    @Test
    public void testCountNumberWithNonConsecutiveOnes() throws Exception {

        long[][] DP = new long[64][2];
        for (int i = 0; i < 64; i++) {
            DP[i][0] = -1;
            DP[i][1] = -1;
        }
        long max = 17;
        int num = Long.toBinaryString(max).length();
        System.out.println(num);
        System.out.println(countNumberWithNonConsecutiveOnes("", Long.toBinaryString(max), num, 0, DP));
    }

    @Test
    public void testFindLastGoodCommit() throws Exception {

        System.out.println(findLastGoodCommit(null));

        System.out.println(findLastGoodCommit(new boolean[]{}));

        boolean[] commitHistory = new boolean[]{false}; // 0
        System.out.println(findLastGoodCommit(commitHistory));

        commitHistory = new boolean[]{true}; // 1
        System.out.println(findLastGoodCommit(commitHistory));

        commitHistory = new boolean[]{true, false}; // 10
        System.out.println(findLastGoodCommit(commitHistory));

        commitHistory = new boolean[]{true, true, false}; // 110
        System.out.println(findLastGoodCommit(commitHistory));

        commitHistory = new boolean[]{true, true, true,
                true, false, false}; //111100
        System.out.println(findLastGoodCommit(commitHistory));

        commitHistory = new boolean[]{true, true, true,
                true, true, true,
                true, true, true,
                true, true, false,
                false, false, false,
                false};  //1111111111100000
        System.out.println(findLastGoodCommit(commitHistory));
    }

    @Test
    public void testFindLastGoodCommitShorter() {
        System.out.println(findLastGoodCommitShorter(null));

        System.out.println(findLastGoodCommitShorter(new boolean[]{}));

        boolean[] commitHistory = new boolean[]{false}; // 0
        System.out.println(findLastGoodCommitShorter(commitHistory));

        commitHistory = new boolean[]{true}; // 1
        System.out.println(findLastGoodCommitShorter(commitHistory));

        commitHistory = new boolean[]{true, false}; // 10
        System.out.println(findLastGoodCommitShorter(commitHistory));

        commitHistory = new boolean[]{true, true, false}; // 110
        System.out.println(findLastGoodCommitShorter(commitHistory));

        commitHistory = new boolean[]{true, true, true,
                true, false, false}; //111100
        System.out.println(findLastGoodCommitShorter(commitHistory));

        commitHistory = new boolean[]{true, true, true,
                true, true, true,
                true, true, true,
                true, true, false,
                false, false, false,
                false};  //1111111111100000
        System.out.println(findLastGoodCommitShorter(commitHistory));
    }
}