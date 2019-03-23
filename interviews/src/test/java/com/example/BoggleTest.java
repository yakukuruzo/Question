package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by levin on 3/28/17.
 */
public class BoggleTest {
    @Test
    public void testFindWords() {
        char[][] board = {{'o','a','i','z', 'i'},
                          {'u','t','r','a', 'l'},
                          {'a','h','o','t', 'y'},
                          {'a','n','o','i', 'a'}};
        String[] words = {"oath","pea","eat","rain", "ilya", "author", "authorization"};
        Boggle boggle = new Boggle();
        List<String> result = boggle.findWords(board, words);
        result.stream().forEach(s -> System.out.println(s));
    }

}