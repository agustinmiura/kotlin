package ar.com.miura.jvm.graph.algorithms;

/**
 * https://leetcode.com/problems/is-graph-bipartite/submissions/
 */
public class GraphBipartiteChecker {

    public boolean isBipartite(int[][] graph) {

        //by default no color is 0
        int[] colors = new int[graph.length];
        java.util.stream.IntStream.range(0, graph.length).forEach(vertex -> {
            colors[vertex] = 0;
        });

        //For each verte check if it is bypartite for disconnected graph
        for (int vertex = 0; vertex < graph.length; vertex++) {
            //only check in vertex without color
            if (colors[vertex] == 0) {
                if (!isBipartiteGraph(vertex, graph, colors)) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isBipartiteGraph(int vertex, int[][] graph, int[] colors) {
        //set origin color
        colors[vertex] = 1;

        java.util.Queue<Integer> vertexQueue = new java.util.LinkedList<Integer>();
        vertexQueue.add(vertex);

        while (!vertexQueue.isEmpty()) {

            int u = vertexQueue.poll();
            int[] adjacentList = graph[u];

            for (int v : adjacentList) {
                if (colors[v] == 0) {
                    colors[v] = -1 * colors[u];
                    vertexQueue.add(v);
                } else if (colors[u] == colors[v] && colors[u] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}