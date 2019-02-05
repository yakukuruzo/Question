package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static com.example.JavaInterviewQuestions.*;

/**
 * Created by levin on 5/3/17.
 */
public class JavaInterviewQuestionsTest {

    @Test
    public void testStaticMethodHiding() throws Exception {
        List<A> list = new ArrayList<>();
        list.add(new A());
        list.add(new B());
        list.add(new B());
        list.add(new A());


    }
}