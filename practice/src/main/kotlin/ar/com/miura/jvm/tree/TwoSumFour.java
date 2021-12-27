package ar.com.miura.jvm.tree;

public class TwoSumFour {
    public boolean findTarget(TreeNode root, int k) {

        java.util.List<Integer> numbers = new java.util.ArrayList<Integer>();
        inorder(root, numbers);

        int[] intArray = numbers.stream().mapToInt(Integer::intValue).toArray();
        int left = 0;

        int right = intArray.length-1;

        while(left<right) {

            int sum = intArray[left] + intArray[right];
            if (sum==k) {
                return true;
            } else if (sum>k) {
                right--;
            } else {
                left++;
            }

        }
        return false;
    }

    private void inorder(TreeNode node, java.util.List<Integer> numbers) {

        if (node==null) {
            return;
        }

        if (node.left!=null) {
            inorder(node.left, numbers);
        }

        numbers.add(node.val);

        if (node.right!=null) {
            inorder(node.right, numbers);
        }

    }
}
