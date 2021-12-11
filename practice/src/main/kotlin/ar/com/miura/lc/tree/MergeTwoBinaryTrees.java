package ar.com.miura.lc.tree;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return recursiveMerge(root1, root2);
    }

    private TreeNode recursiveMerge(TreeNode root1, TreeNode root2) {

        TreeNode rootNode = null;

        if (root1!=null && root2==null) {
            rootNode = root1;
        }

        if (root1==null && root2!=null) {
            rootNode = root2;
        }

        if (root1!=null && root2!=null) {
            int val = root1.val + root2.val;
            rootNode = new TreeNode(val);
        }

        if ( (root1!=null && root1.left!=null) || (root2!=null && root2.left!=null) )  {
            rootNode.left = mergeTrees(
                    (root1!=null && root1.left!=null) ? root1.left : null, //root1
                    (root2!=null && root2.left!=null) ? root2.left : null  //root2
            );
        }

        if ( (root1!=null && root1.right!=null) || (root2!=null && root2.right!=null) )  {
            rootNode.right = mergeTrees(
                    (root1!=null && root1.right!=null) ? root1.right : null, //root1
                    (root2!=null && root2.right!=null) ? root2.right : null  //root2
            );
        }

        return rootNode;
    }
}
