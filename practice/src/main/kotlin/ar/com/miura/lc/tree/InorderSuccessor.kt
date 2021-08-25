package ar.com.miura.lc.tree

import java.util.*;

class InorderSuccessor {
    fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {

        /*
        with a right node return the lower to the left
        */
        if (p!!.right!=null) {
            var left = p.right;
            if (left!=null) {
                while(left.left != null) {
                    left = left.left;
                }
            }
            return left;
        }

        var nodes = mutableListOf<TreeNode>();
        inorder(root, p, nodes);
        if (!nodes.isEmpty()) {
            return nodes.last();
        } else {
            return null;
        }

    }

    private fun inorder(root: TreeNode?, p: TreeNode?, nodes: MutableList<TreeNode>) {

        if (root==null) {
            return;
        }

        var rootValue = root.`val`;
        var toFind = p!!.`val`;

        if (toFind>=rootValue) {
            inorder(root.right, p, nodes);

        } else {
            nodes.add(root);
            inorder(root.left, p, nodes);
        }

    }
}