package ar.com.miura.jvm.tree;

public class BinaryMaxTree {
    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        recursivePath(root, max);
        return max[0];
    }

    private int recursivePath(TreeNode node,int[] max) {
        if (node==null) {
            return 0;
        }
        int leftMax = Math.max(recursivePath(node.left, max), 0);
        int rightMax = Math.max(recursivePath(node.right, max), 0);
        max[0] = Math.max(max[0], node.val + leftMax + rightMax);
        return node.val + Math.max(leftMax, rightMax);
    }
}
