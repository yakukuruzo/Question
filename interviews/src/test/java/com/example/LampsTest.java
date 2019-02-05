package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by levin on 4/20/17.
 */
public class LampsTest {
    @Test
    public void testQuery() throws Exception {

        int[][] lampsOn = new int[1][];
        lampsOn[0] = new int[] {2, 3};

        GoogleInterviewQuestions.Lamps lamps = new GoogleInterviewQuestions.Lamps(6, lampsOn);

        System.out.println("Trues");
        System.out.println(lamps.query(2, 3));
        System.out.println(lamps.query(0, 5));
        System.out.println(lamps.query(0, 1));
        System.out.println(lamps.query(2, 0));
        System.out.println(lamps.query(5, 0));

        System.out.println("Falses");
        System.out.println(lamps.query(4, 0));
        System.out.println(lamps.query(0, 0));
        System.out.println(lamps.query(1, 5));
    }

}