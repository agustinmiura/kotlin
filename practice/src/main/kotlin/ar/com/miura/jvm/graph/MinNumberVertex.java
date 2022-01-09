package ar.com.miura.jvm.graph;


/**
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 */
public class MinNumberVertex {

    public static void main(String[] args) {
        java.util.List<java.util.List<Integer>> edges = new java.util.ArrayList<>();

        edges.add(java.util.Arrays.asList(new Integer[]{0,1}));
        edges.add(java.util.Arrays.asList(new Integer[]{0,2}));
        edges.add(java.util.Arrays.asList(new Integer[]{2,5}));
        edges.add(java.util.Arrays.asList(new Integer[]{3,4}));
        edges.add(java.util.Arrays.asList(new Integer[]{4,2}));

        java.util.List<Integer> minVertex = new MinNumberVertex().findSmallestSetOfVertices(6,edges);

        String endpoint = "endpoint";

    }

    public java.util.List<Integer> findSmallestSetOfVertices(int n, java.util.List<java.util.List<Integer>> edges) {
        int[] degreeArray = new int[n];

        for(java.util.List<Integer> eachEdge:edges) {
            int origin = eachEdge.get(0);
            int destination = eachEdge.get(1);
            degreeArray[destination] = degreeArray[destination]  + 1;
        }

        java.util.List<Integer> smallest = new java.util.ArrayList<>();
        for(int i=0;i<degreeArray.length;i++) {
            if (degreeArray[i]==0) {
                smallest.add(i);
            }
        }
        return smallest;

    }
}

