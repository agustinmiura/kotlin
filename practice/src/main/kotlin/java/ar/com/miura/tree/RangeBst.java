package java.ar.com.miura.tree;

public class RangeBst {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return recursiveSum(root, low, high);
    }

    private int recursiveSum(TreeNode root, int low, int high) {

        if (root==null) {
            return 0;
        }

        int value = root.val;
        int sum = 0;
        if (value>=low && value<=high) {
            sum += value;
        }

        if (root.left!=null) {
            sum += recursiveSum(root.left, low, high);
        }

        if (root.right!=null) {
            sum += recursiveSum(root.right, low, high);
        }

        return sum;

    }
}
