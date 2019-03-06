package com.example;

public class FBInterviewQuestions {


    public static boolean isValidNumber(String number) {

        if (number == null || number.isEmpty()) {
            return false;
        }

        char[] arr = number.toCharArray();

        boolean wasDotFound = false;
        boolean wasDigitFound = false;

        for (int i = 0; i < arr.length; i++) {
            char curr = arr[i];

            // Check '-' in the very beginning
            if (curr == '-' && i == 0) {
                continue;
            }

            // Check '.'
            if (curr == '.') {
                if (!wasDotFound) {
                    wasDotFound = true;
                    continue;
                } else {
                    // this is the second dot in the string
                    return false;
                }
            }

            if ((curr - '0') < 0 || (curr - '0') > 9) {
                return false;
            }

            wasDigitFound = true;
        }

        return wasDigitFound;
    }
}