package ar.com.miura.jvm.graph.courseschedule;


/**
 * https://leetcode.com/problems/course-schedule-iv/
 */
public class CourseSchedule4 {

    public java.util.List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {

        boolean[][] connectivityMatrix = new boolean[n][n];

        //step connect the diagonals
        for(int i=0;i<connectivityMatrix.length;i++) {
            connectivityMatrix[i][i]=true;
        }

        //connect the edges;
        for(int[] edge:prerequisites) {
            connectivityMatrix[edge[0]][edge[1]]=true;
        }

        //set the matrix
        for(int k=0;k<connectivityMatrix.length;k++) {
            for(int u=0;u<connectivityMatrix.length;u++) {
                for(int v=0;v<connectivityMatrix.length;v++) {
                    connectivityMatrix[u][v] = connectivityMatrix[u][v] || connectivityMatrix[u][k]&&connectivityMatrix[k][v];
                }
            }
        }

        java.util.ArrayList<Boolean> queryResponses = new java.util.ArrayList<>();
        for(int[] eachQuery:queries) {
            queryResponses.add(connectivityMatrix[eachQuery[0]][eachQuery[1]]);
        }

        return queryResponses;
    }
}
