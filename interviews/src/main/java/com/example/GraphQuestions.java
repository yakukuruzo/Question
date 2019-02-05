package com.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by levin on 3/10/17.
 */

public class GraphQuestions {

    public static class Graph {
        private final int V;
        LinkedList<Integer> adj[];

        public Graph(int v) {
            V = v;
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
        }

        public void dfs(int v) {
            //boolean visited[]= new boolean[V];
            HashSet<Integer> visited = new HashSet<>();
            dfs(v, visited);
        }

        private void dfs(int v, HashSet<Integer> visited) {
            visited.add(v);

            System.out.print(v + " ");

            Iterator<Integer> iterator = adj[v].iterator();

            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited.contains(n)) {
                    dfs(n, visited);
                }
            }
        }

        public void bfs(int v) {
            LinkedList<Integer> nextToVisit = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();
            nextToVisit.add(v);

            while (!nextToVisit.isEmpty()) {
                int n = nextToVisit.remove();

                if (visited.contains(n)) {
                    continue;
                }

                visited.add(n);

                System.out.print(n + " ");

                nextToVisit.addAll(adj[n]);
            }
        }


        // A recursive function to print DFS starting from v
        public void DFSUtil(int v, boolean visited[]) {
            // Mark the current node as visited and print it
            visited[v] = true;
            System.out.print(v + " ");

            int n;

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].iterator();
            while (i.hasNext()) {
                n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }

        // Function that returns reverse (or transpose) of this graph
        public Graph getTranspose() {
            Graph g = new Graph(V);
            for (int v = 0; v < V; v++) {
                // Recur for all the vertices adjacent to this vertex
                Iterator<Integer> i = adj[v].listIterator();
                while (i.hasNext())
                    g.adj[i.next()].add(v);
            }
            return g;
        }

        void fillOrder(int v, boolean visited[], Stack stack) {
            // Mark the current node as visited and print it
            visited[v] = true;

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].iterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    fillOrder(n, visited, stack);
            }

            // All vertices reachable from v are processed by now,
            // push v to Stack
            stack.push(new Integer(v));
        }

        // The main function that finds and prints all strongly
        // connected components
        public void printSCCs() {
            Stack stack = new Stack();

            // Mark all the vertices as not visited (For first DFS)
            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Fill vertices in stack according to their finishing
            // times
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    fillOrder(i, visited, stack);

            // Create a reversed graph
            Graph gr = getTranspose();

            // Mark all the vertices as not visited (For second DFS)
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Now process all vertices in order defined by Stack
            while (stack.empty() == false) {
                // Pop a vertex from stack
                int v = (int) stack.pop();

                // Print Strongly connected component of the popped vertex
                if (visited[v] == false) {
                    gr.DFSUtil(v, visited);
                    System.out.println();
                }
            }
        }


        public static class IslandSearch {

            static final int ROW = 5, COL = 5;

            private static void dfs(int[][] m, int row, int col, boolean[][] visited) {
                if (row < 0 || row >= ROW || col < 0 || col >= COL) return;
                if (visited[row][col]) return;

                visited[row][col] = true;

                dfs(m, row - 1, col - 1, visited);
                dfs(m, row - 1, col, visited);
                dfs(m, row - 1, col + 1, visited);
                dfs(m, row, col - 1, visited);
                dfs(m, row, col + 1, visited);
                dfs(m, row + 1, col - 1, visited);
                dfs(m, row + 1, col, visited);
                dfs(m, row + 1, col + 1, visited);
            }

            public static int countIslands(int M[][]) {
                int count = 0;

                boolean visited[][] = new boolean[ROW][COL];
                for (int i = 0; i < ROW; i++) {
                    for (int j = 0; j < COL; j++) {
                        if (M[i][j] == 1 && !visited[i][j]) {
                            dfs(M, i, j, visited);
                            count++;
                        }
                    }
                }

                return count;
            }
        }

    }
}
