package com.example;

/**
 * Created by levin on 3/10/17.
 */

public class SearchQuestions {
    public static int binarySearch(int[] array, int n) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = (low + high)/2;

            if (array[middle] == n) {
                return middle;
            }

            if (array[middle] > n) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    public static int rotatedBinarySearch(int arr[], int l, int h, int key)  {
        if (l > h) return -1;

        int mid = (l+h)/2;

        if (arr[mid] == key) return mid;

        /* If arr[l...mid] is sorted */
        if (arr[l] <= arr[mid])  {
        /* As this subarray is sorted, we can quickly
           check if key lies in half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return rotatedBinarySearch(arr, l, mid-1, key);

            return rotatedBinarySearch(arr, mid+1, h, key);
        }

        /* If arr[l..mid] is not sorted, then arr[mid... r]
       must be sorted*/
        if (key >= arr[mid] && key <= arr[h])
            return rotatedBinarySearch(arr, mid+1, h, key);

        return rotatedBinarySearch(arr, l, mid-1, key);
    }
}
