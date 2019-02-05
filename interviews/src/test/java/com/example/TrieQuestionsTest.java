package com.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.example.TrieQuestions.*;

/**
 * Created by levin on 3/14/17.
 */
public class TrieQuestionsTest {
    @Test
    public void testBuildTrie() throws Exception {
        String[] dictionary = {"a", "aaa", "b", "bbb", "bb", "cat", "buldozer"};
        TrieQuestions.TrieNode root = buildTrie(dictionary);

    }


}