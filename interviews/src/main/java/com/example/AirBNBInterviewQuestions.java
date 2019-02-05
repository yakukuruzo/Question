package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by levin on 4/13/17.
 */

public class AirBNBInterviewQuestions {

    public static ArrayList<String> findPalindromePairs(String[] input) {
        ArrayList<String> list = new ArrayList<>();

        if (null == input) {
            return list;
        }

        int len = input.length;
        if (len <= 1) {
            return list;
        }

        Map<String, Integer> map = new HashMap<>();

        int count;

        for (String str : input) {
            count = 0;
            if (map.containsKey(str)) {
                count = map.get(str);
            }

            map.put(str, ++count);
        }

        String rev;
        for (String str : input) {
            rev = new StringBuilder(str).reverse().toString();

            if (map.containsKey(rev)) {
                count = map.get(rev);

                if (count > 0) {
                    map.put(str, --count);
                    map.put(rev, --count);

                    list.add(str + " : " + rev);
                }
            }
        }

        return list;

    }

    public static int findLongestIsland(Character[] array) {

        int lastWaterIndex = -1;
        int newStart = -1;
        if (array[0] == 'W') {
            lastWaterIndex = 0;
            newStart = 0;
        }

        int[] dp = new int[array.length];
        dp[0] = 1;

        for (int i = 1; i < array.length; i++) {

            if (array[i] == 'W' && array[i - 1] == 'L') {
                newStart = lastWaterIndex + 1;
                lastWaterIndex = i;
                dp[i] = i - newStart + 1;
            } else if (array[i] == 'W' && array[i - 1] == 'W') {
                dp[i] = dp[i - 1] + 1;
                lastWaterIndex++;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int maxDp = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxDp) {
                maxDp = dp[i];
            }
        }

        return maxDp;
    }

    public static List<Character> findPossibleAlphabetOrdering(String[] words) {
        Graph<Character> followsGraph = new Graph<Character>();
        buildFollowsGraph(followsGraph, words);
        System.out.println("followsGraph: " + followsGraph);

        return followsGraph.topologicallySort();
    }

    private static void buildFollowsGraph(Graph<Character> followsGraph, String[] words) {
        String prev = words[0];
        insertVertices(followsGraph, prev);

        for (int i = 1; i < words.length; ++i) {
            insertVertices(followsGraph, words[i]);
            generateRelationship(followsGraph, prev, words[i]);
            prev = words[i];
        }
    }

    private static void insertVertices(Graph<Character> followsGraph, String word) {
        for (int i = 0; i < word.length(); ++i) {
            followsGraph.addVertex(word.charAt(i));
        }
    }

    private static void generateRelationship(Graph<Character> followsGraph, String prev, String curr) {
        int i = 0;
        int j = 0;
        while (i < prev.length() && j < curr.length() && prev.charAt(i) == curr.charAt(j)) {
            ++i;
            ++j;
        }

        if (i < prev.length() && j < curr.length()) {
            followsGraph.addEdge(curr.charAt(j), prev.charAt(i));
        }
    }

    static class Graph<V> {
        private Map<V, List<V>> edgeMap = new HashMap<>();

        public void addVertex(V v) {
            if (!edgeMap.containsKey(v)) {
                edgeMap.put(v, new LinkedList<V>());
            }
        }

        public void addEdge(V from, V to) {
            List<V> relations = edgeMap.get(from);
            relations.add(to);
        }

        public List<V> topologicallySort() {
            List<V> orderedVertices = new LinkedList<V>();

            Set<V> visited = new HashSet<>();
            Set<V> processed = new HashSet<>();
            Stack<V> dfsStack = new Stack<>();

            for (V startNode : edgeMap.keySet()) {
                if (visited.contains(startNode)) {
                    continue;
                }
                dfsStack.push(startNode);
                while (!dfsStack.isEmpty()) {
                    V top = dfsStack.peek();
                    if (!visited.contains(top)) {
                        visited.add(top);
                        for (V predecessor : edgeMap.get(top)) {
                            dfsStack.push(predecessor);
                        }
                    } else {
                        dfsStack.pop();
                        if (!processed.contains(top)) {
                            processed.add(top);
                            orderedVertices.add(top);
                        }
                    }
                }
            }

            return orderedVertices;
        }

        public String toString() {
            return edgeMap.toString();
        }
    }
}
