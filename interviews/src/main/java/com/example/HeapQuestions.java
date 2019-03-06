package com.example;

import java.util.Arrays;

public class HeapQuestions {

    public static void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    public static abstract class Heap {

        protected int size;
        protected int[] arr;
        protected int capacity = 10;

        public Heap() {
            size = 0;
            arr = new int[capacity];
        }

        public int getLeftChildIndex(int parentIndex) {
            return parentIndex * 2 + 1;
        }

        public int getRightChildIndex(int parentIndex) {
            return parentIndex * 2 + 2;
        }

        public int getParentIndex(int childIndex) {
            return (childIndex - 1) / 2;
        }

        public boolean hasLeftChild(int parentIndex) {
            return getLeftChildIndex(parentIndex) < size;
        }

        public boolean hasRightChild(int parentIndex) {
            return getRightChildIndex(parentIndex) < size;
        }

        public boolean hasParent(int childIndex) {
            return getParentIndex(childIndex) >= 0;
        }

        public int leftChild(int index) {
            return arr[getLeftChildIndex(index)];
        }

        public int rightChild(int index) {
            return arr[getRightChildIndex(index)];
        }

        public int parent(int index) {
            return arr[getParentIndex(index)];
        }

        public boolean isEmpty() {
            return size <= 0;
        }

        public void ensureExtraSpace() {
            if (size == capacity) {
                arr = Arrays.copyOf(arr, capacity * 2);
                capacity *= 2;
            }
        }

        public void add(int item) {
            ensureExtraSpace();
            arr[size] = item;
            size++;
            heapifyUp();
        }

        public int peek() {
            if (size == 0) throw new IllegalStateException();
            return arr[0];
        }

        public int poll() {
            if (size == 0) throw new IllegalStateException();
            int result = arr[0];
            size--;
            arr[0] = arr[size];
            heapifyDown();
            return result;
        }

        public abstract void heapifyUp();

        public abstract void heapifyDown();
    }


    public static class MinHeap extends Heap {

        @Override
        public void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && parent(index) > arr[index]) {
                swap(arr, getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }

        @Override
        public void heapifyDown() {
            int index = 0;
            while (hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                    smallerChildIndex = getRightChildIndex(index);
                }
                if (arr[index] < arr[smallerChildIndex]) {
                    break;
                } else {
                    swap(arr, index, smallerChildIndex);
                }
                index = smallerChildIndex;
            }
        }
    }

    public static class MaxHeap extends Heap {

        @Override
        public void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && parent(index) < arr[index]) {
                swap(arr, index, getParentIndex(index));
                index = getParentIndex(index);
            }
        }

        @Override
        public void heapifyDown() {
            int index = 0;
            while (hasLeftChild(index)) {
                int biggerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                    biggerChildIndex = getRightChildIndex(index);
                }

                if (arr[index] > arr[biggerChildIndex]) {
                    break;
                } else {
                    swap(arr, index, biggerChildIndex);
                }
                index = biggerChildIndex;
            }
        }
    }

    // To heapify a subtree with root at given index
    static void MaxHeapify(int arr[], int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < n && arr[l] > arr[i])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            // swap arr[i] and arr[largest]
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            MaxHeapify(arr, largest, n);
        }
    }

    // This function basically builds max heap
    static void convertMaxHeap(int arr[], int n) {
        // Start from bottommost and rightmost
        // internal mode and heapify all internal
        // modes in bottom up way
        for (int i = (n - 2) / 2; i >= 0; --i)
            MaxHeapify(arr, i, n);
    }

    // A utility function to print a given array
    // of given size
    static void printArray(int arr[], int size) {
        for (int i = 0; i < size; ++i)
            System.out.print(arr[i] + " ");
    }
}
