package ar.com.miura.jvm.tree;

public class SumEvenNodesBetter {
    public int sumEvenGrandparent(TreeNode root) {
        return fillNumbers(-100, -100, root);
    }

    private int fillNumbers(Integer grandParent, Integer father, TreeNode node) {
        if (node==null) {
            return 0;
        }
        int sum = 0;
        if (grandParent>=1 && grandParent%2==0) {
            sum += node.val;
        }
        if (node.left!=null) {
            sum += fillNumbers(father, node.val, node.left);
        }
        if (node.right!=null) {
            sum += fillNumbers(father, node.val, node.right);
        }
        return sum;
    }
}
