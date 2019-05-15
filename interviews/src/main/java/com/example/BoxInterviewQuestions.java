package com.example;

/**
 * Created by levin on 4/16/17.
 */

public class BoxInterviewQuestions {

    /*
    Elevator problem

        To consider:
        0. Get all requirements for elevators first. Figure out whether there are more popular floors,
           like coffeteria or first floor. What is capacity of elevator?
        1. Strategy of distribution elevators among floors.
           If people are evenly distributed then makes sense to distribute elevators evenly.
        2. In the morning it makes sense to put more elevators on the first floor
        3. We can have 2 queues, one for requests up and another for requests down. And elevators
           can get tasks out of these queues based on their load.
        4. If asked for optimal solution. Ask what does OPTIMAL mean?
        5. People distribution strategy:
           First serves up to 25th floor - Odd Numbers, Second - serves up to 25th floor- Even Numbers
           3rd Lift- serves from(nonstop until) 26th floor to 50- Odd Numbers
           4th Lift- serves from (nonstop until) 26th floor to 50- Even Numbers
        6. If there is any statistics on which floors are more busy.
        7.
     */

    public static class myCode {

        public static class Scores
        {
            private static final int[] SAMPLE = new int[] {0, 6,8, 13, 7, 99, 87, 23, 1, 34, 33, 78};
            int pos = 0;

            public Scores(){

            }

            public int next(){
                return SAMPLE[pos++];
            }

            public boolean hasNext(){
                return (pos < SAMPLE.length);
            }
        }

        public static void main (String[] args) throws java.lang.Exception {
            Scores scores = new Scores();

            int[] top3 = getTopK(new Scores(), 3);
        }

    /*

    int[3] top3 = Integer.MIN_VALUE;

    0, 6, 8

    13 -> 6, 8, 13

    7 -> 8, 13, 7 delete 6

    99 -> 8, 13, 99  delte 7

    87 -> 13, 99, 87 delete 8

    1. Keep min and max value of the current subarray. Will need to find minimum value every time. O(N)

    2. Keep subarray sorted. O(N)

    3. MaxHeap of size K.  -> N*logK

    */

    // TODO: Check correctness
        public static int[] getTopK(Scores scores, int topK) {

            if (topK < 1 || scores == null) {
                throw new IllegalArgumentException();
            }

            MaxHeap maxHeap = new MaxHeap(topK);

            while(scores.hasNext()) {
                maxHeap.add(scores.next());
            }

            int[] result = new int[topK];

            int index = 0;
            while(!maxHeap.isEmpty()) {
                result[index] = maxHeap.getMax();
                index++;
            }

            return result;
        }

        public static class MaxHeap {

            //private int[] items;

            public MaxHeap(int capacity) {
            }

            public void add(int value) {

            }

            public int getMax() {
                return 0;
            }

            public int peek() {
                return 0;
            }

            public boolean isEmpty() {
                return true;
            }
        }
    }
}
