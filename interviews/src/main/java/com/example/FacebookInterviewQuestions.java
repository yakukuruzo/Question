package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Created by levin on 4/10/17.
 */

public class FacebookInterviewQuestions {


    /*


            10

            110

            111100

            1111111111100000

     */

    public static int findLastGoodCommitShorter(boolean[] commitHistory) {
        if (commitHistory == null || commitHistory.length == 0) {
            return -1;
        }

        if (commitHistory.length == 1) {
            if (commitHistory[0])
                return 0;
            else
                return -1;
        }

        int start = 0;
        int end = commitHistory.length - 1;
        int mid;
         while(start < end){

             mid = (start + end) / 2;

             if (commitHistory[mid] && !commitHistory[mid+1]) {
                 return mid;
             }

             if (commitHistory[mid]) {
                 start = mid;
             } else {
                 end = mid;
             }

         }

         return -1;
    }

    public static int findLastGoodCommit(boolean[] commitHistory) {

        if (commitHistory == null || commitHistory.length == 0) {
            return -1;
        }

        if (commitHistory.length == 1) {
            if (commitHistory[0])
                return 0;
            else
                return -1;
        }

        int low = 0;
        int high = commitHistory.length - 1;

        while (low < high) {

            if (low == high && commitHistory[low]) {
                return low;
            }

            if (high - low == 1) {
                if (!commitHistory[high] && commitHistory[low]) {
                    return low;
                }
            }

            int mid = (high + low) / 2;

            if (commitHistory[mid]) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return -1;
    }

    public static long countNumberWithNonConsecutiveOnes(String prefix, String max, int rem, int prevOne, long[][] DP) {
        if (prefix.compareTo(max) > 0) return 0;
        if (rem == 0) {
            return 1;
        }
        if (DP[rem][prevOne] != -1) return DP[rem][prevOne];
        long ret = 0;
        ret += countNumberWithNonConsecutiveOnes(prefix + "0", max, rem - 1, 0, DP);
        if (prevOne != 1) {
            ret += countNumberWithNonConsecutiveOnes(prefix + "1", max, rem - 1, 1, DP);
        }
        return DP[rem][prevOne] = ret;
    }

    public static boolean isConsecutiveOnes(int n, int bitMask) {
        return (((n << 1) & n) & bitMask) != 0;
    }

    public static boolean canStringBeSplitted(String string, Set<String> dict) {
        if (string.isEmpty()) return false;

        boolean canBeSplitted = false;
        for (String word : dict) {
            if (string.equals(word)) {
                return true;
            }

            if (string.startsWith(word)) {
                canBeSplitted |= canStringBeSplitted(string.substring(word.length(), string.length()), dict);
                if (canBeSplitted) {
                    return true;
                }
            }
        }

        return canBeSplitted;
    }

    private static final String[] specialNames = {
            "",
            " thousand",
            " million",
            " billion",
            " trillion",
            " quadrillion",
            " quintillion"
    };

    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    public static String convertLessThanOneThousand(int number) {
        String current;

        if (number % 100 < 20) {
            current = numNames[number % 100];
            number /= 100;
        } else {
            current = numNames[number % 10];
            number /= 10;

            current = tensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) return current;
        return numNames[number] + " hundred" + current;
    }

    public static String convert(int number) {

        if (number == 0) {
            return "zero";
        }

        String prefix = "";

        if (number < 0) {
            number = -number;
            prefix = "negative";
        }

        String current = "";
        int place = 0;

        do {
            int n = number % 1000;
            if (n != 0) {
                String s = convertLessThanOneThousand(n);
                current = s + specialNames[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }

    public static class Position {
        int i;
        int j;
        int distance;

        public Position(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.distance = dist;
        }

        public Position() {
            this.i = -1;
            this.j = -1;
            this.distance = -1;
        }
    }

    public static int[][] findDistance(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int[][] result = new int[matrix.length][matrix[0].length];

        Queue<Position> q = new LinkedList<>();
        // finding Guards location and adding into queue
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = -1;
                if (matrix[i][j] == 'g') {
                    q.offer(new Position(i, j, 0));
                    result[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Position p = q.poll();
            // result[p.i][p.j] = p.distance;
            updateNeighbors(p, matrix, q, result);
        }
        return result;
    }

    public static void updateNeighbors(Position p, char[][] matrix, Queue<Position> q, int[][] result) {
        int[][] indexArray = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] index : indexArray) {
            if (isValid(p.i + index[0], p.j + index[1], matrix, result)) {
                result[p.i + index[0]][p.j + index[1]] = p.distance + 1;
                q.offer(new Position(p.i + index[0], p.j + index[1], p.distance + 1));
            }
        }
    }

    public static boolean isValid(int i, int j, char[][] matrix, int[][] result) {
        if ((i < 0 || i > matrix.length - 1) || (j < 0 || j > matrix[0].length - 1) || matrix[i][j] == 'w'
                || matrix[i][j] == 'g' || result[i][j] != -1) {
            return false;
        }
        return true;
    }


    static class Node {
        int key;
        Node left, right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // returns true if trees with roots as root1 and root2 are mirror
    public static boolean isMirror(Node node1, Node node2) {
        // if both trees are empty, then they are mirror image
        if (node1 == null && node2 == null)
            return true;

        // For two trees to be mirror images, the following three
        // conditions must be true
        // 1 - Their root node's key must be same
        // 2 - left subtree of left tree and right subtree
        //      of right tree have to be mirror images
        // 3 - right subtree of left tree and left subtree
        //      of right tree have to be mirror images
        if (node1 != null && node2 != null && node1.key == node2.key)
            return (isMirror(node1.left, node2.right)
                    && isMirror(node1.right, node2.left));

        // if neither of the above conditions is true then
        // root1 and root2 are mirror images
        return false;
    }

    // returns true if the tree is symmetric i.e
    // mirror image of itself
    public static boolean isTreeSymmetric(Node node) {
        // check if tree is mirror of itself
        return isMirror(node, node);
    }

    public static int minimumDepth(Node root) {
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null)
            return 0;

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;

        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minimumDepth(root.right) + 1;

        // If right subtree is NULL, recur for right subtree
        if (root.right == null)
            return minimumDepth(root.left) + 1;

        return Math.min(minimumDepth(root.left),
                minimumDepth(root.right)) + 1;
    }


    /*
        Make a mirror of a tree
     */
    public static Node mirrorTree(Node node) {
        if (node == null)
            return node;

        /* do the subtrees */
        Node left = mirrorTree(node.left);
        Node right = mirrorTree(node.right);

        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;
    }


    /*
    * Max path in a tree
    */

    public static class Res {
        public int val;
    }

    // This function returns overall maximum path sum in 'res'
    // And returns max path sum going through root.
    public static int findMaxUtil(Node node, Res res) {

        // Base Case
        if (node == null)
            return 0;

        // l and r store maximum path sum going through left and
        // right child of root respectively
        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);

        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + node.key, node.key);


        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.key);

        // Store the Maximum Result.
        res.val = Math.max(res.val, max_top);

        return max_single;
    }

    // Returns maximum path sum in tree with given root
    public static int findMaxSum(Node node) {

        // Initialize result
        // int res2 = Integer.MIN_VALUE;
        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        // Compute and return result
        findMaxUtil(node, res);
        return res.val;
    }


    /*
        Recreate a tree
     */
    // Creates a node with key as 'i'.  If i is root, then it changes
    // root.  If parent of i is not created, then it creates parent first
    void createNode(int parent[], int i, Node created[], Node root) {
        // If this node is already created
        if (created[i] != null)
            return;

        // Create a new node and set created[i]
        created[i] = new Node(i);

        // If 'i' is root, change root pointer and return
        if (parent[i] == -1) {
            root = created[i];
            return;
        }

        // If parent is not created, then create parent first
        if (created[parent[i]] == null)
            createNode(parent, parent[i], created, root);

        // Find parent pointer
        Node p = created[parent[i]];

        // If this is first child of parent
        if (p.left == null)
            p.left = created[i];
        else // If second child

            p.right = created[i];
    }

    /* Creates tree from parent[0..n-1] and returns root of
       the created tree */
    Node createTree(int parent[], int n) {
        // Create an array created[] to keep track
        // of created nodes, initialize all entries
        // as NULL
        Node[] created = new Node[n];
        for (int i = 0; i < n; i++)
            created[i] = null;

        Node root = null;

        for (int i = 0; i < n; i++)
            createNode(parent, i, created, root);

        return root;
    }


    /*
        Decode string
     */
    public static int countDecoding(char[] digits, int n) {
        // base cases
        if (n == 0 || n == 1)
            return 1;

        int count = 0;  // Initialize count

        // If the last digit is not 0, then last digit must add to
        // the number of words
        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);

        // If the last two digits form a number smaller than or equal to 26,
        // then consider last two digits and recur
        if (digits[n - 2] < '2' || (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);

        return count;
    }

    // A Dynamic Programming based function to count decodings
    public static int countDecodingDP(char[] digits, int n) {
        int count[] = new int[n + 1]; // A table to store results of subproblems
        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; i++) {
            count[i] = 0;

            // If the last digit is not 0, then last digit must add to
            // the number of words
            if (digits[i - 1] > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller than 2 and last digit is
            // smaller than 7, then last two digits form a valid character
            if (digits[i - 2] < '2' || (digits[i - 2] == '2' && digits[i - 1] < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }


    /*
        Push zeroes to the end
     */
    public static void pushZerosToEnd(int arr[], int n) {
        int count = 0;  // Count of non-zero elements

        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i]; // here count is
        // incremented

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < n)
            arr[count++] = 0;
    }

    // Returns length of the maximum length subarray with 0 sum
    public static int maxLenSumTo0(int arr[]) {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<>();

        int sum = 0;      // Initialize sum of elements
        int max_len = 0;  // Initialize result

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum
            sum += arr[i];

            if (arr[i] == 0 && max_len == 0)
                max_len = 1;

            if (sum == 0)
                max_len = i + 1;

            // Look this sum in hash table
            Integer prev_i = hM.get(sum);

            // If this sum is seen before, then update max_len
            // if required
            if (prev_i != null)
                max_len = Math.max(max_len, i - prev_i);
            else  // Else put this sum in hash table
                hM.put(sum, i);
        }

        return max_len;
    }

    static Boolean printZeroSumSubarray(int arr[]) {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<>();

        // Initialize sum of elements
        int sum = 0;

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum
            sum += arr[i];

            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash map
            if (arr[i] == 0 || sum == 0 || hM.get(sum) != null)
                return true;

            // Add sum to hash map
            hM.put(sum, i);
        }

        // We reach here only when there is no subarray with 0 sum
        return false;
    }


    public static int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<int[]>();
        int result = 0;

        for (int i = 0; i <= s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int[] a = {i, 0};
                stack.push(a);
            } else {
                if (stack.empty() || stack.peek()[1] == 1) {
                    int[] a = {i, 1};
                    stack.push(a);
                } else {
                    stack.pop();
                    int currentLen = 0;
                    if (stack.empty()) {
                        currentLen = i + 1;
                    } else {
                        currentLen = i - stack.peek()[0];
                    }
                    result = Math.max(result, currentLen);
                }
            }
        }

        return result;
    }

    public static int treeDiameter(Node root) {
        /* base case if tree is empty */
        if (root == null)
            return 0;

        /* get the height of left and right sub trees */
        int lheight = height(root.left);
        int rheight = height(root.right);

        /* get the diameter of left and right subtrees */
        int ldiameter = treeDiameter(root.left);
        int rdiameter = treeDiameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(lheight + rheight + 1,
                Math.max(ldiameter, rdiameter));

    }

    /*The function Compute the "height" of a tree. Height is the
      number f nodes along the longest path from the root node
      down to the farthest leaf node.*/
    public static int height(Node node) {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (1 + Math.max(height(node.left), height(node.right)));
    }

    public static ArrayList<String> getpowerset(int a[], int n, ArrayList<String> ps) {
        if (n < 0) {
            return null;
        }
        if (n == 0) {
            if (ps == null)
                ps = new ArrayList<String>();
            ps.add(" ");
            return ps;
        }
        ps = getpowerset(a, n - 1, ps);
        ArrayList<String> tmp = new ArrayList<>();
        for (String s : ps) {
            if (s.equals(" "))
                tmp.add("" + a[n - 1]);
            else
                tmp.add(s + a[n - 1]);
        }
        ps.addAll(tmp);
        return ps;
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int[] result = new int[nums.length - k + 1];

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.poll();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.offer(i);

            if (i + 1 >= k)
                result[i + 1 - k] = nums[deque.peek()];
        }

        return result;
    }


    /*
        Convert Binary Tree into Doubly Linked List
     */
    public static Node bintree2listUtil(Node node) {
        // Base case
        if (node == null)
            return node;

        // Convert the left subtree and link to root
        if (node.left != null) {
            // Convert the left subtree
            Node left = bintree2listUtil(node.left);

            // Find inorder predecessor. After this loop, left
            // will point to the inorder predecessor
            for (; left.right != null; left = left.right) ;

            // Make root as next of the predecessor
            left.right = node;

            // Make predecssor as previous of root
            node.left = left;
        }

        // Convert the right subtree and link to root
        if (node.right != null) {
            // Convert the right subtree
            Node right = bintree2listUtil(node.right);

            // Find inorder successor. After this loop, right
            // will point to the inorder successor
            for (; right.left != null; right = right.left) ;

            // Make root as previous of successor
            right.left = node;

            // Make successor as next of root
            node.right = right;
        }

        return node;
    }

    // The main function that first calls bintree2listUtil(), then follows
    // step 3 of the above algorithm

    public static Node bintree2list(Node node) {
        // Base case
        if (node == null)
            return node;

        // Convert to DLL using bintree2listUtil()
        node = bintree2listUtil(node);

        // bintree2listUtil() returns root node of the converted
        // DLL.  We need pointer to the leftmost node which is
        // head of the constructed DLL, so move to the leftmost node
        while (node.left != null)
            node = node.left;

        return node;
    }

    /*
        Convert Binary Tree into Circular Doubly Linked List
     */
    // concatenate both the lists and returns the head of the List
    public static Node concatenate(Node leftList, Node rightList) {
        // If either of the list is empty, then
        // return the other list
        if (leftList == null)
            return rightList;
        if (rightList == null)
            return leftList;

        // Store the last Node of left List
        Node leftLast = leftList.left;

        // Store the last Node of right List
        Node rightLast = rightList.left;

        // Connect the last node of Left List
        // with the first Node of the right List
        leftLast.right = rightList;
        rightList.left = leftLast;

        // left of first node refers to
        // the last node in the list
        leftList.left = rightLast;

        // Right of last node refers to the first
        // node of the List
        rightLast.right = leftList;

        // Return the Head of the List
        return leftList;
    }

    // Method converts a tree to a circular
    // Link List and then returns the head
    // of the Link List
    public static Node bTreeToCList(Node root) {
        if (root == null)
            return null;

        // Recursively convert left and right subtrees
        Node left = bTreeToCList(root.left);
        Node right = bTreeToCList(root.right);

        // Make a circular linked list of single node
        // (or root). To do so, make the right and
        // left pointers of this node point to itself
        root.left = root.right = root;

        // Step 1 (concatenate the left list with the list
        //         with single node, i.e., current node)
        // Step 2 (concatenate the returned list with the
        //         right List)
        return concatenate(concatenate(left, root), right);
    }

}