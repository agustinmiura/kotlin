package ar.com.miura.jvm.graph.algorithms;


/**
 * Floyd warshall algorithm
 */
public class FloydWarshall {

    private static final int MAX_COST = 10000 + 1;

    /**
     *
     * @param edges     All the edges with cost
     * @param n         Number of vertex
     * @return
     */
    public int[][] getMatrixCost(int[][] edges, int n) {

        //create distance array
        int[][] distance = new int[n][n];
        for(int i=0;i<n;i++) {
            java.util.Arrays.fill(distance[i], MAX_COST);
        }
        //fill the original distances
        for(int[] edge:edges) {
            distance[edge[0]][edge[1]]=distance[edge[1]][edge[0]]=edge[2];
        }

        //diagonals have cost 0
        java.util.stream.IntStream.range(0,n).forEach(eachVertex->distance[eachVertex][eachVertex]=0);

        //Floyd algorithm
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if ( (distance[i][k]+distance[k][j])<(distance[i][j]) ) {
                        distance[i][j] = distance[i][k]+distance[k][j];
                    }
                }
            }
        }
        return distance;
    }
}