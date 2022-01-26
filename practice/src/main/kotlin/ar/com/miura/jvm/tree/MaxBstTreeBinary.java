package ar.com.miura.jvm.tree;

public class MaxBstTreeBinary {
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        int[] result = postOrderTraverse(root);
        return maxSum;
    }
    private int[] postOrderTraverse(TreeNode root) {

        if (root==null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = postOrderTraverse(root.left);
        int[] right = postOrderTraverse(root.right);

        boolean validTree = (left!=null && right!=null && root.val>left[1] && root.val<right[0]);
        if (!validTree) {
            return null;
        }

        int sum = root.val + left[2] + right[2];

        int min = Math.min(root.val, left[0]);
        int max = Math.max(root.val, right[1]);

        maxSum = Math.max(maxSum, sum);

        return new int[]{min, max, sum};

    }
}
