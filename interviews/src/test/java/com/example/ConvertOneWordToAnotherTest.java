package com.example;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by levin on 3/27/17.
 */
public class ConvertOneWordToAnotherTest {
    @Test
    public void convert() throws Exception {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("cat");
        dictionary.add("pat");
        dictionary.add("pit");
        dictionary.add("pid");
        dictionary.add("did");
        ConvertOneWordToAnother.convert("cat", "did", dictionary);
    }

}