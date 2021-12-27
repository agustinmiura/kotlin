package ar.com.miura.jvm.graph;

public class NestedListQueue {
    public int depthSum(java.util.List<NestedInteger> nestedList) {
        return bfs(nestedList);
    }

    private int bfs(java.util.List<NestedInteger> nestedList) {

        int total = 0;
        int level = 1;

        java.util.Queue<NestedInteger> queue = new java.util.LinkedList<NestedInteger>();
        queue.addAll(nestedList);

        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int i=0;i<size;i++) {

                NestedInteger nested = queue.poll();
                if (nested.isInteger()) {
                    total += nested.getInteger()*level;
                } else {
                    queue.addAll(nested.getList());
                }

            }
            level++;

        }

        return total;

    }

}
