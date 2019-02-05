package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by levin on 3/10/17.
 */

public class MathQuestions {

    public static void sumTo2(int[] numberArray, int sum) { //NlogN
        if (numberArray == null || numberArray.length == 0) {
            System.out.println("The array is empty");
        }
        System.out.println("Before sort:" + numberArray.toString());
        Arrays.sort(numberArray);
        System.out.println("After sort:" + numberArray.toString());

        for (int i = 0; i < numberArray.length - 1; i++) {
            int currentNumber = numberArray[i];
            int numberToFind = sum - currentNumber;
            int position = Arrays.binarySearch(numberArray, i + 1, numberArray.length, numberToFind);
            if (position >= 0) {
                System.out.println("Pair: " + currentNumber + ", " + numberArray[position]);
            }
        }
    }

    public static void sumTo2HashMap(int[] numberArray, int sum) { // N
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numberArray.length; i++) {
            map.put(sum - numberArray[i], i);
        }

        for (int i = 0; i < numberArray.length; i++) {
            if (map.containsKey(numberArray[i])) {
                if (map.get(numberArray[i]) != i) {
                    System.out.println("Pair: " + numberArray[i] + ", " + numberArray[map.get(numberArray[i])]);
                }
            }
        }
    }

    public static void twoSumFromInternet(int[] numbers, int target) { // N
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(target - numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                if (map.get(numbers[i]) != i) {
                    System.out.println("Pair: " + numbers[i] + ", " + numbers[map.get(numbers[i])]);
                }
            }
        }
    }

    public static void sumTo2WithPointers(int[] numberArray, int target) { //NlogN
        Arrays.sort(numberArray);

        int start = 0;
        int end = numberArray.length - 1;

        while (start < end) {
            int sum = numberArray[start] + numberArray[end];
            if (sum == target) {
                System.out.println("Pair: " + numberArray[start] + ", " + numberArray[end]);
                start++;
                end--;
            } else {
                if (sum > target) end--;
                if (sum < target) start++;
            }
        }
    }

    public static void sumTo3(int[] numberArray, int target) {
        if (numberArray == null) return;
        Arrays.sort(numberArray);

        for (int i = 0; i < numberArray.length - 2; i++) {
            int start = i + 1;
            int end = numberArray.length - 1;
            while (start < end) {
                int sum = numberArray[i] + numberArray[start] + numberArray[end];
                if (sum == target) {
                    System.out.println("Triple: " + numberArray[i] + ", " + numberArray[start] + ", " + numberArray[end]);
                    start++;
                    end--;
                } else {
                    if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
    }

    public static List<List<Integer>> fourSum(int[] num, int target) {
        //Create the dictionary.
        HashMap<Integer, ArrayList<ArrayList<Integer>>> dict = new HashMap<>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                ArrayList<Integer> pair = new ArrayList<>(2);
                pair.add(i);
                pair.add(j);
                if (!dict.containsKey(sum)) {
                    ArrayList<ArrayList<Integer>> value = new ArrayList<>();
                    value.add(pair);
                    dict.put(sum, value);
                } else {
                    ArrayList<ArrayList<Integer>> value = dict.get(sum);
                    value.add(pair);
                }
            }
        }
        //Use HashSet to prevent duplicate result.
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (Integer sum : dict.keySet()) {
            ArrayList<ArrayList<Integer>> sumPair = dict.get(sum);
            if (dict.containsKey(target - sum)) {
                if (target - sum == sum && sumPair.size() == 1)
                    continue;
                ArrayList<ArrayList<Integer>> pairs = dict.get(target - sum);
                for (ArrayList<Integer> pair1 : sumPair) {
                    for (ArrayList<Integer> pair2 : pairs) {
                        //Make sure it is not the same pair.
                        if (pair1 == pair2)
                            continue;
                        //Make sure there is no same element in two pairs.
                        if (pair1.contains(pair2.get(0)) || pair1.contains(pair2.get(1)))
                            continue;
                        ArrayList<Integer> tmpResult = new ArrayList<>(4);
                        tmpResult.add(num[pair1.get(0)]);
                        tmpResult.add(num[pair1.get(1)]);
                        tmpResult.add(num[pair2.get(0)]);
                        tmpResult.add(num[pair2.get(1)]);
                        //Sort the list and add it into the set.
                        Collections.sort(tmpResult);
                        System.out.println("Qudriple: " + Arrays.toString(tmpResult.toArray()));
                        set.add(tmpResult);
                    }
                }
            }
        }
        List<List<Integer>> ret = new LinkedList<>();
        ret.addAll(set);
        return ret;
    }

    public static void fibonacciLinear(int Nth) {
        if (Nth == 1 || Nth == 2) {
            System.out.print("1");
        }

        int first = 1, second = 1;
        for (int i = 3; i <= Nth; i++) {
            int next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
        System.out.println();
    }

    public static int fibonacciRecursive(int Nth) {
        return fibonacciRecursive(Nth, new int[Nth]);
    }

    private static int fibonacciRecursive(int Nth, int[] fibonacciValues) {
        if (Nth <= 1) {
            //System.out.print("1 ");
            return 1;
        }

        if (fibonacciValues[Nth - 1] != 0) {
            return fibonacciValues[Nth - 1];
        }

        int number = fibonacciRecursive(Nth - 1, fibonacciValues) + fibonacciRecursive(Nth - 2, fibonacciValues);
        fibonacciValues[Nth - 1] = number;
        return number;
    }

    public static void checkNumberIfFibonacci(int N) {
        int upper = 5 * N * N + 4;
        int lower = 5 * N * N - 4;

        int upperSqrt = (int) Math.sqrt(upper);
        int lowerSqrt = (int) Math.sqrt(lower);

        int upperNew = upperSqrt * upperSqrt;
        int lowerNew = lowerSqrt * lowerSqrt;

        System.out.println("Is " + N + " a Fibonacci number? -> " + (upper == upperNew || lower == lowerNew));
    }

    /**
     * N - array length
     * M - value to check
     * <p>
     * time: O(N*M)
     * space: O(lg M)
     */
    public static boolean isScorePossible(int value, int[] arr) {

        Arrays.sort(arr);

        BitSet sol = new BitSet(value + 1);
        sol.set(0);

        for (int i = arr[0]; i < value + 1; i++) {

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > i) {
                    break;
                }

                if (sol.get(i - arr[j])) {
                    sol.set(i);
                    break;
                }
            }
        }

        return sol.get(value);
    }

    public static boolean isScorePossible(int[] points, int value) {
        int status[] = new int[value + 1];
        status[0] = 1;
        for (int i = 0; i < points.length; ++i) {
            for (int j = points[i]; j <= value; ++j) {
                status[j] += status[j - points[i]];
            }
        }

        return status[value] > 0;
    }

    static boolean isSubsetSum(int set[], int n, int sum) {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than sum, then ignore it
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);

       /* else, check if sum can be obtained by any of the following
          (a) including the last element
          (b) excluding the last element   */
        return isSubsetSum(set, n - 1, sum) ||
                isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    public static boolean isSumToZero(int numbers[]) {
        //   sum      index
        Map<Integer, Integer> sumToIndexMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (sum == 0) {
                System.out.println("!! Range found between 0 and " + i);
                return true;
            }
            if (!sumToIndexMap.containsKey(sum)) {
                sumToIndexMap.put(sum, i);
            } else {
                int index = sumToIndexMap.get(sum) + 1;
                System.out.println("Range found between " + index + " and " + i);
                return true;
            }
        }
        System.out.println("Range was not found");
        return false;
    }
}
