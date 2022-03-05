package ar.com.miura.hr.graph;

public class BuildHotelsWays {

    public static int numberOfWays(java.util.List<java.util.List<Integer>> roads) {
        int ways = 0;
        java.util.Map<Integer, java.util.List<Integer>> graph = new java.util.HashMap();
        int cityQty = Integer.MIN_VALUE;
        for(java.util.List<Integer> road:roads) {

            Integer start = road.get(0);
            Integer end = road.get(1);

            java.util.List<Integer> adjacent = graph.getOrDefault(start, new java.util.ArrayList());
            adjacent.add(end);
            graph.put(start, adjacent);

            adjacent = graph.getOrDefault(end, new java.util.ArrayList());
            adjacent.add(start);
            graph.put(end, adjacent);

            cityQty = Math.max(cityQty, start);
            cityQty = Math.max(cityQty, end);
        }

        java.util.List<java.util.List<Integer>> combinations = new java.util.ArrayList();

        for(int i=1;i<=cityQty-2;i++) {
            for(int j=i+1;j<=cityQty-1;j++) {
                for(int k=j+1;k<=cityQty;k++) {
                    java.util.List<Integer> comb = new java.util.ArrayList();
                    comb.add(i);
                    comb.add(j);
                    comb.add(k);
                    combinations.add(comb);
                }
            }
        }

        for(java.util.List<Integer> comb:combinations) {
            int x = comb.get(0);
            int y = comb.get(1);
            int z = comb.get(2);
            if (sameDistance(x,y,z, graph)) {
                ways++;
            }
        }

        return ways;

    }

    private static boolean sameDistance(int x, int y, int z, java.util.Map<Integer, java.util.List<Integer>> graph) {
        int distanceXY = getDistance(x,y, graph);
        int distanceYZ = getDistance(y,z, graph);
        int distanceXZ = getDistance(x,z, graph);
        return ( distanceXY >= 1 && distanceYZ >= 1 && distanceXZ >=1 && distanceXY==distanceYZ && distanceYZ==distanceXZ);
    }

    private static int getDistance(int start, int end, java.util.Map<Integer, java.util.List<Integer>> graph) {

        java.util.Queue<Integer> queue = new java.util.LinkedList();
        java.util.Set<Integer> visited = new java.util.HashSet();

        queue.offer(start);
        visited.add(start);

        int distance = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for(int i=0;i<size;i++) {
                int vertex = queue.poll();
                if (vertex==end) {
                    return distance;
                }
                java.util.List<Integer> adjacents = graph.getOrDefault(vertex, new java.util.ArrayList());
                for(Integer adjacent:adjacents) {
                    if (!visited.contains(adjacent)) {
                        visited.add(adjacent);
                        queue.offer(adjacent);
                    }
                }
            }
        }
        return -1;
    }
}
