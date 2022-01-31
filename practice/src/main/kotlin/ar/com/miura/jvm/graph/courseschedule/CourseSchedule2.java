package ar.com.miura.jvm.graph.courseschedule;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        java.util.Map<Integer, java.util.List<Integer>> graph = new java.util.HashMap<>();

        int[] grades = new int[numCourses];

        for(int[] edge:prerequisites) {
            int end = edge[0];
            int start = edge[1];

            graph.putIfAbsent(end, new java.util.ArrayList<Integer>());
            graph.putIfAbsent(start, new java.util.ArrayList<Integer>());

            graph.get(start).add(end);

            grades[end]++;
        }


        java.util.Queue<Integer> queue = new java.util.LinkedList<Integer>();
        for(int i=0;i<numCourses;i++) {
            if (grades[i]==0) {
                queue.offer(i);
            }
        }

        java.util.List<Integer> visited = new java.util.ArrayList<Integer>();
        int visitedQty = 0;
        while(!queue.isEmpty()) {
            visitedQty++;

            Integer vertex = queue.poll();
            visited.add(vertex);

            for(Integer adjacent:graph.getOrDefault(vertex, new java.util.ArrayList<>())) {

                if (grades[adjacent]!=0) {
                    grades[adjacent]--;
                }
                if (grades[adjacent]==0) {
                    queue.offer(adjacent);
                }
            }
        }

        if (visited.size()==numCourses) {
            int[] ints = visited.stream().mapToInt(Integer::intValue).toArray();
            return ints;
        } else {
            return new int[]{};
        }
    }
}
