package java.ar.com.miura.tree;

public class TwoSumBST {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        java.util.Set<Integer> integers = new java.util.HashSet<Integer>();
        fillIntegers(root1, integers, target);
        boolean contains = contains(root2, integers);
        return contains;
    }

    private void fillIntegers(TreeNode node, java.util.Set<Integer> integers, int target) {
        if (node==null) {
            return;
        }
        if (node.left!=null) {
            fillIntegers(node.left, integers, target);
        }
        integers.add(target - node.val);
        if (node.right!=null) {
            fillIntegers(node.right, integers, target);
        }
    }

    private boolean contains(TreeNode node, java.util.Set<Integer> integers) {

        if (node==null) {
            return false;
        }

        boolean contains = false;

        if (node.left!=null) {
            contains = contains || contains(node.left, integers);

        }

        contains = contains || integers.contains(node.val);

        if (node.right!=null) {
            contains = contains || contains(node.right, integers);
        }

        return contains;
    }
}
