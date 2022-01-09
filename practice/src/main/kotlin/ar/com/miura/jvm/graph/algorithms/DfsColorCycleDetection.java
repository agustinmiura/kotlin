package ar.com.miura.jvm.graph.algorithms;

public class DfsColorCycleDetection {
    public java.util.Set<Integer> getCycle(int graph[][]) {
        java.util.Set<java.lang.Integer> whiteSet = new java.util.TreeSet();
        java.util.Set<java.lang.Integer> blackSet = new java.util.TreeSet<>();
        java.util.Set<java.lang.Integer> greySet = new java.util.TreeSet<>();
        java.util.stream.IntStream.range(0, graph.length).forEach(vertex -> {whiteSet.add(vertex);});
        hasCycle(0, whiteSet, greySet, blackSet, graph);
        return greySet;
    }

    /**
     * @param currentVertex
     * @param whiteSet
     * @param greySet
     * @param blackSet
     * @return
     */
    private boolean hasCycle(int currentVertex, java.util.Set<Integer> whiteSet, java.util.Set<Integer> greySet, java.util.Set<Integer> blackSet, int[][] graph) {
        moveVertex(currentVertex, whiteSet, greySet);
        int[] adjacentList = graph[currentVertex];
        for(int eachAdjacent:adjacentList) {
            //if vertex in black set avoid it
            if (blackSet.contains(eachAdjacent)) {
                continue;
            }
            //if in gray set we are in a cycle
            if (greySet.contains(eachAdjacent)) {
                return true;
            }
            //check with the adjacents ones
            if (hasCycle(eachAdjacent, whiteSet, greySet, blackSet, graph)) {
                return true;
            }

        }
        //move vertex from gray to black
        moveVertex(currentVertex, greySet, blackSet);
        return false;
    }

    /**
     * @param currentVertex
     * @param whiteSet
     * @param greySet
     */
    private void moveVertex(int currentVertex, java.util.Set<Integer> whiteSet, java.util.Set<Integer> greySet) {
        whiteSet.remove(currentVertex);
        greySet.add(currentVertex);
    }
}
