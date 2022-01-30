package ar.com.miura.jvm.graph.courseschedule;

public class CourseScheduleTopology {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites.length==0) {
            return true;
        }

        java.util.Map<Integer, java.util.List<Integer>> graph = new java.util.HashMap<>();

        java.util.Map<Integer, Integer> grades = new java.util.HashMap<>();

        for(int[] edge:prerequisites) {

            int start = edge[0];
            int end = edge[1];

            graph.putIfAbsent(start, new java.util.ArrayList<>());
            graph.putIfAbsent(end, new java.util.ArrayList<>());

            graph.get(start).add(end);

            grades.putIfAbsent(start, 0);
            grades.putIfAbsent(end, 0);

            /*
            start => end
            */
            Integer grade = grades.get(end);
            grade++;
            grades.put(end, grade);

        }

        java.util.List<Integer> nodes = new java.util.ArrayList<>();

        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            int grade = grades.getOrDefault(i, 0);
            if (grade==0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            java.util.List<Integer> adjacents = graph.getOrDefault(node, new java.util.ArrayList<Integer>());
            count++;
            for(Integer adjacent:adjacents) {

                int tempGrade = grades.get(adjacent);

                if (tempGrade!=0) {
                    tempGrade--;
                    grades.put(adjacent, tempGrade);
                    if (tempGrade==0) {
                        queue.offer(adjacent);
                    }
                }
            }
        }
        return (count==numCourses);

    }
}
