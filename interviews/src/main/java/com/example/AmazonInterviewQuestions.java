package com.example;

import java.util.Stack;

public class AmazonInterviewQuestions {

    // Next Greater Element
    /* prints element and NGE pair for all elements of arr[] of size n */
    static void printNGE(int arr[], int n) {
        int i = 0;
        Stack<Integer> s = new Stack<>();
        int element, next;

        /* push the first element to stack */
        s.push(arr[0]);

        // iterate for rest of the elements
        for (i = 1; i < n; i++) {
            next = arr[i];

            if (!s.isEmpty()) {

                // if stack is not empty, then
                // pop an element from stack
                element = s.pop();

                /* If the popped element is smaller than
                   next, then a) print the pair b) keep
                   popping while elements are smaller and
                   stack is not empty */
                while (element < next) {
                    System.out.println(element + " --> " + next);
                    if (s.isEmpty())
                        break;
                    element = s.pop();
                }

                /* If element is greater than next, then
                   push the element back */
                if (element > next)
                    s.push(element);
            }

            /* push next to stack so that we can find next
               greater for it */
            s.push(next);
        }

        /* After iterating over the loop, the remaining
           elements in stack do not have the next greater
           element, so print -1 for them */
        while (!s.isEmpty()) {
            element = s.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }
    }

    // Maximum sum such that no two elements are adjacent
    public static int FindMaxSum(int arr[], int n) {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++) {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }

    // Edit Distance
    public static int min(int x, int y, int z) {
        if (x <= y && x <= z) return x;
        if (y <= x && y <= z) return y;
        else return z;
    }

    public static int editDistDP(String str1, String str2, int m, int n) {
        // Create a table to store results of subproblems
        int dp[][] = new int[m + 1][n + 1];

        // Fill d[][] in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i == 0)
                    dp[i][j] = j;  // Min. operations = j

                    // If second string is empty, only option is to
                    // remove all characters of second string
                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char
                    // and recur for remaining string
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                    // If the last character is different, consider all
                    // possibilities and find the minimum
                else
                    dp[i][j] = 1 + min(dp[i][j - 1],  // Insert
                            dp[i - 1][j],  // Remove
                            dp[i - 1][j - 1]); // Replace
            }
        }

        return dp[m][n];
    }

    // Assembly Line Scheduling
    static int NUM_LINE = 2;
    static int NUM_STATION = 4;

    // Utility function to find minimum of two numbers
    static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int carAssembly(int a[][], int t[][], int e[], int x[]) {
        int T1[] = new int[NUM_STATION];
        int T2[] = new int[NUM_STATION];
        int i;

        // time taken to leave first station in line 1
        T1[0] = e[0] + a[0][0];

        // time taken to leave first station in line 2
        T2[0] = e[1] + a[1][0];

        // Fill tables T1[] and T2[] using
        // the above given recursive relations
        for (i = 1; i < NUM_STATION; ++i) {
            T1[i] = min(T1[i - 1] + a[0][i],
                    T2[i - 1] + t[1][i] + a[0][i]);
            T2[i] = min(T2[i - 1] + a[1][i],
                    T1[i - 1] + t[0][i] + a[1][i]);
        }

        // Consider exit times and retutn minimum
        return min(T1[NUM_STATION - 1] + x[0],
                T2[NUM_STATION - 1] + x[1]);
    }

}
