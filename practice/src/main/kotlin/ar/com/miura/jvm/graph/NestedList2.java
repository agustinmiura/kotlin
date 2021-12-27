package ar.com.miura.jvm.graph;

public class NestedList2 {
    public int depthSumInverse(java.util.List<NestedInteger> nestedList) {
        int maxDepth = 1;
        maxDepth = dfs(nestedList);

        int total = dfsSum(1,nestedList, maxDepth);
        return total;
    }

    private int dfsSum(int level, java.util.List<NestedInteger> nestedList, int max) {
        int total = 0;
        for(NestedInteger nested:nestedList) {
            if (nested.isInteger()) {
                total += nested.getInteger() * (max - (level) + 1);
            } else {
                total += dfsSum(level+1,nested.getList(), max);
            }
        }
        return total;
    }

    private int dfs(java.util.List<NestedInteger> nestedList) {
        int maxLevel = 1;
        for(int i=0;i<nestedList.size();i++) {
            NestedInteger element = nestedList.get(i);
            if (!element.isInteger()) {
                int currentLevel = 1 + dfs(element.getList());
                maxLevel = Math.max(currentLevel, maxLevel);
            }

        }
        return maxLevel;
    }
}
