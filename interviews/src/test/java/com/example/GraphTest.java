package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by levin on 4/26/17.
 */
public class GraphTest {

    @Test
    public void testPrintSCCs() throws Exception {
        GraphQuestions.Graph g = new GraphQuestions.Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components in given graph ");
        g.printSCCs();
    }

}