package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.RunningMedianQuestion.RunningMedian;
import com.example.RunningMedianQuestion.RunningMedianK;

public class RunningMedianQuestionTest {

    @Test
    public void testRunningMedian() {
        RunningMedian runningMedian = new RunningMedian();
        System.out.println("4 - >"  + runningMedian.offer(4));
        System.out.println("5 - >"  + runningMedian.offer(5));
        System.out.println("3 - >"  + runningMedian.offer(3));
        System.out.println("8 - >"  + runningMedian.offer(8));
        System.out.println("9 - >"  + runningMedian.offer(9));
        System.out.println("11 - >"  + runningMedian.offer(11));
        System.out.println("3 - >"  + runningMedian.offer(3));
        System.out.println("2 - >"  + runningMedian.offer(2));
        System.out.println("2 - >"  + runningMedian.offer(2));
        System.out.println("32 - >"  + runningMedian.offer(32));
        System.out.println("14 - >"  + runningMedian.offer(14));
        System.out.println("10 - >"  + runningMedian.offer(10));
        System.out.println("5 - >"  + runningMedian.offer(5));
        System.out.println("1 - >"  + runningMedian.offer(1));
        System.out.println("7 - >"  + runningMedian.offer(7));
    }

    @Test
    public void testInALoop() {
        RunningMedian runningMedian = new RunningMedian();
        for (int i = 1 ; i <= 10; i ++) {
            System.out.println("" + i + " - >"  + runningMedian.offer(i));
        }
    }

    @Test
    public void testSameNumbers() {
        RunningMedian runningMedian = new RunningMedian();
        for (int i = 1 ; i <= 10; i ++) {
            System.out.println("" + i + " - >"  + runningMedian.offer(3));
        }
    }

    @Test
    public void testRunningMedianForK() {
        /**
         *      |-----|
         *      4 5 6 3 6 7 8 9 2 7 4 7 3 7 9 5 2 3 5 7
         *        |-----|
         */
        RunningMedianK runningMedian = new RunningMedianK(4);
        System.out.println("4 - >"  + runningMedian.offer(4));
        System.out.println("5 - >"  + runningMedian.offer(5));
        System.out.println("6 - >"  + runningMedian.offer(6));
        System.out.println("3 - >"  + runningMedian.offer(3));
        System.out.println("6 - >"  + runningMedian.offer(6));
        System.out.println("7 - >"  + runningMedian.offer(7));
        System.out.println("8 - >"  + runningMedian.offer(8));
        System.out.println("9 - >"  + runningMedian.offer(9));
        System.out.println("2 - >"  + runningMedian.offer(2));
        System.out.println("7 - >"  + runningMedian.offer(7));
        System.out.println("4 - >"  + runningMedian.offer(4));
        System.out.println("7 - >"  + runningMedian.offer(7));
        System.out.println("3 - >"  + runningMedian.offer(3));
        System.out.println("7 - >"  + runningMedian.offer(7));
        System.out.println("9 - >"  + runningMedian.offer(9));
        System.out.println("5 - >"  + runningMedian.offer(5));
        System.out.println("2 - >"  + runningMedian.offer(2));
        System.out.println("3 - >"  + runningMedian.offer(3));
        System.out.println("5 - >"  + runningMedian.offer(5));
        System.out.println("9 - >"  + runningMedian.offer(9));
    }
}