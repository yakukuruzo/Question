package com.example;

/**
 * Created by levin on 5/3/17.
 */

public class JavaInterviewQuestions {


    public static class A {

        public static void methodA() {
            System.out.println("methodA() in class A");
        }

        public final void methodFinal(int a, int b) {

        }
    }

    public static class B extends A {

        public static void methodA() {
            System.out.println("methodA() in class B");
        }



    }


}
