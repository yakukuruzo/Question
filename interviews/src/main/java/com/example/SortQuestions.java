package com.example;

import java.util.Arrays;

/**
 * Created by levin on 3/10/17.
 */

public class SortQuestions {

    public static void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    public static abstract class Heap {
        protected int capacity = 10;
        protected int size = 0;

        protected int[] items = new int[capacity];

        protected int getLeftChildIndex(int parentIndex) {
            return 2 * parentIndex + 1;
        }

        protected int getRightChildIndex(int parentIndex) {
            return 2 * parentIndex + 2;
        }

        protected int getParentIndex(int childIndex) {
            return (childIndex - 1) / 2;
        }

        protected boolean hasLeftChild(int index) {
            return getLeftChildIndex(index) < size;
        }

        protected boolean hasRightChild(int index) {
            return getRightChildIndex(index) < size;
        }

        protected boolean hasParent(int index) {
            return getParentIndex(index) >= 0;
        }

        protected int leftChild(int index) {
            return items[getLeftChildIndex(index)];
        }

        protected int rightChild(int index) {
            return items[getRightChildIndex(index)];
        }

        protected int parent(int index) {
            return items[getParentIndex(index)];
        }

        protected void ensureExtraCapacity() {
            if (size == capacity) {
                items = Arrays.copyOf(items, 2 * capacity);
                capacity *= 2;
            }
        }

        public boolean isEmpty() {
            return size <= 0;
        }

        public void add(int item) {
            ensureExtraCapacity();
            items[size] = item;
            size++;
            heapifyUp();
        }

        public void add(int[] items) {
            for (int item : items) {
                add(item);
            }
        }

        public int peek() {
            if (size == 0) throw new IllegalStateException();
            return items[0];
        }

        public int poll() {
            if (size == 0) throw new IllegalStateException();
            int item = items[0];
            items[0] = items[size - 1];
            size--;
            heapifyDown();
            return item;
        }

        protected abstract void heapifyDown();

        protected abstract void heapifyUp();

    }

    // Min Heap
    public static class MinHeap extends Heap {

        @Override
        protected void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && parent(index) > items[index]) {
                swap(items, getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }

        @Override
        protected void heapifyDown() {
            int index = 0;

            while (hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                    smallerChildIndex = getRightChildIndex(index);
                }
                if (items[index] < items[smallerChildIndex]) {
                    break;
                } else {
                    swap(items, index, smallerChildIndex);
                }
                index = smallerChildIndex;
            }
        }
    }

    // Max Heap
    public static class MaxHeap extends Heap {

        @Override
        protected void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && parent(index) < items[index]) {
                swap(items, getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }

        @Override
        protected void heapifyDown() {
            int index = 0;

            while (hasLeftChild(index)) {
                int biggerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                    biggerChildIndex = getRightChildIndex(index);
                }
                if (items[index] > items[biggerChildIndex]) {
                    break;
                } else {
                    swap(items, index, biggerChildIndex);
                }
                index = biggerChildIndex;
            }
        }
    }


    // Merge sort
    public static void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) return;

        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array, temp, leftStart, middle);
        mergeSort(array, temp, middle + 1, rightEnd);
        mergeHalves(array, temp, leftStart, rightEnd);
    }

    public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;

        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] < array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }


    // Quick sort
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = array[(left + right) / 2];

        int index = partition(array, left, right, pivot);
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }

    public static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    // Selection sort
    public static void selectionSort(int[] array) {
        int i, j, minValue, minValueIndex;
        for (i = 0; i < array.length; i++) {
            minValue = array[i];
            minValueIndex = i;

            for (j = i; j < array.length; j++) {
                if (array[j] < minValue) {
                    minValue = array[j];
                    minValueIndex = j;
                }
            }

            swap(array, i, minValueIndex);
        }
    }

    // Insertion sort
    public static void insertionSort(int[] array) {
        int j, key;
        for (int i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;
            while (j >= 0 && key < array[j]) {
                swap(array, j, j + 1);
                j--;
            }
        }
    }

    // Heap sort
    public static void maxHeapSort(int array[]) {
        int n = buildheap(array);

        for (int i = n; i > 0; i--) {
            swap(array, 0, i);
            n = n - 1;
            maxheap(array, 0, n);
        }
    }

    public static void maxheap(int[] array, int i, int n){
        int left = 2*i;
        int right = 2*i + 1;
        int largest;

        if(left <= n && array[left] > array[i]){
            largest = left;
        } else {
            largest = i;
        }

        if(right <= n && array[right] > array[largest]){
            largest = right;
        }

        if(largest != i){
            swap(array, i,largest);
            maxheap(array, largest, n);
        }
    }

    public static int buildheap(int []a){
        int n = a.length - 1;
        for(int i = n/2; i >= 0; i--) {
            maxheap(a, i, n);
        }
        return n;
    }
}
