package ar.com.miura.jvm.tree;

public class DeleteLeavesWithValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if (root==null) {
            return null;
        }

        if (root.left!=null) {
            dfs(root.left, root, true, target);
        }

        if (root.right!=null) {
            dfs(root.right, root, false, target);
        }

        if (root!=null && root.left==null && root.right==null && root.val==target) {
            return null;
        }

        return root;
    }

    private void dfs(TreeNode node, TreeNode parent, boolean leftChild, int target) {

        if (node==null) {
            return;
        }

        if (node.left!=null) {
            dfs(node.left, node, true, target);
        }

        if (node.right!=null) {
            dfs(node.right, node, false, target);
        }

        if (node.left==null && node.right==null && node.val==target) {
            if (leftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

    }
}
