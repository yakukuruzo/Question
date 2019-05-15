package com.example;

import java.util.Date;

/**
 * Created by levin on 4/20/17.
 */

public class DropboxInterviewQuestions {

    public static class Node {
        public int counter;
        public Node next;

        public Node() {
            counter = 0;
        }
    }

    /*

    goal: implement a hit logger for a small, personal website (~hundreds of hits a day)
    interface:
        log_hit() # gets called every time the site gets a hit
        get_hits_5min() # returns the number of hits in the last 5 minutes

    */
// TODO: Check correctness of this implementation
    public static class HitLogger {

        private Node head;

        private long currTimeValue;
        private long prevTimeValue;

        private int mTotalHitsNumber;

        public HitLogger() {
            initializeCircleList();
            prevTimeValue = -1;
            mTotalHitsNumber = 0;
        }

        private void initializeCircleList() {

            head = new Node();
            Node currNode = head;

            for (int i = 0; i < 300 - 1; i++) {
                currNode.next = new Node();
                currNode = currNode.next;
            }

            currNode.next = head;
        }

        public void log_hit() {
            Date date = new Date();
            currTimeValue = date.getTime() / 1000;

            if (currTimeValue == prevTimeValue || prevTimeValue == -1) {
                head.counter++;
                mTotalHitsNumber++;
            } else {
                updateHeadPointer(currTimeValue - prevTimeValue);
                head.counter = 1;
                mTotalHitsNumber++;
            }
            prevTimeValue = currTimeValue;
        }

        private void updateHeadPointer(long diffInSeconds) {
            for (int i = 0; i < diffInSeconds; i++) {
                mTotalHitsNumber -= head.counter;
                head = head.next;
            }
        }

        public int get_hits_5min() {
            return mTotalHitsNumber;
        }
    }

    /*

    - make a bunch of hits over 300 seconds, and keep a counter - assert that the number of hits is as expected
    - make a hit at t=1s, t=2s, call get_hits at t=3s -> expect 2
    - make a hit at t=1s, t=2s, wait for 5 mins - > expect 0
    - make no hits, wait for 5 mins - > expect 0
    -


    - make a conccurent test
    -
    */
}
