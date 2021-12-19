package ar.com.miura.lc.tree;

public class TrimBst {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return recursive(root, low, high);
    }

    private TreeNode recursive(TreeNode root, int low, int high) {
        if (root==null) {
            return null;
        }

        if (root.val > high) {
            return recursive(root.left, low, high);
        }
        if (root.val < low) {
            return recursive(root.right, low, high);
        }

        root.left = recursive(root.left, low, high);
        root.right = recursive(root.right, low, high);

        return root;
    }
}
