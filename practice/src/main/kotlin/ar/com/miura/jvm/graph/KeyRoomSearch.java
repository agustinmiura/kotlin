package ar.com.miura.jvm.graph;


/**
 * https://leetcode.com/problems/keys-and-rooms/solution/
 */
public class KeyRoomSearch {
    public boolean canVisitAllRooms(java.util.List<java.util.List<Integer>> rooms) {

        //rooms is the graph;
        int graphSize = rooms.size();
        boolean[] visited = new boolean[graphSize+1];

        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        visited[0] = true;
        queue.offer(new Integer(0));

        boolean lastReached = false;
        while(!queue.isEmpty()) {

            Integer vertex = queue.poll();

            if (!lastReached && (vertex == graphSize -1)) {
                lastReached = true;
            }

            java.util.List<Integer> nearNodes = rooms.get(vertex);
            for(Integer eachNear:nearNodes) {
                if (!visited[eachNear]) {
                    queue.add(eachNear);
                    visited[eachNear] = true;
                }
            }

        }

        boolean allVisited = true;
        int size = visited.length;
        for(int i=0;i<size;i++) {
            if (i==size-1) {
                continue;
            }
            allVisited &= visited[i];
            if (!allVisited) {
                break;
            }
        }
        return allVisited && lastReached;
    }
}