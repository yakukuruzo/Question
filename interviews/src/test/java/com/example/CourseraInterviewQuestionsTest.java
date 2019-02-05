package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.example.CourseraInterviewQuestions.*;

/**
 * Created by levin on 4/24/17.
 */
public class CourseraInterviewQuestionsTest {
    @Test
    public void testConvertDictionary() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("a", "apple");

        Map<String, Object> subMap = new HashMap<>();
        subMap.put("c", "orange");
        subMap.put("d", "cranberry");
        map.put("b", subMap);

        System.out.println(convertDictionary(map));
    }

    @Test
    public void testNthMagicNumber() throws Exception {
        System.out.println(nthMagicNumber(1));
        System.out.println(nthMagicNumber(2));
        System.out.println(nthMagicNumber(3));
        System.out.println(nthMagicNumber(4));
        System.out.println(nthMagicNumber(5));
    }

    @Test
    public void testPrintCompositions() throws Exception {
        printCompositions(5, 0, 5, new int[5+1]);
    }

    @Test
    public void testSortRoyalNames() throws Exception {
        String[] names = new String[]{"Richard V", "Henry VI", "Edward II", "Richard XXV", "Richard IX", "Henry IX", "Edward LII"};
        sortRoyalNames(Arrays.asList(names)).stream().forEach(System.out::println);
    }

}