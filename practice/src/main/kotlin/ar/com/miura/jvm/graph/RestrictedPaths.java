package ar.com.miura.jvm.graph;

public class RestrictedPaths {
    public class Edges implements Comparable<Edges> {
        public int v, d;
        public Edges(int v, int d) {
            this.v = v;
            this.d = d;
        }
        public int compareTo(Edges other) {
            return d - other.d;
        }
    }
    public int[] distance;
    public int answer = 0, mod = (int) 1e9 + 7;
    public int countRestrictedPaths(int n, int[][] edges) {
        //strategy: Dijkstra + DP
        //find the shortest distance from n to all of the surrounding nodes
        distance = new int[n + 1];
        java.util.Arrays.fill(distance, Integer.MAX_VALUE);
        //create map linking each node with the weight
        java.util.HashMap<Integer, java.util.ArrayList<ar.com.miura.jvm.graph.RestrictedPaths.Edges>> map = new java.util.HashMap<>();
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new java.util.ArrayList<>()).add(new Edges(e[1], e[2]));
            map.computeIfAbsent(e[1], k -> new java.util.ArrayList<>()).add(new Edges(e[0], e[2]));
        }
        dijkstra(map, n);
        //use dp array to keep track of the number of restricted paths from node i to node n
        Integer[] dp = new Integer[n + 1];
        return dp(map, dp, 1, n) % mod;
    }
    public void dijkstra(java.util.HashMap<Integer, java.util.ArrayList<ar.com.miura.jvm.graph.RestrictedPaths.Edges>> map, int n) {
        //use pq to sort by smallest weights first
        java.util.PriorityQueue<ar.com.miura.jvm.graph.RestrictedPaths.Edges> pq = new java.util.PriorityQueue<>();
        pq.add(new Edges(n, 0));
        distance[n] = 0;
        while (!pq.isEmpty()) {
            Edges curr = pq.poll();
            //check all neighbors
            for (Edges neighbor : map.getOrDefault(curr.v, new java.util.ArrayList<>())) {
                //only go to neighbor if it will have a smaller weight
                if (distance[curr.v] + neighbor.d < distance[neighbor.v]) {
                    distance[neighbor.v] = distance[curr.v] + neighbor.d;
                    //add to pq
                    pq.add(new Edges(neighbor.v, distance[neighbor.v]));
                }
            }
        }
    }
    public int dp(java.util.HashMap<Integer, java.util.ArrayList<ar.com.miura.jvm.graph.RestrictedPaths.Edges>> map, Integer[] dp, int curr, int n) {
        //reached end so we found a path
        if (curr == n) {
            return 1;
        }
        int answer = 0;
        for (Edges neighbor : map.getOrDefault(curr, new java.util.ArrayList<>())) {
            //make sure that the distance is smaller than curr distance
            if (distance[curr] > distance[neighbor.v]) {
                //if we haven't seen it continue to recurse
                if (dp[neighbor.v] == null) {
                    answer = (answer + dp(map, dp, neighbor.v, n)) % mod;
                    //if we have seen it use the dp array that tracked this sub problem
                } else {
                    answer = (answer + dp[neighbor.v]) % mod;
                }
            }
        }
        //always mod
        return dp[curr] = answer % mod;
    }
}
