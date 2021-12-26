package java.ar.com.miura.tree;

public class SameSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root==null) {
            return false;
        }

        if (isSame(root, subRoot)) {
            return true;

        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        }
    }

    private boolean isSame(TreeNode node, TreeNode subRoot) {

        if (node==null && subRoot==null) {
            return true;
        } else if (node==null || subRoot==null) {
            return false;
        }

        if (node.val == subRoot.val) {
            return isSame(node.left, subRoot.left) && isSame(node.right, subRoot.right);

        } else {
            return false;

        }
    }
}
