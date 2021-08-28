package ar.com.miura.pramp;

class Solution {

    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static class SalesPath {
        int getCheapestCost(Node rootNode) {
            return recursiveCost(rootNode);
        }
        private int recursiveCost(Node node) {
            if (node==null) {
                return 0;
            }
            int nodeCost = node.cost;
            int minCost = Integer.MAX_VALUE;
            Node[] children = node.children;
            for(Node eachChild:children) {
                minCost = Math.min(minCost, nodeCost + recursiveCost(eachChild));
            }
            return minCost;
        }
    }

    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {

    }
}