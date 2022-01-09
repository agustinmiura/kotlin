package ar.com.miura.jvm.graph;


/**
 * https://leetcode.com/problems/path-with-maximum-probability/
 */
public class PathMaxProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        java.util.Set<Integer> visitedSet = new java.util.TreeSet<>();
        double[] probabilities = new double[n];

        //initilize the graph here
        java.util.List<java.util.List<ar.com.miura.jvm.graph.PathMaxProbability.ProbabilityNode>> adjacentList = new java.util.ArrayList<>();
        java.util.stream.IntStream.range(0, n).forEach(vertex -> adjacentList.add(new java.util.ArrayList<>()));

        //Fill the adjacent List
        int index = -1;
        for (int[] edge : edges) {
            index++;
            int u = edge[0];
            int v = edge[1];
            adjacentList.get(u).add(new ProbabilityNode(v, succProb[index]));
            adjacentList.get(v).add(new ProbabilityNode(u, succProb[index]));
        }

        /**
         * Priority Queue with destination and probability
         */
        java.util.PriorityQueue<ar.com.miura.jvm.graph.PathMaxProbability.ProbabilityNode> priorityQueue = new java.util.PriorityQueue<>(n);

        /**
         * Set the first element
         */
        priorityQueue.offer(new ProbabilityNode(start, 1.0));
        probabilities[start] = 1.0;
        /**
         * Set the parents
         */
        Integer[] parents = new Integer[n];
        parents[start] = null;

        while (!priorityQueue.isEmpty()) {
            //Extract the min element
            ProbabilityNode minElement = priorityQueue.poll();

            int vertex = minElement.getV();
            double probability = minElement.getProbability();

            if (!visitedSet.contains(vertex)) {
                visitedSet.add(vertex);

                java.util.List<ar.com.miura.jvm.graph.PathMaxProbability.ProbabilityNode> currentAdjacents = adjacentList.get(vertex);
                for (ProbabilityNode adjacentNode : currentAdjacents) {
                    int v = adjacentNode.getV();
                    double newCost = probability * adjacentNode.getProbability();
                    if (newCost > probabilities[v]) {
                        priorityQueue.add(new ProbabilityNode(v, newCost));
                        probabilities[v] = newCost;
                    }
                }
            }
        }

        return probabilities[end];
    }

    public class ProbabilityNode implements Comparable<ProbabilityNode> {
        private Integer v;
        private Double probability;

        public ProbabilityNode(Integer v, Double probability) {
            this.v = v;
            this.probability = probability;
        }

        public Integer getV() {
            return v;
        }

        public Double getProbability() {
            return probability;
        }

        public int compareTo(ProbabilityNode otherNode) {
            return -1 * probability.compareTo(otherNode.getProbability());
        }
    }

}

