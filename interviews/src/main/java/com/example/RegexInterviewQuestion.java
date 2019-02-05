package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by levin on 4/19/17.
 */

public class RegexInterviewQuestion {

    public static boolean patternMatcher(String pattern, String str) {
        return patternMatcher(pattern, str, new HashMap<>());
    }

    public static boolean patternMatcher(String pattern, String str, Map<Character, String> table) {
        // Check for base cases
        if (pattern.length() == 0 && str.length() == 0) {
            return true;
        } else if (pattern.length() > str.length() || pattern.length() == 0) {
            return false;
        }

        // Check if the first char in pattern exists as a key in the hash table
        String val = table.get(pattern.charAt(0));
        if (val != null) {
            // If it does exist, check if it matches with the beginning of str
            if (val.equals(str.substring(0, Math.min(val.length(), str.length())))) {
                // If it's a match, check the rest of the pattern / string
                return patternMatcher(pattern.substring(1), str.substring(val.length()), table);
            }
        } else {
            // Go through every possible value for the first char in pattern
            for (int i = 1; i <= str.length() - pattern.length() + 1; i++) {
                // Values should be unique so only use it if it's not already in the hash table
                if (!table.containsKey(str.substring(0, i))) {
                    table.put(pattern.charAt(0), str.substring(0, i));

                    // Move on to the rest of the problem to see if this key-value pairing works
                    if (patternMatcher(pattern.substring(1), str.substring(i), table)) {
                        return true;
                    } else {
                        // If the key-value pairing doesn't work, remove it from the hash table
                        table.remove(pattern.charAt(0));
                    }
                }
            }
        }
        return false;
    }

    public static boolean isMatched(String regex, String str) {
        if (str.length() == 0) {
            // Match is true when regex is exhausted or it's last char is "*" - allowing optional str
            return regex.length() == 0 || regex.charAt(regex.length() - 1) == '*';
        }

        if (regex.length() == 0) {
            // Match is true only if str is fully consumed
            return str.length() == 0;
        }

        Character curReg = regex.charAt(0);
        Character nextReg = regex.length() >= 2 ? regex.charAt(1) : null;
        Character curStr = str.length() != 0 ? str.charAt(0) : null;

        if (nextReg == null || (nextReg != '*' && nextReg != '+')) {
            // This is a simple match - just take the first char from both regex and str and recurse IFF current match is detected
            return isCharMatched(curReg, curStr) && isMatched(regex.substring(1), str.substring(1));
        } else {
            if (nextReg == '*') {
                // The current regex char is followed by "*" - create 2 branches:
                // - one with unmodified regex and reduced str IFF current match detected - meaning to continue repetition if possible
                // - the other one with reduced regex and unmodified str - meaning to try out the optional nature of "*"
                return (isCharMatched(curReg, curStr) && isMatched(regex, str.substring(1)))
                        || isMatched(regex.substring(2), str);
            } else if (nextReg == '+') {
                // The current regex char is followed by "+" - reduce to 1 branch with "*" instead of "+"
                return isCharMatched(curReg, curStr) && isMatched(curReg + "*" + regex.substring(2), str.substring(1));
            } else {
                return false;
            }
        }
    }

    public static boolean isCharMatched(Character regexCh, Character strCh) {
        return regexCh == strCh || (regexCh == '.' && strCh >= 'a' && strCh <= 'z');
    }

    public static boolean isMatch2(String str, String pat) {
        Map<Character, String> map = new HashMap<>();
        return isMatch2(str, 0, pat, 0, map);
    }

    // Looks like does not work
    public static boolean isMatch2(String str, int i, String pat, int j, Map<Character, String> map) {
        // base case
        if (i == str.length() && j == pat.length()) return true;
        if (i == str.length() || j == pat.length()) return false;

        // get current pattern character
        char c = pat.charAt(j);

        // if the pattern character exists
        if (map.containsKey(c)) {
            String s = map.get(c);

            // then check if we can use it to match str[i...i+s.length()]
            if (i + s.length() > str.length() || !str.substring(i, i + s.length()).equals(s)) {
                return false;
            }

            // if it can match, great, continue to match the rest
            return isMatch2(str, i + s.length(), pat, j + 1, map);
        }

        // pattern character does not exist in the map
        for (int k = i; k < str.length(); k++) {
            // create or update the map
            map.put(c, str.substring(i, k + 1));

            // continue to match the rest
            if (isMatch2(str, k + 1, pat, j + 1, map)) {
                return true;
            }
        }

        // we've tried our best but still no luck
        map.remove(c);

        return false;
    }

    public static void searchRabinKarp(char pat[], char txt[], int q) {
        int d = 256;
        int M = pat.length;
        int N = txt.length;
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat[i]) % q;
            t = (d * t + txt[i]) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if (p == t) {
            /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt[i + j] != pat[j])
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }

            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - txt[i] * h) + txt[i + M]) % q;

                // We might get negative value of t, converting it
                // to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }
}
