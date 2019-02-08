package com.example;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by levin on 5/9/17.
 */

public class WalmartInterviewQuestions {

    public static final int K = 10;

    public static Integer[] getKmax(int[] array) {

        if (array == null || array.length == 0) {
            return null;
        }


        PriorityQueue<Integer> kMaxQueue = new PriorityQueue<>();

        int i = 0;
        for (; i < K; i++) {
            kMaxQueue.add(array[i]);
        }

        for (; i < array.length; i++) {

            int currItem = array[i];

            if (currItem > kMaxQueue.peek()) {
                kMaxQueue.poll();
                kMaxQueue.add(currItem);
            }
        }

        return (Integer[]) kMaxQueue.toArray();
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }
}
