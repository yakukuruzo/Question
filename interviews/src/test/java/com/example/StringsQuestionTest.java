package com.example;

import org.junit.Test;

import static com.example.StringsQuestion.isPalindrome;
import static org.junit.Assert.*;
import static com.example.StringsQuestion.*;

/**
 * Created by levin on 3/10/17.
 */
public class StringsQuestionTest {
    @Test
    public void testLengthOfLongestSubstring() throws Exception {
        lengthOfLongestSubstring("abracadabra");
        lengthOfLongestSubstring2("abracadabra");
        lengthOfLongestSubstring3("abracadabra");
        lengthOfLongestSubstring("synchrophasotron");
        lengthOfLongestSubstring2("synchrophasotron");
        lengthOfLongestSubstring3("synchrophasotron");
        lengthOfLongestSubstring("thebiggestbuildingintheworld");
        lengthOfLongestSubstring2("thebiggestbuildingintheworld");
        lengthOfLongestSubstring3("thebiggestbuildingintheworld");
        lengthOfLongestSubstring("ababcdefahijklab");
        lengthOfLongestSubstring2("ababcdefahijklab");
        lengthOfLongestSubstring3("ababcdefahijklab");
        lengthOfLongestSubstring("abadef");
        lengthOfLongestSubstring2("abadef");
        lengthOfLongestSubstring3("abadef");
    }

    @Test
    public void testLongestSubstring() throws Exception {
        longestSubstring("abracadabra");
        longestSubstring("synchrophasotron");
        longestSubstring("thebiggestbuildingintheworld");
        longestSubstring("ababcdefahijklab");
        longestSubstring("abadef");
    }

    @Test
    public void testCompressStringBuilder() throws Exception {
        System.out.println(compressStringBuilder("aaabbbcc"));
        System.out.println(compressStringBuilder("abcabcaaaaaaaaaaaaabc"));
    }

    @Test
    public void testCompressString() throws Exception {
        System.out.println(compressString("aaabbbcc"));
        System.out.println(compressString("abcabcaaaaaaaaaaaaabc"));
    }

    @Test
    public void testGenerateAllSubsetsOfString() throws Exception {
        char set[] = {'a', 'b', 'c', 'd', '@', '#', '%'};
        generateAllSubsetsOfString(set);
    }

    @Test
    public void testStringCaseCombinations() throws Exception {
        stringCaseCombinations("", "0ab");
    }

    @Test
    public void testStringPermutations() throws Exception {
        stringPermutations("", "1234");
    }

    @Test
    public void testLongestPalindromeString() throws Exception {
        longestPalindromeString("1234");
        longestPalindromeString("12321");
        longestPalindromeString("9912321456");
        longestPalindromeString("9912333321456");
        longestPalindromeString("12145445499");
        longestPalindromeString("1223213");
        longestPalindromeString("abb");
    }

    @Test
    public void testIsPalindrome() throws Exception {
        isPalindrome("abrtywuwytrba");
        isPalindrome("abrtywwytrba");
        isPalindrome("dfsdgsdfvsdfvsdfvdfv");
        isPalindrome("Racecar");

        isPalindrome("kayak");
        isPalindrome("Rats live on no evil star");
        isPalindrome("A man, a plan, a canal, Panama");
        isPalindrome("Doc, note: I dissent. A fast never prevents a fatness. I diet on cod.");
    }
}