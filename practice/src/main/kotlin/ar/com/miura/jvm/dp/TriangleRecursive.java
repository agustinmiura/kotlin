package ar.com.miura.jvm.dp;

public class TriangleRecursive {
    public int minimumTotal(java.util.List<java.util.List<Integer>> triangle) {
        int triangleHeight = triangle.size();
        return recursivePath(triangle, 0, 0);
    }

    private int recursivePath(java.util.List<java.util.List<Integer>> triangle, int currentLevel, int index) {

        if (currentLevel>=triangle.size()) {
            return 0;
        }

        java.util.List<Integer> levelValues = triangle.get(currentLevel);
        int height = triangle.size();

        if (currentLevel==0) {
            return levelValues.get(0) + recursivePath(triangle, 1, 0);

        } else {
            int minIndex = (levelValues.get(index)<levelValues.get(index+1)) ? index : (index+1);
            int min = levelValues.get(minIndex);
            return min + recursivePath(triangle, currentLevel+1, minIndex);

        }
    }
}
