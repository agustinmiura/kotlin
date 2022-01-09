package ar.com.miura.jvm.graph;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 *
 * Input: graph = [[1],[]]
 * Output: [[0,1]]
 *
 * Input: graph = [[1,2,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,2,3],[0,3]]
 *
 * Input: graph = [[1,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,3]]s
 */
public class AllPath {

    public static void main(String[] args) {
        int[][] graph = new int[5][];
        graph[0]= new int[]{4,3,1};
        graph[1]= new int[]{3,2,4};
        graph[2]= new int[]{3};
        graph[3]= new int[]{4};
        graph[4]= new int[]{};

        java.util.List<java.util.List<Integer>> paths = new AllPath().allPathsSourceTarget(graph);

        String stopPoint = "stopPoint";

    }

    public java.util.List<java.util.List<Integer>> allPathsSourceTarget(int[][] graph) {
        //create graph
        java.util.List<java.util.List<Integer>> adjacentList = new java.util.ArrayList<>();
        for(int i=0;i<graph.length;i++) {
            adjacentList.add(new java.util.ArrayList<>());
        }

        //Fill adjacent list here
        for(int vertex=0;vertex<graph.length;vertex++) {
            int[] connected = graph[vertex];
            for(int j=0;j<connected.length; j++) {
                adjacentList.get(vertex).add(graph[vertex][j]);
            }
        }

        java.util.Queue<java.util.List<Integer>> queuePath = new java.util.LinkedList<>();
        queuePath.add(java.util.Arrays.asList(new Integer[]{0}));

        int destination = graph.length-1;
        java.util.List<java.util.List<Integer>> paths = new java.util.ArrayList<>();
        while(!queuePath.isEmpty()) {
            java.util.List<Integer> currentPath = queuePath.poll();
            if (currentPath.get(currentPath.size()-1).equals(destination)) {
                paths.add(currentPath);

            } else {
                java.util.List<Integer> nearVertexes = adjacentList.get(currentPath.get(currentPath.size()-1));
                nearVertexes.stream().forEach( eachVertex -> {
                    java.util.List<Integer> newPath = currentPath.stream().collect(java.util.stream.Collectors.toList());
                    newPath.add(eachVertex);
                    queuePath.add(newPath);
                });
            }
        }
        return paths;
    }
}
