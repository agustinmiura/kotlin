package ar.com.miura.jvm.tree;


/**
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3666/
 */
public class AddOneRow {

    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if (d==1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;

        } else {
            return preorder(root, v, d, 1, root);

        }
    }

    private TreeNode preorder(TreeNode node, int v, int d, int currentLevel, TreeNode root) {

        if (node==null) {
            return null;

        }


        if (currentLevel==(d-1)) {

            TreeNode newLeft = new TreeNode(v);
            TreeNode newRight = new TreeNode(v);

            newLeft.left = node.left;
            newRight.right = node.right;

            node.left = newLeft;
            node.right = newRight;



        } else {

            preorder(node.left, v, d, currentLevel+1, root);
            preorder(node.right, v, d, currentLevel+1, root);

        }

        return root;
    }
}
