package com.example;

import org.junit.Test;


import static com.example.Snap2019InterviewQuestions.Brackets.balanceBrackets;
import static org.junit.Assert.*;
import static com.example.Snap2019InterviewQuestions.FindPatternMatch.findMatchedWords;
import static com.example.Snap2019InterviewQuestions.BigIntegerSum.findSum;
import static com.example.Snap2019InterviewQuestions.KthLargestElementInBST.newNode;
import static com.example.Snap2019InterviewQuestions.KthLargestElementInBST.KthLargestUsingMorrisTraversal;
import static com.example.Snap2019InterviewQuestions.KthLargestElementInBST.kthLargest;
import static com.example.Snap2019InterviewQuestions.ConstructTree.buildTree;
import static com.example.Snap2019InterviewQuestions.ConstructTree.printInorder;
import static com.example.Snap2019InterviewQuestions.PowerSet.powerSet;
import static com.example.Snap2019InterviewQuestions.Brackets.generateAllCombinationsOfBrackets;

import com.example.Snap2019InterviewQuestions.Node;

public class Snap2019InterviewQuestionsTest {

    @Test
    public void testFindMatchedWords() {
        String[] dict = { "abb", "abc", "xyz", "xyy" };
        String pattern = "foo";
        findMatchedWords(dict, pattern);
    }

    @Test
    public void testBigIntegerSum() {
        String str1 = "12";
        String str2 = "198111";
        System.out.println(findSum(str1, str2));
    }

    @Test
    public void testKthLargestElementInBSTUsingMorrisTraversal() {
        Node root = newNode(4);
        root.left = newNode(2);
        root.right = newNode(7);
        root.left.left = newNode(1);
        root.left.right = newNode(3);
        root.right.left = newNode(6);
        root.right.right = newNode(10);

        System.out.println("Finding K-th largest Node in BST : " +
                KthLargestUsingMorrisTraversal(root, 2).data);
    }

    @Test
    public void testKthLargestElementInBST() {
        Node root = newNode(4);
        root.left = newNode(2);
        root.right = newNode(7);
        root.left.left = newNode(1);
        root.left.right = newNode(3);
        root.right.left = newNode(6);
        root.right.right = newNode(10);

        kthLargest(root, 2);
    }

    @Test
    public void testBuildTreeFromInorderAndPostOrder() {
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        Node root = buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        printInorder(root);
    }

    @Test
    public void testPowerset () {
        String str = "abc";
        int index = -1;
        String curr = "";
        powerSet(str, index, curr);
    }

    @Test
    public void testBracketCombination() {
        generateAllCombinationsOfBrackets(3);
        generateAllCombinationsOfBrackets(4);
    }

    @Test
    public void testBalanceBrackets() {
        balanceBrackets("()".toCharArray()); // -> "()")
        balanceBrackets("a(b)c)".toCharArray());// -> "a(b)c"
        balanceBrackets(")(".toCharArray());// -> ""
        balanceBrackets("(((((".toCharArray());// -> ""
        balanceBrackets("(()()(".toCharArray());// -> "()()"
        balanceBrackets(")(())(".toCharArray());// -> "(())"
        balanceBrackets(")())(()()(".toCharArray());// -> "()()()"

        //There can be multiple correct results per input

        balanceBrackets("(())())".toCharArray());// -> "(()())" or "(())()"
    }
}