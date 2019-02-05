package com.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by levin on 4/24/17.
 */

public class CourseraInterviewQuestions {

    public static Integer romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L')
                res += 50;
            else if (s.charAt(i) == 'X') {
                if (i < s.length() - 1 && (s.charAt(i + 1) == 'L'))
                    res -= 10;
                else
                    res += 10;
            } else if (s.charAt(i) == 'V')
                res += 5;
            else if (s.charAt(i) == 'I') {
                if (i < s.length() - 1 && (s.charAt(i + 1) == 'X' || s.charAt(i + 1) == 'V'))
                    res--;
                else
                    res++;
            }
        }
        return res;
    }

    public static List<String> sortRoyalNames(List<String> nameList) {

        Collections.sort(nameList, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                String[] name1 = s.split(" ");
                String[] name2 = t1.split(" ");

                if (!name1[0].equals(name2[0])) {
                    return name1[0].compareTo(name2[0]);
                } else {
                    return romanToInt(name1[1]).compareTo(romanToInt(name2[1]));
                }
            }
        });
        return nameList;
    }

    public static void printCompositions(int n, int i, int MAX_POINT, int arr[]) {
        if (n == 0) {
            printArray(arr, i);
        } else if (n > 0) {
            for (int k = 1; k <= MAX_POINT; k++) {
                arr[i] = k;
                printCompositions(n - k, i + 1, MAX_POINT, arr);
            }
        }
    }

    public static void printArray(int arr[], int arr_size) {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(String.format("%d ", arr[i]));
        System.out.println();
    }

    public static int nthMagicNumber(int n) {
        int pow = 1, answer = 0;

        // Go through every bit of n
        while (n > 0) {
            pow = pow * 5;

            // If last bit of n is set
            if ((n & 1) > 0)
                answer += pow;

            // proceed to next bit
            n >>= 1;  // or n = n/2
        }
        return answer;
    }

    /**
     * Write a function to convert a dictionary into a string.
     * <p>
     * For example, assuming you are given a dictionary like:
     * dictionary(“a”: “apple”, “b”: dictionary(“b”: “blueberry”, “c”: “cranberry”)),
     * where the key field is always a string type, and the value field could be a string type
     * or a nested dictionary type.
     * And the output would be “{a:apple,b:{b:blueberry,c:cranberry}}”.
     * <p>
     * input  Map<String, Object>
     * <p>
     * output String
     */
    public static String convertDictionary(Map<String, Object> dict) {
        return convertDictionaryHelper(dict).toString();
    }

    public static StringBuilder convertDictionaryHelper(Map<String, Object> dict) {

        StringBuilder currentDictString = new StringBuilder();
        currentDictString.append('{');

        for (String key : dict.keySet()) {
            Object value = dict.get(key);
            if (value instanceof String) {
                currentDictString.append(key + ":" + value + ",");
            } else if (value instanceof Map) {
                StringBuilder dictToString = convertDictionaryHelper((Map) value);
                currentDictString.append(key + ":" + dictToString + ",");
            }
        }

        if (currentDictString.charAt(currentDictString.length() - 1) == ',') {
            currentDictString.deleteCharAt(currentDictString.length() - 1);
        }

        currentDictString.append('}');

        return currentDictString;
    }
}
