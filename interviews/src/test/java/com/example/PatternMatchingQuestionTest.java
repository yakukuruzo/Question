package com.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.example.PatternMatchingQuestion.*;

public class PatternMatchingQuestionTest {

    @Test
    public void matchTest() {

        /**
            v      v
         1. aaab   c*a*b  -> a*b, c*a*b (on a shortened string)

               v       v
         2.a.  aaab    a*b -> b , a*b (on a shortened string)

                  v      v
            3.a.  aaab   b -> false

            3.b. aab  a*b

                4.a aab b -> false
                4.b. ab a*b

                    5.a. ab  b ->false
                    5.b. b  a*b -> b, a*b

                        6.a. b   b -> true
                        6.b. _  a*b -> false


               v       v
         2.b.  aaab    c*a*b

            3.a

         2.c.  aaab    c*a*b




          */

        Assert.assertTrue(match("aaab", "c*a*b"));
        Assert.assertTrue(match("cccaaab", "c*a*b"));
        Assert.assertTrue(match("b", "c*a*b"));
        Assert.assertTrue(match("ccccb", "c*a*b"));

        Assert.assertFalse(match("aaacccc", "c*a*b"));


        Assert.assertFalse(match("aaab", "c.a*b"));
        Assert.assertTrue(match("caaab", "c.a*b"));

        Assert.assertFalse(match("caaab", "..."));
        Assert.assertTrue(match("xyz", "..."));

        Assert.assertTrue(match("aaabxyz", "c*a*b..."));
        Assert.assertFalse(match("aaabxyz", "c*a*b...."));
    }
}