package ar.com.miura.jvm.graph;


/**
 *
 * We start at some node in a directed graph, and every turn, we walk along a directed edge of the graph. If we reach a terminal node (that is, it has no outgoing directed edges), we stop.
 *
 * We define a starting node to be safe if we must eventually walk to a terminal node. More specifically, there is a natural number k, so that we must have stopped at a terminal node in less than k steps for any choice of where to walk.
 *
 * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 *
 * The directed graph has n nodes with labels from 0 to n - 1, where n is the length of graph. The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph, going from node i to node j.
 *
 * https://leetcode.com/problems/find-eventual-safe-states/
 * https://www.youtube.com/watch?v=rKQaZuoUR4M
 *
 * Time limit excedded
 */
public class FindEventualSafeState {

    public java.util.List<Integer> eventualSafeNodes(int[][] graph) {
        java.util.Set<Integer> whiteSet = new java.util.TreeSet<>();
        java.util.Set<Integer> greySet = new java.util.TreeSet<>();
        java.util.Set<Integer> blackSet = new java.util.TreeSet<>();

        java.util.List<Integer> answer = new java.util.ArrayList<>(graph.length);

        for(int i=0;i<graph.length;i++) {
            whiteSet.clear();
            java.util.stream.IntStream.range(0, graph.length).forEach(vertex -> {
                whiteSet.add(vertex);
            });
            if (!containsCycleDfs(i, graph, whiteSet, greySet, blackSet)) {
                answer.add(i);
            }
        }
        return answer;
    }

    private boolean containsCycleDfs(int currentVertex, int[][] graph, java.util.Set<Integer> whiteSet, java.util.Set<Integer> greySet, java.util.Set<Integer> blackSet) {

        /**
         * Use old information , if node is already part of a cycle return true;
         */
        if (greySet.contains(currentVertex)) {
            return true;
            //If node is already a black set stop
        } else if (blackSet.contains(currentVertex)) {
            return false;
        }

        moveVertex(currentVertex, whiteSet, greySet);
        int[] adjacentList = graph[currentVertex];
        for(int currentAdjacent:adjacentList) {
            //black set visited
            if (blackSet.contains(currentAdjacent)) {
                continue;
            }
            //grey set in cycle
            if (greySet.contains(currentAdjacent)) {
                return true;
            }

            //check in adjacents
            if (containsCycleDfs(currentAdjacent, graph, whiteSet, greySet, blackSet)) {
                return true;
            }
        }
        //node visited move to black set
        moveVertex(currentVertex, greySet, blackSet);
        return false;
    }

    private void moveVertex(int currentVertex, java.util.Set<Integer> origin, java.util.Set<Integer> destination) {
        origin.remove(currentVertex);
        destination.add(currentVertex);
    }
}
