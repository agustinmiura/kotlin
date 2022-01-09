package ar.com.miura.jvm.graph;

public class ShortestPathAlternatingColors {

    private static final int RED_COLOR = 1;
    private static final int BLUE_COLOR = -1;
    private static final int BOTH_COLOR = 0;

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {

        /**
         * Fill default values of matrix with :
         *  1 : RED
         * -1 : BLUE
         *  0 : BOTH
         */
        int[][] adjcentMatrixColor = new int[n][n];
        buildGraph(adjcentMatrixColor, n , red_edges, blue_edges);


        //fill with max value
        int[] distances = new int[n];
        java.util.Arrays.fill(distances, Integer.MAX_VALUE);


        /**
         * Offer a blue and a red postion
         */
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        boolean hasBlue = java.util.Arrays.stream(adjcentMatrixColor[0]).anyMatch(eachColor -> eachColor == BLUE_COLOR);
        queue.offer(new int[]{0, 1});
        queue.offer(new int[]{0, -1});
        distances[0] = 0;

        /**
         * Dfs
         */
        java.util.Set<String> visited = new java.util.TreeSet();
        int len = 0;
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] cur = queue.poll();
                int node = cur[0];
                int color = cur[1];
                int oppoColor = color * -1;

                for (int j = 1; j < n; j++) {


                    if (adjcentMatrixColor[node][j] == oppoColor || adjcentMatrixColor[node][j] == BOTH_COLOR) {
                        String key = j + "" + oppoColor;
                        if (!visited.add(key)) {
                            continue;
                        }
                        queue.offer(new int[]{j, oppoColor});
                        distances[j] = Math.min(distances[j], len);
                    }
                }
            }
        }

        java.util.stream.IntStream.range(0, n).forEach(vertex -> {
            if (distances[vertex] == Integer.MAX_VALUE) {
                distances[vertex] = -1;
            }
        });
        return distances;
    }

    private void buildGraph(int[][] graph, int graphSize, int[][] redEdges, int[][] blueEdges){
        java.util.stream.IntStream.range(0, graphSize).forEach(eachVertex -> java.util.Arrays.fill(graph[eachVertex], -1 * graphSize));

        /**
         * Fill each part with
         * : RED , BLUE or both (if thas edges for both cases)
         */
        for (int[] redEdge : redEdges) {
            graph[redEdge[0]][redEdge[1]] = RED_COLOR;
        }

        /**
         * Fill each part with blue if empty or
         * Both colors if it has both of them
         */
        for (int[] blueEdge : blueEdges) {
            int u = blueEdge[0];
            int v = blueEdge[1];
            if (graph[u][v] == RED_COLOR) {
                graph[u][v] = BOTH_COLOR;
            } else {
                graph[u][v] = BLUE_COLOR;
            }
        }
    }
}
