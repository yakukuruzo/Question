package com.example;

import org.junit.Test;

import com.example.HeapQuestions.*;

public class HeapQuestionsTest {

    @Test
    public void minHeapTest() {
        Heap minHeap = new MinHeap();
        minHeap.add(4);
        minHeap.add(2);
        minHeap.add(5);
        minHeap.add(9);
        minHeap.add(4);
        minHeap.add(0);

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll());
        }
        System.out.println();
    }

    @Test
    public void maxHeapTest() {
        Heap heap = new MaxHeap();
        heap.add(4);
        heap.add(2);
        heap.add(5);
        heap.add(9);
        heap.add(4);
        heap.add(0);

        while (!heap.isEmpty()) {
            System.out.print(heap.poll());
        }
        System.out.println();
    }
}