package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by levin on 3/10/17.
 */

public class StringsQuestion {

    // Polindromes
    public static void isPalindrome(String stringToCheck) {
        char[] array = stringToCheck.toLowerCase().replaceAll("[^a-zA-Z]", "").toCharArray();

        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            if (array[i] != array[j]) {
                System.out.println(stringToCheck + " is not a palindrome");
                return;
            }
        }

        System.out.println(stringToCheck + " is a palindrome");
    }

    static public String intermediatePalindrome(String s, int left, int right) {
        if (left > right) return null;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static String longestPalindromeString(String s) {
        if (s == null) return null;
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            //odd cases like 121
            String palindrome = intermediatePalindrome(s, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
            //even cases like 1221
            palindrome = intermediatePalindrome(s, i, i + 1);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        System.out.println(longest);
        return longest;
    }


    // Permutations and Combinations
    public static void stringPermutations(String perm, String word) {
        if (word.isEmpty()) {
            System.out.println(perm);
        } else {
            for (int i = 0; i < word.length(); i++) {
                stringPermutations(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }

    /**
     * Write code to generate all possible case combinations of a given lower-cased string. (e.g.
     * "0ab" -> ["0ab", "0aB", "0Ab", "0AB"])
     */
    public static void stringCaseCombinations(String prefix, String string) {
        if (string.isEmpty()) {
            System.out.print(prefix + " ");
            return;
        }

        if (Character.isAlphabetic(string.charAt(0))) {
            stringCaseCombinations(prefix + string.substring(0, 1).toLowerCase(), string.substring(1));
            stringCaseCombinations(prefix + string.substring(0, 1).toUpperCase(), string.substring(1));
        } else {
            stringCaseCombinations(prefix + string.substring(0, 1), string.substring(1));
        }
    }

    public static void generateAllSubsetsOfString(char[] set) {  // O( 2^n )
        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");

            System.out.println("}");
        }
    }


    // String compression
    public static String compressString(String a) {
        if (a.length() < 2) {
            return a;
        }
        if (a.length() == 2) {
            if (a.charAt(0) == a.charAt(1)) {
                return a.charAt(0) + "2";
            } else {
                return a;
            }
        }
        for (int i = 0; i < a.length(); i++) {
            int c = i + 1;
            while (c < a.length() && a.charAt(c) == a.charAt(i)) {
                c++;
            }
            if (c - i != 1) {
                a = a.substring(0, i + 1) + (c - i) + a.substring(c);
                i++;
            }

        }
        return a;
    }

    public static String compressStringBuilder(String input) {
        StringBuilder result = new StringBuilder();
        char currentCharacter;
        int count;

        for (int i = 0; i < input.length(); i++) {
            currentCharacter = input.charAt(i);
            count = 1;
            while (i < input.length() - 1 && input.charAt(i + 1) == currentCharacter) {
                count++;
                i++;
            }

            result.append(currentCharacter);
            if (count > 1)
                result.append(count);
        }

        return result.toString();
    }



    // Substrings
    public static int longestStringWithUniqueChars(String input) {
        int max = 0;
        int count = 0;
        int a[] = new int[26];
        Arrays.fill(a, -1);

        for (int i = 0; i < input.length(); ++i) {
            if (a[input.charAt(i) - 'a'] >= 0) {
                int from = a[input.charAt(i) - 'a'];
                count = i - a[input.charAt(i) - 'a'];
                // Clear array is necessary
                a = new int[26];
                Arrays.fill(a, -1);

                for (int j = from + 1; j <= i; ++j)
                    a[input.charAt(j) - 'a'] = j;
            } else {
                count++;
                a[input.charAt(i) - 'a'] = i;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    public static void longestSubstring(String inputString) {
        // Convert inputString to charArray
        char[] charArray = inputString.toCharArray();

        // Initialization
        String longestSubstring = null;
        int longestSubstringLength = 0;

        // Creating LinkedHashMap with characters as keys and their position as values.
        Map<Character, Integer> charPosMap = new LinkedHashMap<>();

        // Iterating through charArray
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];

            // If ch is not present in charPosMap, adding ch into charPosMap along with its position
            if (!charPosMap.containsKey(ch)) {
                charPosMap.put(ch, i);
            }
            // If ch is already present in charPosMap, reposioning the cursor i
            // to the position of ch and clearing the charPosMap
            else {
                i = charPosMap.get(ch);
                charPosMap.clear();
            }

            // Updating longestSubstring and longestSubstringLength
            if (charPosMap.size() > longestSubstringLength) {
                longestSubstringLength = charPosMap.size();
                // we need to have a LinkedHashMap here as it will keep the the order of insertion
                longestSubstring = charPosMap.keySet().toString();
            }
        }

        System.out.println("Input String : " + inputString);
        System.out.println("The longest substring : " + longestSubstring);
        System.out.println("The longest Substring Length : " + longestSubstringLength);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int start = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                max = Math.max(max, set.size());

                while (start < i && s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }

            i++;
        }

        max = Math.max(max, set.size());

        System.out.println(max);
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character

        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        System.out.println(ans);
        return ans;
    }

}
