package com.example;

import java.util.HashMap;
import java.util.Stack;

public class Snap2019InterviewQuestions {

    // 03.05.2019 On-site interview
    // 1. Implement ref counter on Java
    // 2. Implement OrderEnforcer
    // 3. Implement Blocking Queue using locks
    // 4. Find Max Gain similar to Stocks.
    // 5. Android App architecture. Libraries, ORM

    // 17.04.2019 Phone interview with Snap
    // Questions:
    // 1. Kth element in an array

    // Questions found on Glassdoor

    public static class Node {
        int data;
        Node left, right;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    // Find all strings that match specific pattern in a dictionary
    public static class FindPatternMatch {
        // Function to encode given string
        public static String encodeString(String str) {
            HashMap<Character, Integer> map = new HashMap<>();
            String res = "";
            int i = 0;

            // for each character in given string
            char ch;
            for (int j = 0; j < str.length(); j++) {
                ch = str.charAt(j);

                // If the character is occurring for the first
                // time, assign next unique number to that char
                if (!map.containsKey(ch))
                    map.put(ch, i++);

                // append the number associated with current
                // character into the output string
                res += map.get(ch);
            }

            return res;
        }

        // Function to print all the strings that match the
        // given pattern where every character in the pattern is
        // uniquely mapped to a character in the dictionary
        public static void findMatchedWords(String[] dict, String pattern) {
            // len is length of the pattern
            int len = pattern.length();

            // encode the string
            String hash = encodeString(pattern);

            // for each word in the dictionary array
            for (String word : dict) {
                // If size of pattern is same as size of current
                // dictionary word and both pattern and the word
                // has same hash, print the word
                if (word.length() == len && encodeString(word).equals(hash))
                    System.out.print(word + " ");
            }
        }
    }


    // Sum of two large numbers
    public static class BigIntegerSum {

        // Function for finding sum of larger numbers
        public static String findSum(String str1, String str2) {
            // Before proceeding further, make sure length
            // of str2 is larger.
            if (str1.length() > str2.length()) {
                String t = str1;
                str1 = str2;
                str2 = t;
            }

            // Take an empty String for storing result
            String str = "";

            // Calculate lenght of both String
            int n1 = str1.length(), n2 = str2.length();

            // Reverse both of Strings
            str1 = new StringBuilder(str1).reverse().toString();
            str2 = new StringBuilder(str2).reverse().toString();

            int carry = 0;
            for (int i = 0; i < n1; i++) {
                // Do school mathematics, compute sum of
                // current digits and carry
                int sum = (str1.charAt(i) - '0' + (str2.charAt(i) - '0') + carry);
                str += (char) (sum % 10 + '0');

                // Calculate carry for next step
                carry = sum / 10;
            }

            // Add remaining digits of larger number
            for (int i = n1; i < n2; i++) {
                int sum = (str2.charAt(i) - '0') + carry;
                str += (char) (sum % 10 + '0');
                carry = sum / 10;
            }

            // Add remaining carry
            if (carry > 0)
                str += (char) (carry + '0');

            // reverse resultant String
            str = new StringBuilder(str).reverse().toString();

            return str;
        }
    }

    // K’th Largest element in BST using constant extra space
    public static class KthLargestElementInBST {

        // helper function to create a new Node
        public static Node newNode(int data) {
            Node temp = new Node();
            temp.data = data;
            temp.right = null;
            temp.left = null;
            return temp;
        }

        public static Node KthLargestUsingMorrisTraversal(Node root, int k) {
            Node curr = root;
            Node Klargest = null;

            // count variable to keep count of visited Nodes
            int count = 0;

            while (curr != null) {
                // if right child is NULL
                if (curr.right == null) {

                    // first increment count and check if count = k
                    if (++count == k) {
                        Klargest = curr;
                    }

                    // otherwise move to the left child
                    curr = curr.left;
                } else {

                    // find inorder successor of current Node
                    Node succ = curr.right;

                    while (succ.left != null && succ.left != curr)
                        succ = succ.left;

                    if (succ.left == null) {

                        // set left child of successor to the
                        // current Node
                        succ.left = curr;

                        // move current to its right
                        curr = curr.right;
                    }

                    // restoring the tree back to original binary
                    // search tree removing threaded links
                    else {

                        succ.left = null;

                        if (++count == k)
                            Klargest = curr;

                        // move current to its left child
                        curr = curr.left;
                    }
                }
            }
            return Klargest;
        }


        public static class Count {
            int c = 0;
        }

        // utility function to find kth largest no in
        // a given tree
        public static void kthLargestUtil(Node node, int k, Count C) {
            // Base cases, the second condition is important to
            // avoid unnecessary recursive calls
            if (node == null || C.c >= k)
                return;

            // Follow reverse inorder traversal so that the
            // largest element is visited first
            kthLargestUtil(node.right, k, C);

            // Increment count of visited nodes
            C.c++;

            // If c becomes k now, then this is the k'th largest
            if (C.c == k) {
                System.out.println(k + "th largest element is " +
                        node.data);
                return;
            }

            // Recur for left subtree
            kthLargestUtil(node.left, k, C);
        }

        // Method to find the kth largest no in given BST
        public static void kthLargest(Node root, int k) {
            Count c = new Count(); // object of class count
            kthLargestUtil(root, k, c);
        }
    }


    // Construct Tree from given Inorder and Preorder traversals
    public static class ConstructTree {
        static int preIndex = 0;

        public static Node buildTree(char in[], char pre[], int inStrt, int inEnd) {
            if (inStrt > inEnd)
                return null;

        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
            Node tNode = new Node(pre[preIndex++]);

            /* If this node has no children then return */
            if (inStrt == inEnd)
                return tNode;

            /* Else find the index of this node in Inorder traversal */
            int inIndex = search(in, inStrt, inEnd, tNode.data);

        /* Using index in Inorder traversal, construct left and
           right subtress */
            tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
            tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

            return tNode;
        }

        /* Function to find index of value in arr[start...end]
     The function assumes that value is present in in[] */
        public static int search(char arr[], int strt, int end, int value) {
            int i;
            for (i = strt; i <= end; i++) {
                if (arr[i] == value)
                    return i;
            }
            return i;
        }

        /* This funtcion is here just to test buildTree() */
        public static void printInorder(Node node) {
            if (node == null)
                return;

            /* first recur on left child */
            printInorder(node.left);

            /* then print the data of node */
            System.out.print((char) node.data + " ");

            /* now recur on right child */
            printInorder(node.right);
        }
    }

    // Balance Brackets
    public static class Brackets {
        public static void generateAllCombinationsOfBrackets(int K) {

            generateAllCombinationsOfBracketsHelper(K, 0, "");

        }

        public static void generateAllCombinationsOfBracketsHelper(int left, int right, String currString) {
            if (left == 0 && right == 0) {
                System.out.println(currString);
            }

            if (left > 0) {
                generateAllCombinationsOfBracketsHelper(left - 1, right + 1, currString + "(");
            }

            if (right > 0) {
                generateAllCombinationsOfBracketsHelper(left, right - 1, currString + ")");
            }
        }

        public static void balanceBrackets(char[] string) {
            int counter = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < string.length; i++) {
                if (string[i] == '(') {
                    counter++;
                    continue;
                }

                if (string[i] == ')') {
                    if (counter > 0) {
                        counter--;
                    } else {
                        string[i] = '*';
                    }
                }
            }

            for (int i = string.length - 1; i >= 0; i--) {
                if (counter == 0) {
                    break;
                }
                if (string[i] == '(') {
                    string[i] = '*';
                    counter--;
                }
            }

            /*counter = 0;
            for (int i = string.length - 1; i >= 0; i--) {
                if (string[i] == ')') {
                    counter++;
                    continue;
                }

                if (string[i] == '(') {
                    if (counter > 0) {
                        counter--;
                    } else {
                        string[i] = '*';
                    }
                }
            }*/

            int j = 0;
            for (int i = 0; i < string.length; i++) {
                if (string[i] == '*') {
                    continue;
                }
                string[j++] = string[i];
            }

            String result = new String(string);
            result = result.substring(0, j);


            System.out.println(result);
        }
    }

    // Powerset
    public static class PowerSet {
        // str : Stores input string
        // curr : Stores current subset
        // index : Index in current subset, curr
        static void powerSet(String str, int index, String curr) {
            int n = str.length();

            // base case
            if (index == n) {
                return;
            }

            // First print current subset
            System.out.println(curr);

            // Try appending remaining characters
            // to current subset
            for (int i = index + 1; i < n; i++) {
                curr += str.charAt(i);
                powerSet(str, i, curr);

                // Once all subsets beginning with
                // initial "curr" are printed, remove
                // last character to consider a different
                // prefix of subsets.
                curr = curr.substring(0, curr.length() - 1);
            }
        }
    }

    // Permutations

    // DFS/BFS


}
