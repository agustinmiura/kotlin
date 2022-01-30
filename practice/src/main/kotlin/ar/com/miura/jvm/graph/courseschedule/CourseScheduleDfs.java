package ar.com.miura.jvm.graph.courseschedule;

public class CourseScheduleDfs {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        java.util.Map<Integer, java.util.List<Integer>> graph = new java.util.HashMap<>();

        java.util.Set<Integer> visited = new java.util.HashSet<Integer>();

        boolean[] inStack = new boolean[numCourses];

        /*
        Graph
        */
        java.util.Map<Integer, Integer> vertexState = new java.util.HashMap<>();
        for(int[] edge:prerequisites) {

            int origin = edge[0];
            int destination = edge[1];

            graph.putIfAbsent(origin, new java.util.ArrayList<>());
            graph.putIfAbsent(destination, new java.util.ArrayList<>());

            graph.get(origin).add(destination);


        }

        for(int i=0;i<numCourses;i++) {
            boolean hasCycle = hasCycle(i, graph, visited, inStack);
            if (hasCycle) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int vertex, java.util.Map<Integer, java.util.List<Integer>> graph, java.util.Set<Integer> visited, boolean[] inStack) {

        if (!visited.contains(vertex)) {
            visited.add(vertex);
            inStack[vertex] = true;

            java.util.List<Integer> adjacents = graph.getOrDefault(vertex, new java.util.ArrayList<Integer>());
            for(Integer adjacent:adjacents) {
                if (!visited.contains(adjacent) &&  hasCycle(adjacent, graph, visited, inStack)) {
                    return true;
                } else if (inStack[adjacent]) {
                    return true;
                }
            }

        }

        inStack[vertex] = false;
        return false;

    }
}
