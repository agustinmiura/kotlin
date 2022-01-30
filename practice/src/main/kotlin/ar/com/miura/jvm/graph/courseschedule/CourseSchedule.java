package ar.com.miura.jvm.graph.courseschedule;


/**
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] degrees = new int[numCourses];
        java.util.ArrayList<java.util.ArrayList<Integer>> adjacentList = new java.util.ArrayList<>();
        java.util.stream.IntStream.range(0, numCourses).forEach(eachVertex -> adjacentList.add(new java.util.ArrayList<>()));

        //fill the degree array
        for(int i=0;i<numCourses;i++) {
            degrees[i]=0;
        }

        java.util.Queue<Integer> rootNodes = new java.util.LinkedList();

        //create the adjacent list
        for(int[] edge:prerequisites) {
            int u = edge[0];
            int v = edge[1];
            degrees[v]++;
            adjacentList.get(u).add(v);
        }

        for(int i=0;i<degrees.length;i++) {
            if (degrees[i]==0) {
                rootNodes.add(i);
            }
        }

        //dfs the graph taking into account the grades of the nodes
        int acumCourse = 0;
        while(!rootNodes.isEmpty()) {
            acumCourse++;
            int course = rootNodes.poll();
            for(int[] pair:prerequisites) {
                if (pair[0]==course) {
                    degrees[pair[1]]--;
                    if (degrees[pair[1]]==0) {
                        rootNodes.add(pair[1]);
                    }
                }
            }
        }
        return numCourses==acumCourse;
    }
}
