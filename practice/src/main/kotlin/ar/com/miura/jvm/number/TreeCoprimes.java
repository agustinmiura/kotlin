package ar.com.miura.jvm.number;

/**
 * https://leetcode.com/contest/biweekly-contest-46/problems/tree-of-coprimes/
 * leetcode 1766
 *
 * Input: nums = [2,3,3,2], edges = [[0,1],[1,2],[1,3]]
 * Output: [-1,0,0,1]
 * Explanation: In the above figure, each node's value is in parentheses.
 * - Node 0 has no coprime ancestors.
 * - Node 1 has only one ancestor, node 0. Their values are coprime (gcd(2,3) == 1).
 * - Node 2 has two ancestors, nodes 1 and 0. Node 1's value is not coprime (gcd(3,3) == 3), but node 0's
 *   value is (gcd(2,3) == 1), so node 0 is the closest valid ancestor.
 * - Node 3 has two ancestors, nodes 1 and 0. It is coprime with node 1 (gcd(3,2) == 1), so node 1 is its
 *   closest valid ancestor.
 *
 *   Input: nums = [5,6,10,2,3,6,15], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
 * Output: [-1,0,-1,0,0,0,-1]
 *
 * Brute force solution here
 */
class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {

        //coprimes answer
        int size = nums.length;
        int[] coprimes = new int[size];
        for(int i=0;i<size;i++) {
            coprimes[i]=-1;
        }


        //created visited node list
        java.util.Set<Integer> visitedSet = new java.util.TreeSet<>();

        //start graph
        java.util.Map<Integer, java.util.List<Integer>> adjacentList = new java.util.TreeMap();
        for(int i=0;i<nums.length;i++) {
            adjacentList.put(i, new java.util.ArrayList<Integer>());
        }
        //fill the graph with edges
        for(int[] eachPair:edges) {
            int u = eachPair[0];
            int v = eachPair[1];
            adjacentList.get(u).add(v);
            adjacentList.get(v).add(u);
        }

        //parents list
        java.util.Map<Integer, java.util.List<Integer>> parents = new java.util.TreeMap<>();
        for(int i=0;i<nums.length;i++) {
            parents.put(i, new java.util.ArrayList<Integer>());
        }

        java.util.Stack<Integer> intStack = new java.util.Stack<>();
        intStack.push(0);
        visitedSet.add(0);
        parents.get(0).add(-1);

        int parent = -1;
        while(!intStack.isEmpty()) {

            Integer node = intStack.pop();

            java.util.List<Integer> children = adjacentList.get(node);
            for(int i=0;i<children.size();i++) {

                Integer eachAdjacent = children.get(i);
                if (!visitedSet.contains(eachAdjacent)) {

                    intStack.add(eachAdjacent);
                    visitedSet.add(eachAdjacent);

                    parents.get(eachAdjacent).add(node);

                    int gcd = getGcd(nums[node], nums[eachAdjacent]);

                    boolean isCoprime = isCoprime(nums[node], nums[eachAdjacent]);

                    if (isCoprime) {
                        coprimes[eachAdjacent]=node;
                    }
                }
            }
        }

        //Process the coprimes for all the items that don't have parent
        for(int i=0;i<coprimes.length;i++) {
            //
            int eachCoprime = coprimes[i];
            if (eachCoprime==-1 && !parents.get(i).contains(-1)) {
                java.util.Queue<Integer> queue = new java.util.LinkedList<Integer>();
                queue.add(parents.get(i).get(0));
                while(!queue.isEmpty()) {
                    parent = queue.poll();
                    if (parent==-1) {
                        break;

                    } else {
                        boolean isCoprime = isCoprime(nums[i], nums[parent]);
                        if (isCoprime) {
                            coprimes[i]=parent;
                            break;
                        } else {
                            queue.offer(parents.get(parent).get(0));
                        }

                    }
                }
            }
        }
        return coprimes;
    }

    private int getGcd(int a, int b) {
        if (b==0) {
            return a;
        } else {
            return (getGcd(b, a%b));
        }
    }

    private boolean isCoprime(int a, int b) {
        return (getGcd(a,b)==1);
    }

}