package com.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by levin on 4/25/17.
 */

public class PandoraInterviewQuestions {

    /*
/*******************************************************************************
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once*/

// go through each char and store its freq -> array or hashmap . -> O(N)
// go through an array and find maximum -> O(K*K) K = 52

    public static String getCharFreqString(String input) {

        if (input == null || input.isEmpty()) {
            return "";
        }

        Map<Character, Integer> charToFreqMap = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);

            Integer counter;
            if (charToFreqMap.containsKey(currChar)) {
                counter = charToFreqMap.get(currChar);
            } else {
                counter = new Integer(0);
            }
            charToFreqMap.put(currChar, ++counter);
        }

        StringBuilder sb = new StringBuilder();

        while (!charToFreqMap.isEmpty()) {
            int maxValue = 0;
            Character maxKey = 0;
            for (Character key : charToFreqMap.keySet()) {
                Integer counter = charToFreqMap.get(key);
                if (counter > maxValue) {
                    maxValue = counter;
                    maxKey = key;
                }
            }

            if (maxKey != 0) {
                for (int j = 0; j < maxValue; j++) {
                    sb.append(maxKey);
                }
            }


            charToFreqMap.remove(maxKey);
        }

        return sb.toString();

    }


    public static char[] rearrangeTasks(char[] tasks) {
        int n = tasks.length;

        // step 1. go through the tasks and count the frequency
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char task = tasks[i];
            map.put(task, map.containsKey(task) ? map.get(task) + 1 : 1);
        }

        // step 2. use a max heap to sort the tasks by frequency
        PriorityQueue<Task> heap = new PriorityQueue(new Comparator<Task>() {
            public int compare(Task a, Task b) {
                return b.frequency - a.frequency;
            }
        });

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            heap.offer(new Task(entry.getKey(), entry.getValue()));
        }

        // step 3. organize the tasks and put them apart by d distance
        // d is the highest frequency
        int d = heap.peek().frequency;
        // let's reset the tasks
        tasks = new char[n];
        // the next empty slot
        int i = 0;

        while (!heap.isEmpty()) {
            Task task = heap.poll();

            // locate the next empty slot
            while (i < n && tasks[i] != '\0') i++;

            for (int j = i; j < n && task.frequency > 0; j += d) {
                tasks[j] = task.id;
                task.frequency--;
            }

            if (task.frequency > 0) {
                // this task is not done yet, put it back
                heap.offer(task);
            }
        }

        // finally return the rearranged tasks
        return tasks;
    }



    // helper class
    public static class Task {
        char id;
        int frequency;

        Task(char i, int f) {
            id = i;
            frequency = f;
        }
    }

}
