package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.example.TreeQuestions.*;

/**
 * Created by levin on 3/15/17.
 */
public class TreeQuestionsTest {
    @Test
    public void testInvertTree() throws Exception {
        Node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);

        invertTree(root);
    }

    @Test
    public void testInvertTreeDFS() throws Exception {
        Node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);

        invertTreeDFS(root);
    }

    @Test
    public void testInvertTreeBFS() throws Exception {
        Node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);

        invertTreeBFS(root);
    }

    @Test
    public void testNthLargestNumberInBST() throws Exception {
        Node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);

        nthLargestNumbreInBST(root, new Increment(), 1);
        nthLargestNumbreInBST(root, new Increment(), 2);
        nthLargestNumbreInBST(root, new Increment(), 3);
        nthLargestNumbreInBST(root, new Increment(), 4);
        nthLargestNumbreInBST(root, new Increment(), 5);
    }

    @Test
    public void testFindLCA() throws Exception {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " + findLCA(root, 4, 5).value);
        System.out.println("LCA(4, 6) = " + findLCA(root, 4, 6).value);
        System.out.println("LCA(3, 4) = " + findLCA(root, 3, 4).value);
        System.out.println("LCA(2, 4) = " + findLCA(root, 2, 4).value);
    }

    private Node root;

    @Before
    public void setUp() throws Exception {
        root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println();
    }

    @Test
    public void testIsValidBST() throws Exception {
        System.out.print("Is tree a BST: " + isValidBST(root));
    }

    @Test
    public void testTreeTraversal() throws Exception {
        System.out.print("InOrder traversal: ");
        inOrder(root);
        System.out.println();

        System.out.print("PreOrder traversal: ");
        preOrder(root);
        System.out.println();

        System.out.print("PostOrder traversal: ");
        postOrder(root);
        System.out.println();

    }

    @Test
    public void testBSTIterator() throws Exception {
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    @Test
    public void testIsBalanced() throws Exception {

        System.out.print(isTreeBalanced(root));

    }
}