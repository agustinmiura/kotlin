package ar.com.miura.jvm.graph;

public class CountPairs {

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        java.util.Map<ar.com.miura.jvm.graph.CountPairs.Pair, Integer> m = new java.util.HashMap<>();
        int[] d = new int[n+1];

        for (int[] e: edges) {  // O(E)
            d[e[0]]++;
            d[e[1]]++;
            Pair p = new Pair(e[0], e[1]);
            m.put(p, m.getOrDefault(p, 0) + 1);
        }

        int[] sd = java.util.Arrays.copyOf(d, d.length); // O(V)
        java.util.Arrays.sort(sd);
        int[] res = new int[queries.length];
        int rit = 0;

        for(int x : queries) {   // O(Q * (V + V^2)  = O(Q * V^2)
            int ans = 0;
            int l = 1, r = n;
            while (l < n) {  // O(V)
                while (l < r && (sd[l] + sd[r] > x)) r--;
                ans += n - r;
                l++;
                if (r <= l) r = l + 1;
            }
            for(java.util.Map.Entry<Pair, Integer> e : m.entrySet()) { // O(V^2) ( V^2 - possible pairs of vertices)
                int y = e.getValue();
                Pair p = e.getKey();
                if ((d[p.x] + d[p.y] > x) && (d[p.x] + d[p.y] - y <= x)) ans--;
            }
            res[rit++] = ans;
        }
        return res;

    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            this.x = x;this.y = y;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return p.x == this.x && p.y == this.y;
        }

        public int hashCode() {
            return 31 * x + y;
        }
    }
}
