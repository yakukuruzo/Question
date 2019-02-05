package com.example;

import org.junit.Test;

import static com.example.PandoraInterviewQuestions.getCharFreqString;

/**
 * Created by levin on 4/25/17.
 */
public class PandoraInterviewQuestionsTest {

    @Test
    public void testGetCharFreqString() throws Exception {
        System.out.println(getCharFreqString("treeaaabbb"));
        System.out.println(getCharFreqString("AAABBBaabb223555555?????????"));
    }
}