package ar.com.miura.jvm.graph;


/**
 * https://leetcode.com/problems/find-eventual-safe-states/submissions/
 */
public class FindEventualStateOptimized {

    public java.util.List<Integer> eventualSafeNodes(int[][] graph) {
        java.util.Set<Integer> whiteSet = new java.util.TreeSet<>();
        java.util.Set<Integer> greySet = new java.util.TreeSet<>();
        java.util.Set<Integer> blackSet = new java.util.TreeSet<>();

        java.util.List<Integer> answer = new java.util.ArrayList<>(graph.length);

        java.util.stream.IntStream.range(0, graph.length).forEach(vertex -> {
            whiteSet.add(vertex);
        });

        for(int i=0;i<graph.length;i++) {
            whiteSet.add(i);
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
