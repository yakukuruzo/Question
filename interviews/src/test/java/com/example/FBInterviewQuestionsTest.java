package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static com.example.FBInterviewQuestions.*;

public class FBInterviewQuestionsTest {

    @Test
    public void testEvaluateString() {

        System.out.println("1+2+3 = " + evaluateString("1+2+3"));
        System.out.println("1*2+3 = " + evaluateString("1*2+3"));
        System.out.println("1*2*3 = " + evaluateString("1*2*3"));
        System.out.println("10*2*3+4+5*6 = " + evaluateString("10*2*3+4+5*6"));
    }

    @Test
    public void testRemoveBrackets() {
        System.out.println("(())()()( -> " + removeBrackets("(())()()("));
        System.out.println(")()(((()())() -> " + removeBrackets(")()(((()())()"));
        System.out.println("((((( -> " + removeBrackets("((((("));
        System.out.println("))))))) -> " + removeBrackets(")))))))"));
        System.out.println("( -> " + removeBrackets("("));
        System.out.println(") -> " + removeBrackets(")"));
    }

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

    @Test
    public void testRandomCity() {

        Map<String, Integer> cities = new HashMap<>();
        cities.put("NY", 600);
        cities.put("London", 300);
        cities.put("SF", 100);
        cities.put("SPb", 100);
        cities.put("Moscow", 500);
        cities.put("Singapore", 400);


        RandomCity randomCity = new RandomCity(cities);

        int numberOfNY = 0;
        int numberOfLondon = 0;
        int numberOfSF = 0;
        int numberOfSPb = 0;
        int numberOfMoscow = 0;
        int numberOfSingapore = 0;

        for (int i = 0; i < 10000; i++) {
            String city = randomCity.getRandomCity();
            if (city.equals("NY")) numberOfNY++;
            else if (city.equals("London")) numberOfLondon++;
            else if (city.equals("SF")) numberOfSF++;
            else if (city.equals("SPb")) numberOfSPb++;
            else if (city.equals("Moscow")) numberOfMoscow++;
            else if (city.equals("Singapore")) numberOfSingapore++;
        }

        System.out.println("NY = " + numberOfNY
                + ", London = " + numberOfLondon
                + ", SF = " + numberOfSF
                + ", SPb = " + numberOfSPb
                + ", Moscow = " + numberOfMoscow
                + ", Singapore = " + numberOfSingapore
        );

    }

    @Test
    public void testRandomDataStorage() {
        RandomDataStorage randomDataStorage = new RandomDataStorage();
        for (int  i = 0; i < 100; i++) {
            randomDataStorage.add(i + 1);
        }

        for (int  i = 1; i <= 100; i++) {
            System.out.print("" + randomDataStorage.getRandom() + " ");
            if (i% 10 == 0) {System.out.println();}
        }
    }

    @Test
    public void testGetArrayOfProducts() {
        System.out.println(Arrays.toString(getArrayOfProducts(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(getArrayOfProducts(new int[]{1, 0, 3})));
        System.out.println(Arrays.toString(getArrayOfProducts(new int[]{1, 0, 3, 0})));
        System.out.println(Arrays.toString(getArrayOfProducts(new int[]{3, 4, 3, 9, 8 ,6 , 10})));
    }
}