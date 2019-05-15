package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class UberInterview2019Questions {


    // 27.03.2019
    // 1. Battle field game design.
    // 2. Water tank task.
    // 3. Given 2 lists, return 3 lists with unique elements for the first list, unique elements for the second and intersection of both lists.
    // 4. Weather app. Sort cities by country, show sorted list of cities, when click a city show another screen with the temperature.
    // Dagger, RxJava, refactoring


    // Flattening iterator
    public static class FlatteningIterator<T> implements Iterator<T> {

        private final List<Iterator<T>> mIteratorList = new ArrayList<>();
        private Iterator<Iterator<T>> mIterator;
        private Iterator<T> mCurrentIterator;

        public FlatteningIterator(List<List<T>> listOfLists) {
            if (listOfLists != null) {
                for (List<T> list : listOfLists) {
                    if (list != null && !list.isEmpty()) {
                        mIteratorList.add(list.iterator());
                    }
                }
            }

            //if (!mIteratorList.isEmpty()) {
                mIterator = mIteratorList.iterator();
                if (mIterator.hasNext()) {
                    mCurrentIterator = mIterator.next();
                }
            //}
        }

        @Override
        public boolean hasNext() {
            return mCurrentIterator != null && mCurrentIterator.hasNext();
        }

        @Override
        public T next() {
            if (hasNext()) {
                T result = mCurrentIterator.next();
                if (!mCurrentIterator.hasNext()) {
                    if (mIterator.hasNext()) {
                        mCurrentIterator = mIterator.next();
                    }
                }
                return result;
            }
            throw new NoSuchElementException();
        }
    }

    // LRU cache

    public static class LRUCache<K, V> {

        private class Node {
            K key;
            V value;
            Node prev;
            Node next;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int mCapacity;
        private Map<K, Node> mMap = new HashMap<>();
        private Node mHead;
        private Node mTail;


        public LRUCache(int capacity) {
            this.mCapacity = capacity;
        }

        public V get(K key) {
            if (!mMap.containsKey(key)) {
                return null;
            }

            Node node = mMap.get(key);
            V result = node.value;
            removeNode(node);
            bringToFront(node);
            // If element exists
            // find element in map
            // move it to the head of the list

            // If element does not exist
            // return null

            return result;

        }

        private void addNew(K key, V value) {
            if (mMap.size() >= mCapacity) {
                mMap.remove(mTail.key);
                removeLast();
            }

            Node newNode = new Node(key, value);
            mMap.put(key, newNode);
            if (mHead == null && mTail == null) {
                mHead = newNode;
                mTail = newNode;
            } else {
                bringToFront(newNode);
            }
        }

        public void add(K key, V value) {
            if (mMap.containsKey(key)) {
                Node nodeToDelete = mMap.remove(key);
                removeNode(nodeToDelete);
            }

            addNew(key, value);

            // Check if it already exists
            // Remove and add new

            // Add to the map
            // Check if capacity allows to do that
            // if not remove LRU element
            // add to the front of the list

        }

        private void removeLast() {
            removeNode(mTail);
        }

        private void removeNode(Node node) {
            if (node == null) return;

            if (node == mHead) {
                mHead = mHead.next;
                mHead.prev = null;
            } else if (node == mTail) {
                mTail = mTail.prev;
                mTail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }

        public boolean isEmpty() {
            return mMap.size() == 0;
        }

        private void bringToFront(Node node) {
            node.next = mHead;
            mHead.prev = node;
            mHead = node;
        }

        public void clear() {
            mMap.clear();
            mHead = null;
            mTail = null;
        }
    }

    //Serialize/Deserialize generic tree
    public static class TreeSerDeser {
        public static class Node {
            char value;
            List<Node> children;

            public Node(char value) {
                this.value = value;
                children = new ArrayList<>();
            }
        }

        private final static Node LAYER_DELIMETER = new Node((char) 0);
        private final static Node CHILDREN_DELIMETER = new Node((char) 0);

        public static String serializeTree(Node root) {
            if (root == null) {
                return "";
            }

            StringBuffer result = new StringBuffer();
            LinkedList<Node> queue = new LinkedList<>();
            queue.offer(root);
            queue.offer(LAYER_DELIMETER);
            while (!queue.isEmpty()) {

                Node node = queue.pollFirst();

                if (node == LAYER_DELIMETER) {
                    if (queue.isEmpty()) {
                        continue;
                    }
                    result.append('#');
                    queue.offer(LAYER_DELIMETER);
                } else if (node == CHILDREN_DELIMETER) {
                    result.append('|');
                } else {
                    result.append(node.value);
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                    queue.offer(CHILDREN_DELIMETER);
                }
            }

            for (int i = result.length() - 1; i > 0; i--) {
                char ch = result.charAt(i);
                if (ch == '|' || ch == '#') {
                    result.deleteCharAt(i);
                } else {
                    break;
                }
            }
            return result.toString();
        }

        public static Node deserializeTree(String string) {
            if (string == null || string.isEmpty()) {
                return null;
            }

            Node root = new Node(string.charAt(0));

            LinkedList<Node> currLayer = new LinkedList<>();
            LinkedList<Node> prevLayer = new LinkedList<>();
            prevLayer.offer(root);

            for (int i = 2; i < string.length(); i++) {
                char ch = string.charAt(i);
                if (ch == '|') {
                    prevLayer.pollFirst();
                } else if (ch == '#') {
                    prevLayer = currLayer;
                    currLayer = new LinkedList<>();
                } else {
                    Node node = new Node(ch);
                    prevLayer.peekFirst().children.add(node);
                    currLayer.offer(node);
                }
            }

            return root;
        }

        public static void serializeTreeRecursively(Node root, StringBuffer sb) {

            if (root == null) {
                return;
            }

            sb.append(root.value);
            for (Node node : root.children) {
                serializeTreeRecursively(node, sb);
            }

            sb.append(')');
        }

        public static class Counter {
            int i;

            public int getIndexAndIncrement() {
                return i++;
            }
        }

        public static Node deserializeTreeRecursively(String string, Counter index) {

            if (index.i >= string.length() || string.charAt(index.i) == ')') {
                index.getIndexAndIncrement();
                return null;
            }

            Node root = new Node(string.charAt(index.getIndexAndIncrement()));
            while (true) {
                Node node = deserializeTreeRecursively(string, index);
                if (node == null) break;
                root.children.add(node);
            }

            return root;
        }
    }


    // Server logs with timestamps. Return K most frequent with their last timestamp
    // 1. HashMap to store unique links and counters. - O(N)
    // 2. Sort for K most popular - O(NlogN)
    // MaxHeap

    public static List<String> getKMostFrequentLogs(String[] arr, int k) {

        HashMap<String, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((first, second) -> second.getValue() - first.getValue());
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((first, second) -> first.getValue() - second.getValue());
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            maxHeap.add(entry);
        }

        int index = 0;
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (index < k) {
                minHeap.add(entry);
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.add(entry);
                }
            }
            index++;
        }


        List<String> result = new ArrayList<>();
        result.add("Max Heap: ");
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll().getKey());
        }

        result.add("Min Heap: ");
        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll().getKey());
        }

        return result;
    }

    public static int partition(int[] arr, int left, int right) {

        int pivot = arr[right];

        int j = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                j++;
            }
        }

        swap(arr, j, right);
        return j;
    }

    public static int kthSmallest(int[] arr, int left, int right, int k) {
        int pos = partition(arr, left, right);
        if (pos - left == k - 1) return arr[pos];
        if (pos - left > k - 1) return kthSmallest(arr, left, pos - 1, k);

        return kthSmallest(arr, pos + 1, right, k - pos + left - 1);
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    // Sort list items by descending frequencies
    // 1. HashMap to store unique links and counters. - O(N)
    // 2. Sort for K most popular - 0(NlogN) - partitioning
    public static List<Integer> sortByFrequencies(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> outputArray = new ArrayList<>();

        // Assign elements and their count in the list and map
        for (int current : arr) {
            int count = map.getOrDefault(current, 0);
            map.put(current, count + 1);
            outputArray.add(current);
        }

        // Compare the map by value
        SortComparator comp = new SortComparator(map);

        // Sort the map using Collections CLass
        Collections.sort(outputArray, comp);
        return outputArray;
    }

    public static class SortComparator implements Comparator<Integer> {

        private final Map<Integer, Integer> mFreqMap;

        public SortComparator(Map<Integer, Integer> map) {
            mFreqMap = map;
        }

        @Override
        public int compare(Integer first, Integer second) {

            int result = mFreqMap.get(second).compareTo(mFreqMap.get(first));
            if (result != 0) {
                return result;
            }

            return first.compareTo(second);
        }
    }

    // String comparison with numbers
    public static class NumberAwareStringComparator implements Comparator<String> {
        private static final boolean isDigit(char ch) {
            return ((ch >= '0') && (ch <= '9'));
        }

        @Override
        public int compare(String s1, String s2) {
            if (s1 == null && s2 == null) return 0;
            if (s1.isEmpty() && s2.isEmpty()) return 0;

            int firstIndex = 0;
            int secondIndex = 0;
            int firstLength = s1.length();
            int secondLength = s2.length();

            while (firstIndex < firstLength && secondIndex < secondLength) {

                String chunk1 = getChunk(s1, firstIndex);
                firstIndex += chunk1.length();

                String chunk2 = getChunk(s2, secondIndex);
                secondIndex += chunk2.length();

                int result = 0;
                if (isDigit(chunk1.charAt(0)) && isDigit(chunk2.charAt(0))) {

                    result = chunk1.length() - chunk2.length();
                    if (result != 0) return result;
                    for (int i = 0; i < chunk1.length(); i++) {
                        result = chunk1.charAt(i) - chunk2.charAt(i);
                        if (result != 0) return result;
                    }

                } else {
                    result = chunk1.compareTo(chunk2);
                }

                if (result != 0) {
                    return result;
                }
            }

            return firstLength - secondLength;
        }

        private static String getChunk(String string, int index) {
            StringBuffer buffer = new StringBuffer();
            final int stringLength = string.length();

            if (isDigit(string.charAt(index))) {
                while (index < stringLength && isDigit(string.charAt(index))) {
                    buffer.append(string.charAt(index));
                    index++;
                }
            } else {
                while (index < stringLength && !isDigit(string.charAt(index))) {
                    buffer.append(string.charAt(index));
                    index++;
                }
            }
            return buffer.toString();
        }
    }

    public static class AlphanumComparator implements Comparator<String> {
        private final boolean isDigit(char ch) {
            return ((ch >= 48) && (ch <= 57));
        }

        /**
         * Length of string is passed in for improved efficiency (only need to calculate it once)
         **/
        private final String getChunk(String s, int slength, int marker) {
            StringBuilder chunk = new StringBuilder();
            char c = s.charAt(marker);
            chunk.append(c);
            marker++;
            if (isDigit(c)) {
                while (marker < slength) {
                    c = s.charAt(marker);
                    if (!isDigit(c))
                        break;
                    chunk.append(c);
                    marker++;
                }
            } else {
                while (marker < slength) {
                    c = s.charAt(marker);
                    if (isDigit(c))
                        break;
                    chunk.append(c);
                    marker++;
                }
            }
            return chunk.toString();
        }

        public int compare(String s1, String s2) {
            if ((s1 == null) || (s2 == null)) {
                return 0;
            }

            int thisMarker = 0;
            int thatMarker = 0;
            int s1Length = s1.length();
            int s2Length = s2.length();

            while (thisMarker < s1Length && thatMarker < s2Length) {
                String thisChunk = getChunk(s1, s1Length, thisMarker);
                thisMarker += thisChunk.length();

                String thatChunk = getChunk(s2, s2Length, thatMarker);
                thatMarker += thatChunk.length();

                // If both chunks contain numeric characters, sort them numerically
                int result = 0;
                if (isDigit(thisChunk.charAt(0)) && isDigit(thatChunk.charAt(0))) {
                    // Simple chunk comparison by length.
                    int thisChunkLength = thisChunk.length();
                    result = thisChunkLength - thatChunk.length();
                    // If equal, the first different number counts
                    if (result == 0) {
                        for (int i = 0; i < thisChunkLength; i++) {
                            result = thisChunk.charAt(i) - thatChunk.charAt(i);
                            if (result != 0) {
                                return result;
                            }
                        }
                    }
                } else {
                    result = thisChunk.compareTo(thatChunk);
                }

                if (result != 0)
                    return result;
            }

            return s1Length - s2Length;
        }
    }

    // Sudoku checker
    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        boolean[] cell = new boolean[9];

        // Check all rows
        for (int row = 0; row < 9; row++) {
            Arrays.fill(cell, false);
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int currNumber = board[row][col] - '1';
                    if (!cell[currNumber]) {
                        cell[currNumber] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        // Check all columns
        for (int col = 0; col < 9; col++) {
            Arrays.fill(cell, false);
            for (int row = 0; row < 9; row++) {
                if (board[row][col] != '.') {
                    int currNumber = board[row][col] - '1';
                    if (!cell[currNumber]) {
                        cell[currNumber] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        // Check 3x3 blocks
        for (int block = 0; block < 9; block++) {
            Arrays.fill(cell, false);
            for (int row = block / 3 * 3; row < block / 3 * 3 + 3; row++) {
                for (int col = block % 3 * 3; col < block % 3 * 3 + 3; col++) {
                    if (board[row][col] != '.') {
                        if (cell[board[row][col] - '1']) {
                            return false;
                        }
                        cell[board[row][col] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public static String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            serailizeHelper(root, sb);
            return sb.toString();
        }

        private static void serailizeHelper(TreeNode root, StringBuffer sb) {
            if (root == null) {
                sb.append('#');
                return;
            }

            sb.append(root.val);
            serailizeHelper(root.left, sb);
            serailizeHelper(root.right, sb);
        }

        private static class Counter {
            int i;

            public int getIndexAndIncrement() {
                return i++;
            }
        }

        // Decodes your encoded data to tree.
        public static TreeNode deserialize(String data) {
            Counter index = new Counter();
            return deserializeHelper(data, index);
        }

        private static TreeNode deserializeHelper(String string, Counter index) {

            if (index.i >= string.length() || string.charAt(index.i) == '#') {
                index.getIndexAndIncrement();
                return null;
            }

            TreeNode root = new TreeNode(string.charAt(index.getIndexAndIncrement()) - '0');
            root.left = deserializeHelper(string, index);
            root.right = deserializeHelper(string, index);

            return root;
        }
    }

}
