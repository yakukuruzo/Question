package com.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.example.FitbitInterviewQuestions.*;

/**
 * Created by levin on 5/1/17.
 */
public class FitbitInterviewQuestionsTest {
    @Test
    public void testFindMedianSortedArrays1() throws Exception {

        int[] A = {1, 3, 5, 6, 7, 9, 10, 15, 17, 23};
        int[] B = {4, 5, 6, 9, 12, 14, 25, 36, 47};

        //System.out.println(findMedianSortedArrays1(A, B));

        System.out.println(findKth(A, B, 10));
    }

    @Test
    public void testCloneGraph() throws Exception {
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node1);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node2);
        node4.neighbors.add(node3);

        UndirectedGraphNode newNode = cloneGraph(node1);
    }

    @Test
    public void testDeepCopy() throws Exception {
        // Test list
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node4.data = 4;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Make a copy of list
        ListNode head = node1;
        ListNode copyHead = deepCopy(head);

        // Test: change original data values to verify that
        // results of deepCopy() is a "true" copy.  I.e., copy
        // data values should still be 1, 2, 3, 4 when printed out.
        node1.data = 101;
        node2.data = 102;
        node3.data = 103;
        node4.data = 104;

        // Print out copy of list
        ListNode temp = copyHead;
        while (temp != null) {
            System.out.println("Node data: " + temp.data);
            temp = temp.next;
        }
    }

    @Test
    public void testDeepCopyWithCycle() throws Exception {
        // Test list
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node4.data = 4;
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;

        // Make a copy of list
        ListNode head = node1;
        ListNode copyHead = deepCopyWithCycle(head);

        // Test: change original data values to verify that
        // results of deepCopy() is a "true" copy.  I.e., copy
        // data values should still be 1, 2, 3, 4 when printed out.
        node1.data = 101;
        node2.data = 102;
        node3.data = 103;
        node4.data = 104;

        // Print out copy of list
        FitbitInterviewQuestions.ListNode temp = copyHead;
        int counter = 0;
        while (temp != null && counter < 20) {
            System.out.println("Node data: " + temp.data);
            temp = temp.next;
            counter++;
        }
    }

}