package com.example;

/**
 * Created by levin on 4/5/17.
 */

public class TenXInterviewQuestions {

    public static int[] findSum(int[] array, int sum) {

        if (array == null || array.length == 0) {
            return null;
        }


        return null;

    }

    public static int subArraySum(int arr[], int sum) {
        int curr_sum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= arr.length; i++) {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > sum && start < i - 1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            // If curr_sum becomes equal to sum, then return true
            if (curr_sum == sum) {
                int p = i - 1;
                System.out.println("Sum found between indexes " + start
                        + " and " + p);
                return 1;
            }

            // Add this element to curr_sum
            if (i < arr.length)
                curr_sum = curr_sum + arr[i];
        }

        System.out.println("No subarray found");
        return 0;
    }
}
