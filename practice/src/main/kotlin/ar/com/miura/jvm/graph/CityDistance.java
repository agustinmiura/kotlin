package ar.com.miura.jvm.graph;

/**
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 */
public class CityDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        //create the Floyd Marshall matrix
        int[][] distance = new int[n][n];

        //fix max cost
        for(int i=0;i<n;i++) {
            java.util.Arrays.fill(distance[i], 10000+1);
        }

        //fill diagonal
        for(int i=0;i<n;i++) {
            distance[i][i]=0;
        }

        //fill with default distances
        for(int[] edge:edges) {
            distance[edge[0]][edge[1]]=distance[edge[1]][edge[0]]=edge[2];
        }

        //Floyd algorithm
        for(int k=0;k<n;k++) {
            //each step fill the matrix
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    int newDistance = distance[i][k] + distance[k][j];
                    if (newDistance<distance[i][j]) {
                        distance[i][j]=newDistance;
                    }
                }
            }
        }



        //Given the edges get the one with less cost
        int numberOfCities = n;
        int currentVertex=-1;
        for(int vertex=0;vertex<n;vertex++) {


            int currentNumberCities = 0;
            for(int j=0;j<n;j++) {
                if (distance[vertex][j]<=distanceThreshold) {
                    currentNumberCities++;
                }
            }
            if (currentNumberCities<=numberOfCities && currentNumberCities>0) {
                currentVertex = vertex;
                numberOfCities = currentNumberCities;
            }
        }

        return currentVertex;

    }
}

