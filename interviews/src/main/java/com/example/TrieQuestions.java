package com.example;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by levin on 3/14/17.
 */

public class TrieQuestions {

    public static class TrieNode {
        char value;
        HashMap<Character, TrieNode> children;
        boolean wordEnd;

        public TrieNode(char value, boolean isWordEnd) {
            children = new HashMap<>();
            this.value = value;
            this.wordEnd = isWordEnd;
        }
    }

    public static TrieNode buildTrie(String[] dictionary) {
        TrieNode rootNode = new TrieNode(' ', false);
        for (String string : dictionary) {
            TrieNode currentNode = rootNode;
            TrieNode nextNode;
            int index = 0;
            int length = string.length();
            while (index < length) {
                char currentChar = string.charAt(index);
                if (!currentNode.children.containsKey(currentChar)) {
                    currentNode.children.put(currentChar,
                            new TrieNode(currentChar, index == length - 1 ? true : false));
                }

                currentNode = currentNode.children.get(currentChar);
                index++;
            }
        }

        return rootNode;
    }


}
