package ar.com.miura.jvm.graph;


/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        java.util.Set<Integer> visitedSet = new java.util.TreeSet<>();
        Integer[] distances = new Integer[n];

        java.util.stream.IntStream.range(0, n).forEach(eachVertex->distances[eachVertex]=Integer.MAX_VALUE);

        //initialize the graph
        //destination, cost
        java.util.List<java.util.List<Integer[]>> adjacentList = new java.util.ArrayList<>();
        java.util.stream.IntStream.range(0, n).forEach(vertex->adjacentList.add(new java.util.ArrayList()));

        /*
        origin
        destination
        cost
        */
        for(int[] eachEdge:flights) {
            int u = eachEdge[0];
            int v = eachEdge[1];
            int cost = eachEdge[2];
            adjacentList.get(u).add(new Integer[]{v,cost});
        }

        java.util.PriorityQueue<Integer[]> priorityQueue = new java.util.PriorityQueue(n, new java.util.Comparator<Integer[]>() {
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1]-o2[1];
            }
        });

        distances[src] = 0;
        priorityQueue.offer(new Integer[]{src, distances[src], 0});

        int totalCost = 0;
        while(!priorityQueue.isEmpty()) {


            //get min vertex
            Integer[] minPair = priorityQueue.poll();

            int vertex = minPair[0];
            int costFromSrc =  minPair[1];
            int distanceFromSrc = minPair[2];

            /*
            If reached destination return the cost
            */
            if (vertex==dst) {
                return costFromSrc;
            }

            if (distanceFromSrc<K+1) {
                java.util.List<Integer[]> currentAdjacentList = adjacentList.get(vertex);
                for(Integer[] pair:currentAdjacentList) {
                    int destination = pair[0];
                    int newCost = pair[1];
                    if (!visitedSet.contains(destination)) {
                        Integer[] newPair = new Integer[]{destination,costFromSrc + newCost, distanceFromSrc + 1};
                        priorityQueue.offer(newPair);
                    }
                }
            }
        }

        /*
        Can't find the path
        */
        return -1;
    }
}