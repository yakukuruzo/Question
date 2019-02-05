package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by levin on 3/28/17.
 */
public class BoggleTest {
    @Test
    public void testFindWords() throws Exception {
        char[][] board = {{'o','a','a','n', 'i'},
                          {'e','t','a','e', 'l'},
                          {'i','h','k','r', 'y'},
                          {'i','f','l','v', 'a'}};
        String[] words = {/*"oath","pea","eat","rain",*/ "ilya"};
        Boggle boggle = new Boggle();
        List<String> result = boggle.findWords(board, words);
        result.stream().forEach(s -> System.out.println(s));
    }

}