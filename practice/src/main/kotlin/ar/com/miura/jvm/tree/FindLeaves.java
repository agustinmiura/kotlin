package ar.com.miura.jvm.tree;

public class FindLeaves {

    public java.util.List<java.util.List<Integer>> findLeaves(TreeNode root) {
        java.util.List<java.util.List<Integer>> integers = new java.util.ArrayList();
        subFindLeaves(root, integers);
        return integers;
    }

    private void subFindLeaves(TreeNode node, java.util.List<java.util.List<Integer>> integers) {
        java.util.List<javafx.util.Pair<Integer, Integer>> pairs = new java.util.ArrayList();
        collectElements(node, pairs);
        java.util.Collections.sort(pairs, getComparator());

        int size = pairs.size();
        int index = 0;

        java.util.List<Integer> level = null;
        int levelBefore = -1;
        while(index<size) {

            javafx.util.Pair<Integer, Integer> pair = pairs.get(index);
            Integer height = pair.getKey();
            Integer value = pair.getValue();

            if (height!=levelBefore) {

                if (level!=null) {
                    integers.add(level);
                }

                level = new java.util.ArrayList();
                level.add(value);
                levelBefore = height;

            } else {
                level.add(value);

            }

            index++;
        }
        integers.add(level);
    }

    private java.util.Comparator<javafx.util.Pair<Integer, Integer>> getComparator() {
        java.util.Comparator<javafx.util.Pair<Integer, Integer>> comparator = (pair1, pair2) -> {
            int height1 = pair1.getKey();
            int value1 = pair1.getValue();

            int height2 = pair2.getKey();
            int value2 = pair2.getValue();

            if (height1!=height2) {
                return (height1-height2);
            } else {
                return (value1-value2);
            }

        };
        return comparator;

    }

    private void collectElements(TreeNode node, java.util.List<javafx.util.Pair<Integer, Integer>> pairs) {

        if (node==null) {
            return;
        }

        Integer height = getHeight(node);

        javafx.util.Pair<Integer, Integer> pair = new javafx.util.Pair(height, node.val);
        pairs.add(pair);

        if (node.left!=null) {
            collectElements(node.left, pairs);
        }
        if (node.right!=null) {
            collectElements(node.right, pairs);
        }

    }

    private Integer getHeight(TreeNode node) {

        if (node==null) {
            return -1;
        }


        if (node.left==null && node.right==null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);

    }
}
