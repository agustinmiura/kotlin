package ar.com.miura.jvm.tree;

public class InsifficientNodes {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return cutTree(root, limit);
    }

    private TreeNode cutTree(TreeNode node, int limit) {

        if (node==null) {
            return null;
        }
          /*
          Node is a leaf
          */
        if (node.left==null && node.right==null) {

            TreeNode result = node;
            if (node.val < limit) {
                result = null;
            }
            return result;

        } else {
              /*
              all path from this node to leaf is insufficient
              */
            node.left = cutTree(node.left, limit - node.val);
            node.right = cutTree(node.right, limit - node.val);
            if (node.left==null && node.right==null) {
                return null;
            } else {
                return node;
            }
        }
    }
}
