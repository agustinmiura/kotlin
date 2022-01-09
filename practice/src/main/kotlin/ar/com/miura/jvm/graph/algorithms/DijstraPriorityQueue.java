package ar.com.miura.jvm.graph.algorithms;

public class DijstraPriorityQueue {

    /**
     * Max cost
     */
    private static final int MAX_COST = 100;

    /**
     * @param graph  Each entry is origin, destination, cost
     * @param graphSize
     * @return
     */
    public Integer[][] getDistances(int[][] graph,int graphSize, int startVertex) {

        java.util.Set<Integer> visitedSet = new java.util.TreeSet<>();
        Integer[] distances = new Integer[graphSize];

        //Set maximum cost here
        java.util.stream.IntStream.range(0, graphSize).forEach(eachVertex -> distances[eachVertex]=MAX_COST);

        //initialize the graph
        java.util.List<java.util.List<Integer[]>> adjancentList = new java.util.ArrayList<>();
        java.util.stream.IntStream.range(0, graphSize).forEach(vertex->adjancentList.add(new java.util.ArrayList<>()));

        /**
         * Each edge has :
         *  0 : origin,
         *  1 : destination
         *  2:  cost
         */
        for(int[] eachEdge:graph) {
            adjancentList.get(eachEdge[0]).add(new Integer[]{eachEdge[1], eachEdge[2]});
        }

        /**
         * First elemment is the destination
         * Second element is the cost
         */
        java.util.PriorityQueue<Integer[]> priorityQueue = new java.util.PriorityQueue<>(graphSize, new java.util.Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return (o1[1]-o2[1]);
            }
        });

        /**
         * Start at index o
         */
        distances[startVertex] = 0;
        priorityQueue.offer(new Integer[]{startVertex, distances[startVertex]});

        Integer[] parents = new Integer[graphSize];
        parents[startVertex] = null;

        while(!priorityQueue.isEmpty()) {

            //extract the min
            Integer[] minPair = priorityQueue.poll();

            //extracted Vertex
            int vertex = minPair[0];
            if (!visitedSet.contains(vertex)) {
                visitedSet.add(vertex);

                java.util.List<Integer[]> currentAdjacentList = adjancentList.get(vertex);
                for(Integer[] pair:currentAdjacentList) {
                    int destinaton = pair[0];
                    int cost = pair[1];

                    if (!visitedSet.contains(destinaton)) {
                        int newCost = distances[vertex] + cost;
                        int currentCost = distances[destinaton];
                        if (newCost<currentCost) {
                            parents[destinaton] = vertex;
                            Integer[] newPair = new Integer[]{destinaton, newCost};
                            priorityQueue.offer(newPair);
                            distances[destinaton] = newCost;
                        }
                    }
                }
            }
        }

        Integer[][] distancesParents = new Integer[2][];
        distancesParents[0] = distances;
        distancesParents[1] = parents;
        return distancesParents;
    }

}
