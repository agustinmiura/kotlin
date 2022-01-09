package ar.com.miura.jvm.graph;


/**
 * For directed graph
 * https://leetcode.com/problems/redundant-connection/
 */
public class RebundantConnection {

    private static final int MAX_EDGE = 1000;

    public static void main(String[] args) {
        int[][] edges = new int[3][];
        edges[0]=new int[]{1,2};
        edges[1]=new int[]{2,3};
        edges[2]=new int[]{3,4};
        edges[2]=new int[]{1,4};
        edges[2]=new int[]{1,5};
    }

    public int[] findRedundantConnection(int[][] edges) {

        //build the graph
        java.util.List<java.util.List<Integer>> adjacentList = new java.util.ArrayList<>(MAX_EDGE+1);
        for(int i=0;i< MAX_EDGE+1;i++) {
            adjacentList.add(new java.util.ArrayList<>());
        }

        /**
         * Check if there is a cycle and return the latest
         */
        for(int[] edge:edges) {
            java.util.Set<Integer> visitedNodes = new java.util.TreeSet<Integer>();
            if (hasCycle(edge[0], edge[1], adjacentList, visitedNodes)) {
                return edge;
            }
            adjacentList.get(edge[0]).add(edge[1]);
            adjacentList.get(edge[1]).add(edge[0]);

        }

        return null;
    }

    private boolean hasCycle(int origin, int destination, java.util.List<java.util.List<Integer>> adjacentList, java.util.Set<Integer> visitedNodes) {
        if (!visitedNodes.contains(origin)) {
            visitedNodes.add(origin);
            if (origin==destination) {
                return true;
            }
            java.util.List<Integer> adjacents = adjacentList.get(origin);
            for(Integer eachConnection:adjacents) {
                if (hasCycle(eachConnection, destination, adjacentList, visitedNodes)) {
                    return true;
                }
            }
        }
        return false;
    }
}
