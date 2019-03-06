package com.example;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedianQuestion {


    public static class RunningMedian {

        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        public RunningMedian() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public float offer(int number) {
            maxHeap.offer(number);
            minHeap.offer(maxHeap.poll());

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }


            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }
            return (float)(minHeap.peek() + maxHeap.peek()) / 2f;
        }
    }

    public static class RunningMedianK {

        private final  PriorityQueue<Integer> minHeap;
        private final PriorityQueue<Integer> maxHeap;
        int[] slidingWindow;
        private final int K;
        int writeIndex;

        public RunningMedianK(int K) {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            this.K = K;
            slidingWindow = new int[K];
            writeIndex = 0;
        }

        public float offer(int number) {
            if (maxHeap.size() + minHeap.size() >= K) {
                int numberToRemove = slidingWindow[writeIndex % K];
                if (numberToRemove >= minHeap.peek()) {
                    minHeap.remove(numberToRemove);
                    minHeap.offer(maxHeap.poll());
                } else {
                    maxHeap.remove(numberToRemove);
                    if (minHeap.size() > maxHeap.size()) {
                        maxHeap.offer(minHeap.poll());
                    }
                }
            }

            writeIndex %= K;
            slidingWindow[writeIndex++] = number;

            maxHeap.offer(number);
            minHeap.offer(maxHeap.poll());

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }


            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }
            return (float)(minHeap.peek() + maxHeap.peek()) / 2f;
        }
    }


}
