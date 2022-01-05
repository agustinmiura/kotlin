package ar.com.miura.lc.tree;

public class BoundaryBinaryTree {
    public java.util.List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if (root==null) {
            return new java.util.ArrayList<>();
        }
        if (isLeaf(root)) {
            java.util.List<Integer> boundaries = new java.util.ArrayList<Integer>();
            boundaries.add(root.val);
            return boundaries;
        }

        java.util.List<Integer> boundaries = new java.util.ArrayList<Integer>();
        boundaries.add(root.val);

        java.util.Set<Integer> added = new java.util.TreeSet<Integer>();
        added.add(root.val);

        /*
        Add the most left branch of the node
        */
        TreeNode t = root.left;
        while (t != null) {
            if (!isLeaf(t)) {
                boundaries.add(t.val);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }

        }

        /*
        Add now the leaves
        */
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.offer(root);

        /**
         * Add the leaves now
         **/
        addLeaves(boundaries, root);

        /**
         * Add the most right element
         **/
        TreeNode right = root.right;

        java.util.List<Integer> rightElements = new java.util.ArrayList<Integer>();
        while(right!=null) {

            if (right.left!=null && right.right!=null) {
                rightElements.add(right.val);
                right = right.right;

            } else if (right.left!=null && right.right==null) {
                rightElements.add(right.val);
                right = right.left;

            } else if (right.left==null && right.right!=null) {
                rightElements.add(right.val);
                right = right.right;

            } else {
                right = null;

            }

        }

        java.util.Collections.reverse(rightElements);
        //System.out.println(" The right : " + rightElements.toString());

        boundaries.addAll(rightElements);

        return boundaries;
    }

    private void addLeaves(java.util.List<Integer> boundaries, TreeNode node) {
        if (isLeaf(node)) {
            boundaries.add(node.val);
        } else {
            if (node.left != null) {
                addLeaves(boundaries, node.left);
            }
            if (node.right != null) {
                addLeaves(boundaries, node.right);
            }
        }
    }

    private boolean isLeaf(TreeNode node) {
        return (node!=null && node.left==null && node.right==null);

    }
}
