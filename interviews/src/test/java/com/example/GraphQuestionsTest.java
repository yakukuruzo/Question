package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by levin on 3/14/17.
 */
public class GraphQuestionsTest {
    @Test
    public void testDfs() throws Exception {
        GraphQuestions.Graph g = new GraphQuestions.Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.dfs(2);
    }

    @Test
    public void testBFS() throws Exception {
        GraphQuestions.Graph g = new GraphQuestions.Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.bfs(2);
    }

    @Test
    public void testIslandSearch() {
        int result = GraphQuestions.Graph.IslandSearch.countIslands(new int[][] {
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 1, 1}
        });

        System.out.println("Amount of islands = " + result);
    }
}