package ar.com.miura.jvm.tree;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonDenominator {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] nodes = new TreeNode[1];
        recursive(root, p, q, nodes);
        return nodes[0];
    }

    private void recursive(TreeNode root, TreeNode p, TreeNode q, TreeNode[] nodes) {

        if (root==null) {
            return;
        }

        if (isParent(root, p) && isParent(root,q)) {
            nodes[0] = root;
        }
        recursive(root.left, p, q, nodes);
        recursive(root.right, p, q, nodes);
    }

    private boolean isParent(TreeNode node, TreeNode p) {
        if (node==null) {
            return false;
        }
        if (node.val==p.val) {
            return true;
        } else {
            boolean left = isParent(node.left, p);
            boolean right = isParent(node.right, p);
            return left || right;
        }
    }
}
