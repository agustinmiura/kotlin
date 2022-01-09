package ar.com.miura.jvm.graph;


/**
 * https://leetcode.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/
 */
public class ConnectedTrioDegree {

    public int minTrioDegree(int n, int[][] edges) {
        java.util.Map<Integer, Integer> degreeMap = new java.util.HashMap<>();
        boolean[][] isEdge = new boolean[n+1][n+1];

        /**
         * Get the degree for each vertex and save if they are or not
         * edges
         */
        for(int[] edge:edges) {
            int start = edge[0];
            int end = edge[1];
            degreeMap.put(start, degreeMap.getOrDefault(start, 0)+1);
            degreeMap.put(end, degreeMap.getOrDefault(end, 0)+1);
            isEdge[start][end]=true;
            isEdge[end][start]=true;
        }

        /**
         * For each edge test each graph point to see if there is a triangle and evaluate the
         * degree
         */
        int min = Integer.MAX_VALUE;
        for(int[] edge:edges) {
            int u = edge[0];
            int v = edge[1];
            for(int i=0;i<n;i++) {
                if (isEdge[i][u]&&isEdge[i][v]) {
                    int degree = degreeMap.get(i) + degreeMap.get(u) + degreeMap.get(v) - 6;
                    min = Math.min(degree, min);
                }

            }
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }
}
