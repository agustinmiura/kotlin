package ar.com.miura.jvm.tree;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class ConstructPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return recursive(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode recursive(int[] preorder, int bound, int[] i) {

        int index = i[0];
        if (index==preorder.length || preorder[index]>bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index]);
        i[0]++;

        root.left = recursive(preorder, root.val, i);
        root.right = recursive(preorder, bound, i);

        return root;
    }
}
