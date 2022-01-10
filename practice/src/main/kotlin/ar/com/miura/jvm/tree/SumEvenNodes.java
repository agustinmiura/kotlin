package ar.com.miura.jvm.tree;

public class SumEvenNodes {
    public int sumEvenGrandparent(TreeNode root) {
        java.util.List<Integer> numbers = new java.util.ArrayList<Integer>();
        fillNumbers(-100, -100, root, numbers);
        Integer sum = numbers.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }

    private void fillNumbers(Integer grandParent, Integer father, TreeNode node, java.util.List<Integer> numbers) {
        if (node==null) {
            return;
        }

        if (grandParent>=1 && grandParent%2==0) {
            numbers.add(node.val);
        }

        if (node.left!=null) {
            fillNumbers(father, node.val, node.left, numbers);

        }

        if (node.right!=null) {
            fillNumbers(father, node.val, node.right, numbers);

        }

    }
}
