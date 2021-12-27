package ar.com.miura.jvm.graph;

public class NestedList {
    public int depthSum(java.util.List<NestedInteger> nestedList) {
        return dfs(1, nestedList);
    }
    private int dfs(int level, java.util.List<NestedInteger> nestedList) {
        int total = 0;
        for(NestedInteger nested:nestedList) {
            if (nested.isInteger()) {
                total += nested.getInteger() * level;
            } else {
                total += dfs(level+1, nested.getList());
            }
        }
        return total;
    }
}
