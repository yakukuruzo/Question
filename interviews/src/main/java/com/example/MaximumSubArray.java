package com.example;

/**
 * Created by levin on 3/27/17.
 */

public class MaximumSubArray {

    public static void kadanesAlgorythm(int[] a) {

        if (a == null || a.length == 0) {
            System.out.println("Array is empty");
            return;
        }

        if (a.length == 1) {
            System.out.println("Maximum sub-array sum is " + a[0]);
            return;
        }

        int max_current = a[0];
        int max_global = a[0];

        //int start_index = 0;
        //int end_index = 0;

        //boolean flag = false;

        for (int i = 1; i < a.length; i++) {

            max_current = Math.max(max_current + a[i], a[i]);

           /* if (max_global < a[i]) { // TODO: this is not correct
                flag = true;
            }*/

            if (max_current > max_global) {
                max_global = max_current;
                /*if (flag) {
                    start_index = i;
                }
                end_index = i;*/
            }

            //flag = false;
        }

        System.out.println("Maximum sub-array sum is " + max_global /*+ ", index range is [" + start_index + ", " + end_index + "]"*/);

    }
}
