package ar.com.miura.lc.tree;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        return subInvert(root);
    }
    private TreeNode subInvert(TreeNode node) {
        if (node==null) {
            return null;
        }
        TreeNode right = subInvert(node.right);
        TreeNode left = subInvert(node.left);
        node.left = right;
        node.right = left;
        return node;
    }
}
