package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by levin on 4/10/17.
 */

public class UberInterviewQuestions {

    // Sum UP
    //O(2^n)
    public static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int s = 0;

        for (int x : partial) s += x;

        if (s == target)
            System.out.println("sum(" + Arrays.toString(partial.toArray()) + ")=" + target);

        if (s >= target)
            return;

        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> remaining = new ArrayList<>();
            int n = numbers.get(i);

            for (int j = i + 1; j < numbers.size(); j++)
                remaining.add(numbers.get(j));

            ArrayList<Integer> partial_rec = new ArrayList<>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining, target, partial_rec);
        }
    }


    public static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers, target, new ArrayList<>());
    }


    // Brackets
    public static void brackets(int openStock, int closeStock, String s) {
        if (openStock == 0 && closeStock == 0) {
            System.out.println(s);
        }

        if (openStock > 0) {
            brackets(openStock - 1, closeStock + 1, s + "<");
        }

        if (closeStock > 0) {
            brackets(openStock, closeStock - 1, s + ">");
        }
    }

    public static void brackets2(final int N) {
        brackets2(N, 0, 0, new char[N * 2]);
    }

    public static void brackets2(int openStock, int closeStock, int index, char[] arr) {
        while (closeStock >= 0) {
            if (openStock > 0) {
                arr[index] = '<';
                brackets2(openStock - 1, closeStock + 1, index + 1, arr);
            }
            if (closeStock-- > 0) {
                arr[index++] = '>';
                if (index == arr.length) {
                    System.out.println(arr);
                }
            }
        }
    }


    // Permutations
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        List<Integer> result = new ArrayList<>();
        dfs(nums, results, result);
        return results;
    }

    public static void dfs(int[] nums, List<List<Integer>> results, List<Integer> result) {
        if (nums.length == result.size()) {
            List<Integer> temp = new ArrayList<>(result);
            results.add(temp);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!result.contains(nums[i])) {
                result.add(nums[i]);
                dfs(nums, results, result);
                result.remove(result.size() - 1);
            }
        }
    }


    public static void combinationUtil(int arr[], int data[], int start,
                                       int end, int index, int r) {
        // Current combination is ready to be printed, print it
        if (index == r) {
            for (int j = 0; j < r; j++)
                System.out.print(data[j] + " ");
            System.out.println("");
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    public static void printCombination(int arr[], int n, int r) {
        // A temporary array to store all combination one by one
        int data[] = new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n - 1, 0, r);
    }


    /**
     * Produce a List<String> which contains every combination which can be
     * made by taking one String from each inner String array within the
     * provided two-dimensional String array.
     *
     * @param twoDimStringArray a two-dimensional String array which contains
     *                          String arrays of variable length.
     * @return a List which contains every String which can be formed by taking
     * one String from each String array within the specified two-dimensional
     * array.
     */
    public static List<String> arrayOfArraysCombinations(String[][] twoDimStringArray) {
        // keep track of the size of each inner String array
        int sizeArray[] = new int[twoDimStringArray.length];

        // keep track of the index of each inner String array which will be used
        // to make the next combination
        int counterArray[] = new int[twoDimStringArray.length];

        // Discover the size of each inner array and populate sizeArray.
        // Also calculate the total number of combinations possible using the
        // inner String array sizes.
        int totalCombinationCount = 1;
        for (int i = 0; i < twoDimStringArray.length; ++i) {
            sizeArray[i] = twoDimStringArray[i].length;
            totalCombinationCount *= twoDimStringArray[i].length;
        }

        // Store the combinations in a List of String objects
        List<String> combinationList = new ArrayList<String>(totalCombinationCount);

        StringBuilder sb;  // more efficient than String for concatenation

        for (int countdown = totalCombinationCount; countdown > 0; --countdown) {
            // Run through the inner arrays, grabbing the member from the index
            // specified by the counterArray for each inner array, and build a
            // combination string.
            sb = new StringBuilder();
            for (int i = 0; i < twoDimStringArray.length; ++i) {
                sb.append(twoDimStringArray[i][counterArray[i]]);
            }
            combinationList.add(sb.toString());  // add new combination to list

            // Now we need to increment the counterArray so that the next
            // combination is taken on the next iteration of this loop.
            for (int incIndex = twoDimStringArray.length - 1; incIndex >= 0; --incIndex) {
                if (counterArray[incIndex] + 1 < sizeArray[incIndex]) {
                    ++counterArray[incIndex];
                    // None of the indices of higher significance need to be
                    // incremented, so jump out of this for loop at this point.
                    break;
                }
                // The index at this position is at its max value, so zero it
                // and continue this loop to increment the index which is more
                // significant than this one.
                counterArray[incIndex] = 0;
            }
        }
        return combinationList;
    }


    public static ArrayList<ArrayList<String>> arrayOfArraysPermutation(ArrayList<ArrayList<String>> arrays, int index) {

        if (index == arrays.size()) {
            ArrayList<String> emptyArray = new ArrayList<>();
            ArrayList<ArrayList<String>> emptyArrayOfArray = new ArrayList<>();
            emptyArrayOfArray.add(emptyArray);
            return emptyArrayOfArray;
        }

        ArrayList<ArrayList<String>> res_next = arrayOfArraysPermutation(arrays, index + 1);

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String string : arrays.get(index)) {

            // Put each number in the result of index + 1
            for (ArrayList<String> array : res_next) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(string);
                temp.addAll(array);
                result.add(temp);
            }
        }

        return result;
    }


    public static class Node {
        char value;
        List<Node> children;

        public Node(char value) {
            this.value = value;
            children = new ArrayList<>();
        }
    }


    public static String serialize(Node root) {
        if (root == null) return "";

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            if (node == null) {
                sb.append('#');
                continue;
            }

            sb.append(node.value);

            for (Node child : node.children) {
                queue.add(child);
            }
            queue.add(null);
        }

        return sb.toString();
    }


    public static Node deserialize(String input) {

        if (input == null || input.isEmpty()) {
            return null;
        }


        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(input.charAt(0));
        queue.add(root);

        int index = 2; // Assume that in the beginning of the string is always Root value and # symbol, so skip first 2 characters

        while (index < input.length()) {
            Node node = queue.poll();

            char currentValue = input.charAt(index);

            while (currentValue != '#') {
                Node childNode = new Node(currentValue);
                queue.add(childNode);
                node.children.add(childNode);
                index++;
                if (index >= input.length()) break;
                currentValue = input.charAt(index);
            }

            index++;

        }


        return root;

    }
}

/*

/**
*
* Serialize and deserialize a general tree
*         A
*      /  |   \
*    B    C     D
*   / \        / | \ \
*  E   F      I  G  H  J
*      |
*      K
*
*
* // BFS
*  A -> B C D -> E F -> null -> I G H J -> null -> K -> null -> null -> null ->null
*
* // DFS
*   A0 -> B1 -> E2 -> end -> F2 -> K3 -> end -> C1 -> D1 -> I2 -> G2 -> H2 -> J2
*
*   A -> # -> B C D -> # -> E F -> # -> # -> I G H J -> # -> # -> K -> #
*
*   add A to queue until hit end
*
*   poll A  add BCD, add BCD to a queue;
*
*   poll B  add EF, add EF to a queue;
*
* poll C add null, ;
*
* poll D , add I G H J, add I G H J to a queue;
*
* poll E, add null;
*
* poll F, add K, add K to a queue;
*
* end of string, stop
*
*/
/*

public class Node {
    char value;
    List<Node> children;

    public Node (char value) {
        this.value = value;
        children = new ArrayList<>();
    }
}


class Solution {

    public String serialize(Node root) {
        if (root == null) return "";

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            if (node == null) {
                sb.append('#');
                continue;
            }

            sb.append(node.value);

            for (Node child : node.children) {
                queue.add(child);
            }
            queue.add(null);
        }

        return sb.toString();
    }


    public Node deserialize(String input) {

        if (input == null || input.isEmpty()) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(input.charAt(0));
        queue.add(root);

        int index = 2; // Assume that in the beginning of the string is always Root value and # symbol, so skip first 2 characters

        while (index < input.length()) {
            Node node = queue.poll();

            char currentValue = input.charAt(index);

            while (currentValue != '#') {
                Node childNode = new Node(currentValue);
                queue.add(childNode);
                node.children.add(childNode);
                index++;
                if (index >= input.length()) break;
                currentValue = input.charAt(index);
            }
            index++;
        }

        return root;

    }
}

 */
