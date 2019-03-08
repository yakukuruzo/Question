package com.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class FBInterviewQuestions {

    public static int evaluateString(String text) {
        String[] parts = text.split("\\+");

        int result = 0;

        for (String part : parts) {
            if (part.contains("*")) {
                String[] productParts = part.split("\\*");

                int productResult = 1;
                for (String productPart : productParts) {
                    productResult *= Integer.decode(productPart);
                }
                result += productResult;
            } else {
                result += Integer.decode(part);
            }
        }

        return result;
    }

    public static String removeBrackets(String input) {

        int openBracketCounter = 0;
        StringBuilder sb = new StringBuilder();
         for (char ch : input.toCharArray()) {
             if (ch == '(') {
                 openBracketCounter++;
                 sb.append(ch);
             } else {
                 if (openBracketCounter > 0) {
                     openBracketCounter--;
                     sb.append(ch);
                 }
             }
         }

         if (sb.length() <= 1) { return ""; }

         return sb.toString();
    }

    public static boolean isValidNumber(String number) {

        if (number == null || number.isEmpty()) {
            return false;
        }

        char[] arr = number.toCharArray();

        boolean wasDotFound = false;
        boolean wasDigitFound = false;

        for (int i = 0; i < arr.length; i++) {
            char curr = arr[i];

            // Check '-' in the very beginning
            if (curr == '-' && i == 0) {
                continue;
            }

            // Check '.'
            if (curr == '.') {
                if (!wasDotFound) {
                    wasDotFound = true;
                    continue;
                } else {
                    // this is the second dot in the string
                    return false;
                }
            }

            if ((curr - '0') < 0 || (curr - '0') > 9) {
                return false;
            }

            wasDigitFound = true;
        }

        return wasDigitFound;
    }

    public static class RandomCity {

        private final String[] mCities;
        private final int[] mRunningPopulationSum;

        private Random mRandom;
        private int mTotalPopulation;


        public RandomCity(Map<String, Integer> citiesToPopulationMap) {
            mCities = new String[citiesToPopulationMap.size()];
            mRunningPopulationSum = new int[citiesToPopulationMap.size()];

            mRandom = new Random();

            int index = 0;
            mTotalPopulation = 0;
            for (Map.Entry<String, Integer> entry : citiesToPopulationMap.entrySet()) {
                mCities[index] = entry.getKey();
                mRunningPopulationSum[index] = mTotalPopulation + entry.getValue();
                mTotalPopulation += entry.getValue();
                index++;
            }
        }

        public String getRandomCity() {
            int random = mRandom.nextInt(mTotalPopulation);
            return mCities[findIntervalPosition(random, mRunningPopulationSum)];
        }

        public int findIntervalPosition(int val, int[] arr) {
            int start = 0;
            int end = arr.length - 1;

            while (start < end) {
                int medium = (start + end) / 2;

                if (val > arr[medium]) {
                    start = medium + 1;
                    continue;
                }

                if (medium >= 1) {
                    if (val < arr[medium] && val > arr[medium - 1]) {
                        return medium;
                    }
                    end = medium - 1;
                    continue;
                } else {
                    return 0;
                }
            }

            return start;
        }
    }

    public static class RandomDataStorage {

        private ArrayList<Integer> mStorage;
        private Random mRandom;

        public RandomDataStorage() {
            mStorage = new ArrayList<>();
            mRandom = new Random();
        }

        public void add(int value) {
            mStorage.add(value);
        }

        public int getRandom() {
            int index = mRandom.nextInt(mStorage.size());
            int temp = mStorage.get(index);
            mStorage.set(index, mStorage.get(mStorage.size() - 1));
            mStorage.remove(mStorage.size() - 1);
            return temp;
        }
    }


    public static long[] getArrayOfProducts(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int zeroCounter = 0;
        int zeroPosition = -1;
        long totalProduct = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (zeroCounter == 0) {
                    zeroCounter++;
                    zeroPosition = i;
                    continue;
                } else {
                    return new long[arr.length];
                }
            }
            totalProduct *= arr[i];
        }

        long[] result = new long[arr.length];
        if (zeroCounter == 1) {

            result[zeroPosition] = totalProduct;
            return result;
        }

        for (int i = 0; i < arr.length; i++) {
            result[i] = totalProduct / arr[i];
        }

        return result;
    }
}