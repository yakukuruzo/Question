package com.example;

public class PatternMatchingQuestion {

    // a-z: direct matching
    // .: anything
    // *: wildcard

    // Pattern examples: a*b, c*a*b, aa*b

    private static boolean isChar(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public static boolean match(String string, String pattern) {
        // We are out of characters to match
        if (string.isEmpty() && pattern.isEmpty()) {
            return true;
        } else if (!string.isEmpty() && pattern.isEmpty()) {
            return false;
        } else if (string.isEmpty() && !pattern.isEmpty()) {
            return false;
        }

        int i = 0, currPatternIndex = 0;
        for (; i < string.length() && currPatternIndex < pattern.length(); i++, currPatternIndex++) {

            // Wildcard case
            if (isChar(pattern.charAt(currPatternIndex))
                    && pattern.length() > currPatternIndex + 1
                    && pattern.charAt(currPatternIndex + 1) == '*') {

                boolean result = match(string, pattern.substring(2));
                if (!result && string.charAt(i) == pattern.charAt(currPatternIndex)) {
                    result = match(string.substring(i + 1), pattern.substring(currPatternIndex));
                }

                return result;
            }
            // Direct match
            else if (isChar(pattern.charAt(currPatternIndex))) {
                if (string.charAt(i) != pattern.charAt(currPatternIndex)) {
                    return false;
                }
                continue;
            } else if (pattern.charAt(currPatternIndex) == '.') {
                // Anything
                continue; // ?? do we need to check string length left
            } /*else if (pattern.charAt(currPatternIndex) == '*') {
                // Check a patten where * means none
                boolean result = match(string.substring(i), pattern.substring(currPatternIndex + 1));
                if (!result) {
                    // Check a patern where * means many
                    result = match(string.substring(i), pattern.substring(currPatternIndex - 1));
                }
                return result;
            }*/
        }
        if (i < string.length() && currPatternIndex == pattern.length()) {
            return false;
        } else if (i == string.length() && currPatternIndex < pattern.length()) {
            return false;
        }

        return true;
    }

}
