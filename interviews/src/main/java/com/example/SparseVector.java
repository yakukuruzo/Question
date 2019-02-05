package com.example;

/**
 * Created by levin on 4/18/17.
 */

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

/**
 * Class SparseVector
 **/
class SparseVector {

    /* Tree map is used to maintain sorted order */
    private TreeMap<Integer, Double> st;
    private int N;

    /**
     * Constructor
     **/
    public SparseVector(int N) {
        this.N = N;
        st = new TreeMap<Integer, Double>();
    }

    /**
     * Function to insert a (key, value) pair
     **/
    public void put(int i, double value) {
        if (i < 0 || i >= N)
            throw new RuntimeException("\nError : Out of Bounds\n");

        if (value == 0.0)
            st.remove(i);
        else
            st.put(i, value);
    }

    /**
     * Function to get value for a key
     **/
    public double get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("\nError : Out of Bounds\n");
        }
        if (st.containsKey(i))
            return st.get(i);
        else
            return 0.0;
    }

    /**
     * Function to get size of the vector
     **/
    public int size() {
        return N;
    }

    /**
     * Function to get dot product of two vectors
     **/
    public double dot(SparseVector b) {
        SparseVector a = this;

        if (a.N != b.N)
            throw new RuntimeException("Error : Vector lengths are not same");

        double sum = 0.0;

        if (a.st.size() <= b.st.size()) {
            for (Map.Entry<Integer, Double> entry : a.st.entrySet())
                if (b.st.containsKey(entry.getKey()))
                    sum += a.get(entry.getKey()) * b.get(entry.getKey());
        } else {
            for (Map.Entry<Integer, Double> entry : b.st.entrySet())
                if (a.st.containsKey(entry.getKey()))
                    sum += a.get(entry.getKey()) * b.get(entry.getKey());
        }
        return sum;
    }

    /**
     * Function to get sum of two vectors
     **/
    public SparseVector plus(SparseVector b) {
        SparseVector a = this;
        if (a.N != b.N)
            throw new RuntimeException("Error : Vector lengths are not same");

        SparseVector c = new SparseVector(N);

        for (Map.Entry<Integer, Double> entry : a.st.entrySet())
            c.put(entry.getKey(), a.get(entry.getKey()));

        for (Map.Entry<Integer, Double> entry : b.st.entrySet())
            c.put(entry.getKey(), b.get(entry.getKey()) + c.get(entry.getKey()));

        return c;
    }

    /**
     * Function toString() for printing vector
     **/
    public String toString() {
        String s = "";
        for (Map.Entry<Integer, Double> entry : st.entrySet())
            s += "(" + entry.getKey() + ", " + st.get(entry.getKey()) + ") ";

        return s;
    }
}