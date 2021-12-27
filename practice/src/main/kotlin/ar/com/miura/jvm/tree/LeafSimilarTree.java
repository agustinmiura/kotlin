package ar.com.miura.jvm.tree;

public class LeafSimilarTree {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        java.util.List<Integer> root1Leafs = new java.util.ArrayList<Integer>();
        java.util.List<Integer> root2Leafs = new java.util.ArrayList<Integer>();

        getLeaves(root1, root1Leafs);
        getLeaves(root2, root2Leafs);

        if (root1Leafs.size()!=root2Leafs.size()) {
            return false;
        } else {
            return root1Leafs.equals(root2Leafs);
        }

    }

    private void getLeaves(TreeNode node, java.util.List<Integer> leaves) {
        if (node==null) {
            return;
        }
        if (node.left!=null) {
            getLeaves(node.left, leaves);
        }
        if (node.left==null && node.right==null) {
            leaves.add(node.val);
        }
        if (node.right!=null) {
            getLeaves(node.right, leaves);
        }
    }
}
