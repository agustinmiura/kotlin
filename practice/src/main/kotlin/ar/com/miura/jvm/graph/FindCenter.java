package ar.com.miura.jvm.graph;


public class FindCenter {
    public int findCenter(int[][] edges) {

        int[] vertexGrade = new int[100000+1];
        java.util.Arrays.fill(vertexGrade, 0);

        int maxGrade = -1;
        int maxVertex = -1;

        for(int[] eachEdge:edges) {

            int u = eachEdge[0];
            int v = eachEdge[1];

            int qty = vertexGrade[u];
            qty++;
            vertexGrade[u]=qty;

            if (vertexGrade[u]>maxGrade) {
                maxVertex = u;
                maxGrade = vertexGrade[u];
            }

            qty = vertexGrade[v];
            qty++;
            vertexGrade[v]=qty;

            if (vertexGrade[v]>maxGrade) {
                maxVertex = v;
                maxGrade = vertexGrade[v];
            }
        }
        return maxVertex;
    }
}
