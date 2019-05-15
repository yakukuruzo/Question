package com.example;

import org.junit.Test;

import static com.example.PayPalInterviewQuestions.spiralPrint;

public class PayPalInterviewQuestionsTest {

    @Test
    public void testSpiralPrint() {
        int R = 3;
        int C = 6;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        spiralPrint(R,C,a);
    }
}