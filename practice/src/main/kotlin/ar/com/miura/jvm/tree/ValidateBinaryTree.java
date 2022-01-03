package ar.com.miura.jvm.tree;

public class ValidateBinaryTree {
    public boolean isValidBST(TreeNode root) {
        if (root==null) {
            return true;
        }
        return recursiveValidation(root, null, null);
    }

    private boolean recursiveValidation(TreeNode node, Integer low, Integer high) {
        if (node==null) {
            return true;
        }
        if ( (low!=null && node.val<=low) || (high!=null && node.val>=high) ) {
            return false;
        }
        return recursiveValidation(node.left, low, node.val)
                && recursiveValidation(node.right, node.val, high);
    }
}
