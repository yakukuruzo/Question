package com.example;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

import static com.example.SortQuestions.*;

/**
 * Created by levin on 4/12/17.
 */
public class SortQuestionsTest {
    @Test
    public void testMaxHeapSort() throws Exception {
        int[] array = new int[] {9, 4, 0, 3, -1, 4, 7, 12, 4, 3, -100};
        maxHeapSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testSelectionSort() throws Exception {
        int[] array = new int[] {9, 4, 0, 3, -1, 4, 7, 12, 4, 3, -100};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testInsertionSort() throws Exception {
        int[] array = new int[] {9, 4, 0, 3, -1, 4, 7, 12, 4, 3, -100};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testMergeSort() throws Exception {
        int[] array = new int[] {9, 4, 0, 3, -1, 4, 7, 12, 4, 3, -100};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testQuickSort() throws Exception {
        int[] array = new int[] {9, 4, 0, 3, -1, 4, 7, 12, 4, 3, -100};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testMinHeap() throws Exception {
        Heap minHeap = new MinHeap();
        minHeap.add(new int[]{3, 5, 6, 3, 5, 6, 7, 8, 0});
        while(!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }

    @Test
    public void testMaxHeap() throws Exception {
        Heap minHeap = new MaxHeap();
        minHeap.add(new int[]{3, 5, 6, 3, 5, 6, 7, 8, 0});
        while(!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }


}