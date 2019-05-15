package com.example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by levin on 3/14/17.
 */

public class TreeQuestions {

    public static class Node {
        int value;
        Node left, right;

        public Node(int data) {
            this.value = data;
            left = right = null;
        }
    }

    public static boolean isValidBST(Node node) {
        return isValidBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBST(Node node, int min, int max) {
        if (node == null) return true;

        if (node.value < min || node.value > max) return false;

        return isValidBST(node.left, min, node.value) &&
                isValidBST(node.right, node.value + 1, max);
    }

    public static void inOrder(Node node) {

        if (node == null) return;

        inOrder(node.left);

        System.out.print(node.value + " ");

        inOrder(node.right);
    }

    public static void preOrder(Node node) {
        if (node == null) return;

        System.out.print(node.value + " ");

        preOrder(node.left);

        preOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);

        postOrder(node.right);

        System.out.print(node.value + " ");
    }

    public static class BSTIterator {
        Stack<Node> stack;

        public BSTIterator(Node root) {
            stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            Node node = stack.pop();
            int result = node.value;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            return result;
        }

    }

    public static boolean isTreeBalanced(Node node) {
        if (node == null) return true;

        return Math.abs(getHeight(node.left) - getHeight(node.right)) < 2;
    }

    public static int getHeight(Node node) {
        if (node == null) return 0;

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    // Lowest Common Ancestor
    public static Node findLCA(Node node, int n1, int n2) {  // O( N )
        // Base case
        if (node == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.value == n1 || node.value == n2)
            return node;

        // Look for keys in left and right subtrees
        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    public static class Increment {
        public Integer counter;

        public Increment() {
            counter = new Integer(0);
        }
    }

    public static void nthLargestNumbreInBST(Node root, Increment counter, int k) {
        if (root == null || counter.counter > k) {
            return;
        }

        nthLargestNumbreInBST(root.right, counter, k);

        counter.counter++;

        if (counter.counter == k) {
            System.out.println(root.value);
        }

        nthLargestNumbreInBST(root.left, counter, k);
    }

    public static Node insert(Node node, int key) {
        /* If the tree is empty, return a new node */
        if (node == null) return new Node(key);

        /* Otherwise, recur down the tree */
        if (key < node.value)
            node.left = insert(node.left, key);
        else if (key > node.value)
            node.right = insert(node.right, key);

        /* return the (unchanged) node pointer */
        return node;
    }

    public static Node invertTree(Node root) {
        if (root == null) {
            return null;
        }

        final Node left = root.left,
                right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public static Node invertTreeDFS(Node root) {

        if (root == null) {
            return null;
        }

        final Deque<Node> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            final Node node = stack.pop();
            final Node left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    public static Node invertTreeBFS(Node root) {

        if (root == null) {
            return null;
        }

        final Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            final Node left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static boolean calculateUnivalTrees(Node node, Increment counter) {
        if (node == null) return true;
        boolean left = calculateUnivalTrees(node.left, counter);
        boolean right = calculateUnivalTrees(node.right, counter);
        if (left && right && (node.left == null || node.left.value == node.value) &&
                (node.right == null || node.right.value == node.value)) {
            counter.counter++;
            return true;
        }
        return false;
    }

    public static boolean isTreeUnivalRoot(Node root) {
        if (root == null) {
            return true;
        }

        return isTreeUnival(root.left, root.value) && isTreeUnival(root.right, root.value);
    }

    public static boolean isTreeUnival(Node n, int val) {
        if (n == null) {
            return true;
        }
        if (n.value != val) {
            return false;
        }

        return isTreeUnival(n.left, val) && isTreeUnival(n.right, val);
    }
}
