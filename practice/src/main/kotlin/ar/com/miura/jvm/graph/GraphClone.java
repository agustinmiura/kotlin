package ar.com.miura.jvm.graph;


/**
 * https://leetcode.com/problems/clone-graph/
 */
public class GraphClone {

    public Node cloneGraph(Node node) {

        if (node==null) {
            return node;
        }

        java.util.Set<Integer> visited = new java.util.TreeSet<>();

        //index , node
        java.util.Map<Integer, ar.com.miura.jvm.graph.GraphClone.Node> indexNodeMap = new java.util.TreeMap<>();
        indexNodeMap.put(node.val, new Node(node.val, new java.util.ArrayList()));

        java.util.Queue<ar.com.miura.jvm.graph.GraphClone.Node> queue = new java.util.LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {

            Node top = queue.poll();

            for(Node eachChild:top.neighbors) {
                if (!visited.contains(eachChild.val)) {
                    visited.add(eachChild.val);
                    queue.add(eachChild);

                    indexNodeMap.put(eachChild.val, new Node(eachChild.val));
                }
                indexNodeMap.get(top.val).neighbors.add(indexNodeMap.get(eachChild.val));
            }
        }

        return indexNodeMap.get(node.val);
    }

    public static class Node {
        public int val;
        public java.util.List<ar.com.miura.jvm.graph.GraphClone.Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new java.util.ArrayList<ar.com.miura.jvm.graph.GraphClone.Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new java.util.ArrayList<ar.com.miura.jvm.graph.GraphClone.Node>();
        }
        public Node(int _val, java.util.ArrayList<ar.com.miura.jvm.graph.GraphClone.Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


}
