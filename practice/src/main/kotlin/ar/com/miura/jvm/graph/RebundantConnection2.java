package ar.com.miura.jvm.graph;


/**
 * https://leetcode.com/problems/redundant-connection-ii/
 * Directed graph find vertex creating cycle.
 */
public class RebundantConnection2 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int N = edges.length;
        java.util.Map<Integer, Integer> parent = new java.util.HashMap();
        java.util.List<int[]> candidates = new java.util.ArrayList();
        for (int[] edge: edges) {
            if (parent.containsKey(edge[1])) {
                candidates.add(new int[]{parent.get(edge[1]), edge[1]});
                candidates.add(edge);
            } else {
                parent.put(edge[1], edge[0]);
            }
        }

        int root = orbit(1, parent).node;
        if (candidates.isEmpty()) {
            java.util.Set<Integer> cycle = orbit(root, parent).seen;
            int[] ans = new int[]{0, 0};
            for (int[] edge: edges) {
                if (cycle.contains(edge[0]) && cycle.contains(edge[1])) {
                    ans = edge;
                }
            }
            return ans;
        }

        java.util.Map<Integer, java.util.List<Integer>> children = new java.util.HashMap();
        for (int v: parent.keySet()) {
            int pv = parent.get(v);
            if (!children.containsKey(pv))
                children.put(pv, new java.util.ArrayList<Integer>());
            children.get(pv).add(v);
        }

        boolean[] seen = new boolean[N+1];
        seen[0] = true;
        java.util.Stack<Integer> stack = new java.util.Stack();
        stack.add(root);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!seen[node]) {
                seen[node] = true;
                if (children.containsKey(node)) {
                    for (int c: children.get(node))
                        stack.push(c);
                }
            }
        }
        for (boolean b: seen) if (!b)
            return candidates.get(0);
        return candidates.get(1);
    }

    public OrbitResult orbit(int node, java.util.Map<Integer, Integer> parent) {
        java.util.Set<Integer> seen = new java.util.HashSet();
        while (parent.containsKey(node) && !seen.contains(node)) {
            seen.add(node);
            node = parent.get(node);
        }
        return new OrbitResult(node, seen);
    }

    class OrbitResult {
        int node;
        java.util.Set<Integer> seen;
        OrbitResult(int n, java.util.Set<Integer> s) {
            node = n;
            seen = s;
        }
    }
}
