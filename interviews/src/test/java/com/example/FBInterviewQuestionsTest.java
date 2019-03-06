package com.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.example.FBInterviewQuestions.*;

public class FBInterviewQuestionsTest {

    @Test
    public void testIsValidNumber() {
        Assert.assertTrue(isValidNumber("-.0"));
        Assert.assertTrue(isValidNumber("123"));
        Assert.assertTrue(isValidNumber(".9"));
        Assert.assertTrue(isValidNumber("-123"));
        Assert.assertTrue(isValidNumber("-.123"));

        Assert.assertFalse(isValidNumber(""));
        Assert.assertFalse(isValidNumber(null));
        Assert.assertFalse(isValidNumber("."));
        Assert.assertFalse(isValidNumber("-."));
        Assert.assertFalse(isValidNumber("-.."));
        Assert.assertFalse(isValidNumber("123 343"));
        Assert.assertFalse(isValidNumber("3434_343"));
    }
}