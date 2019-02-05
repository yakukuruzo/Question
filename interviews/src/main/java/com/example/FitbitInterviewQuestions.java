package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by levin on 5/1/17.
 */

public class FitbitInterviewQuestions {

    /**
     * Copy a linked list.
     * <p>
     * Given a data structure like:
     * <p>
     * public class ListNode extends Object {
     * int data;
     * ListNode next;
     * }
     * <p>
     * Implement a deep copy method for the data structure.
     * Specifically, you will be filling in the body of the following method:
     * <p>
     * ListNode deepCopy( ListNode head);
     */


    public static class ListNode extends Object {
        public int data;
        public ListNode next;

    }

    /**
     * Implement me!
     */
    public static ListNode deepCopy(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode();
        newHead.data = head.data;

        ListNode currNode = newHead;

        while (head.next != null) {
            ListNode newNode = new ListNode();
            newNode.data = head.next.data;
            currNode.next = newNode;
            currNode = newNode;
            head = head.next;
        }

        return newHead;
    }

    public static ListNode deepCopyWithCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        Set<ListNode> nodeSet = new HashSet<>();

        ListNode cycleNode = head;

        while (cycleNode != null) {
            if (!nodeSet.contains(cycleNode)) {
                nodeSet.add(cycleNode);
            } else {
                break;
            }
            cycleNode = cycleNode.next;
        }

        ListNode newHead = new ListNode();
        newHead.data = head.data;

        ListNode currNode = newHead;
        ListNode newCycleNode = null;
        boolean cycleNodeWasCopied = false;

        while (head.next != null) {

            if (head.next == cycleNode) {
                if (!cycleNodeWasCopied) {
                    cycleNodeWasCopied = true;
                } else {
                    break;
                }
            }

            ListNode newNode = new ListNode();
            newNode.data = head.next.data;
            currNode.next = newNode;

            if (cycleNodeWasCopied && newCycleNode == null) {
                newCycleNode = newNode;
            }

            currNode = newNode;
            head = head.next;
        }

        currNode.next = newCycleNode;

        return newHead;
    }

    public static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode top = queue.poll();
            map.put(top, new UndirectedGraphNode(top.label));

            for (UndirectedGraphNode n : top.neighbors) {
                if (!map.containsKey(n))
                    queue.offer(n);
            }
        }

        queue.offer(node);
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode top = queue.poll();
            for (UndirectedGraphNode n : top.neighbors) {
                if (!set.contains(n)) {
                    queue.offer(n);
                    set.add(n);
                }
                map.get(top).neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }


    public static double findMedianSortedArrays1(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if ((m + n) % 2 != 0) // odd
            return (double) findKth(A, 0, m - 1, B, 0, n - 1, (m + n) / 2);
        else { // even
            return (findKth(A, 0, m - 1, B, 0, n - 1, (m + n) / 2)
                    + findKth(A, 0, m - 1, B, 0, n - 1, (m + n) / 2 - 1)) * 0.5;
        }
    }

    public static int findKth(int A[], int B[], int k) {
        int m = A.length;
        int n = B.length;

        return  findKth(A, 0, m - 1, B, 0, n - 1, k);
    }

    public static int findKth(int A[], int a_start, int a_end, int B[], int b_start, int b_end, int k) {
        int a_length = a_end - a_start + 1;
        int b_length = b_end - b_start + 1;

        //base cases
        if (a_length == 0) {
            return B[b_start + k];
        }
        if (b_length == 0) {
            return A[a_start + k];
        }
        //
        if (k == 0) {
            return Math.min(A[a_start], B[b_start]);
        }

        //select two index i,j from A and B respectively such that If A[i] is between B[j] and B[j-1]
        //Then A[i] would be the i+j+1 smallest element because.
        //Therefore, if we choose i and j such that i+j = k-1, we are able to find the k-th smallest element.
        int i = (int)(((double) a_length / (a_length + b_length)) * k);//let's try tp chose a middle element close to kth element in A
        int j = k - 1 - i;

        //add the offset
        int mid_a = Math.min(a_start + i, a_end);
        int mid_b = Math.min(b_start + j, b_end);

        //mid1 is greater than mid2. So, median is either in A[p1...mid1] or in B[mid2+1...r2].
        //we have already see B[p2..mid2] elements smaller than kth smallest
        if (A[mid_a] > B[mid_b]) {
            k = k - (mid_b - b_start + 1);
            a_end = mid_a;
            b_start = mid_b + 1;
        }
        //mid2 is greater than or equal mid1. So, median is either in A[mid1+1...r1] or in B[p2...mid2].
        //we have already see A[p1..mid1] elements smaller than kth smallest
        else {
            k = k - (mid_a - a_start + 1);
            a_start = mid_a + 1;
            b_end = mid_b;
        }

        return findKth(A, a_start, a_end, B, b_start, b_end, k);
    }

}
