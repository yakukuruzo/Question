package com.example;

import org.junit.Assert;
import org.junit.Test;

import static com.example.RegexInterviewQuestion.*;

/**
 * Created by levin on 4/19/17.
 */
public class RegexInterviewQuestionTest {
    @Test
    public void testSearchRabinKarp() throws Exception {
        char[] txt = "GEEKS FOR GEEKS".toCharArray();
        char[] pat = "GEEK".toCharArray();
        int q = 101; // A prime number
        searchRabinKarp(pat, txt, q);
    }

    @Test
    public void testIsMatched() throws Exception {
        /*
            Output if a given pattern matches a string.
            Example:
            pattern:a*b
            string:aaab b, ab, aab, aaab, ab
            output:1

            pattern:a+aabc
            string:ab aabc, aaabc, aaaabc ..
            output:0

            pattern:aa*b*ab+
            string:aab aab, aabab, aaaabbab
            output:1

            pattern: a+a*b*
            string: a ab, aab, aaabb
            output: 1
         */
        Assert.assertTrue(isMatched("a*b", "aaab"));
        Assert.assertTrue(isMatched("a*b", "b"));
        Assert.assertTrue(isMatched("a*b", "ab"));
        Assert.assertTrue(isMatched("a*b", "aab"));

        Assert.assertFalse(isMatched("a+aabc", "ab"));
        Assert.assertFalse(isMatched("a+aabc", "aabc"));
        Assert.assertTrue(isMatched("a+aabc", "aaabc"));
        Assert.assertTrue(isMatched("a+aabc", "aaaabc"));

        System.out.println(isMatched("aa*b*ab+", "aab"));
        System.out.println(isMatched("aa*b*ab+", "aabab"));
        System.out.println(isMatched("aa*b*ab+", "aaaabbab"));

        System.out.println(isMatched("a+a*b*", "a"));
        System.out.println(isMatched("a+a*b*", "ab"));
        System.out.println(isMatched("a+a*b*", "aab"));
        System.out.println(isMatched("a+a*b*", "aaabb"));

    }

    @Test
    public void testPatternMatcher() throws Exception {
        String pat = "aba";
        String str = "rocktreerock";
        System.out.println(patternMatcher(pat, str));

        //1) Pattern : "abba", input: "redblueredblue" should return 1.
        // 2) Pattern: "aaaa", input: "asdasdasdasd" should return 1.
        // 3) Pattern: "aabb", input: "xyzabcxzyabc" should return 0.
        System.out.println();
        System.out.println(patternMatcher("abab", "redblueredblue"));
        System.out.println(patternMatcher("aaaa", "asdasdasdasd"));
        System.out.println(patternMatcher("aabb", "xyzabcxzyabc"));
        System.out.println(patternMatcher("abc", "redblueredblue"));

        System.out.println();
        System.out.println(patternMatcher("aba", "bluegreenblue"));// -> true
        System.out.println(patternMatcher("abc","bluegreenyellow"));// -> true
        System.out.println(patternMatcher("aba", "t1t2t1"));// -> true
        System.out.println(patternMatcher("aba", "t1t1t1"));// -> false
        System.out.println(patternMatcher("aba", "t1t11t1"));// -> true
        System.out.println(patternMatcher("abab", "t1t2t1t2"));// -> true
        System.out.println(patternMatcher("abcdefg", "ieqfkvu"));// -> true
        System.out.println(patternMatcher("abcdefg", "bluegreenredyellowpurplesilvergold"));// -> true
        System.out.println(patternMatcher("ababac", "bluegreenbluegreenbluewhite"));// -> true
        System.out.println(patternMatcher("abdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba"));// -> true
    }

    @Test
    public void testPatternMatcher2() throws Exception {
        String pat = "aba";
        String str = "rocktreerock";
        System.out.println(isMatch2(pat, str));

        //1) Pattern : "abba", input: "redblueredblue" should return 1.
        // 2) Pattern: "aaaa", input: "asdasdasdasd" should return 1.
        // 3) Pattern: "aabb", input: "xyzabcxzyabc" should return 0.
        System.out.println();
        System.out.println(isMatch2("abab", "redblueredblue"));
        System.out.println(isMatch2("aaaa", "asdasdasdasd"));
        System.out.println(isMatch2("aabb", "xyzabcxzyabc"));
        System.out.println(isMatch2("abc", "redblueredblue"));

        System.out.println();
        System.out.println(isMatch2("aba", "bluegreenblue"));// -> true
        System.out.println(isMatch2("abc","bluegreenyellow"));// -> true
        System.out.println(isMatch2("aba", "t1t2t1"));// -> true
        System.out.println(isMatch2("aba", "t1t1t1"));// -> false
        System.out.println(isMatch2("aba", "t1t11t1"));// -> true
        System.out.println(isMatch2("abab", "t1t2t1t2"));// -> true
        System.out.println(isMatch2("abcdefg", "ieqfkvu"));// -> true
        System.out.println(isMatch2("abcdefg", "bluegreenredyellowpurplesilvergold"));// -> true
        System.out.println(isMatch2("ababac", "bluegreenbluegreenbluewhite"));// -> true
        System.out.println(isMatch2("abdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba"));// -> true
    }
}