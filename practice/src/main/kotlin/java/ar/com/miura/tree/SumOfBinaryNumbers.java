package java.ar.com.miura.tree;

public class SumOfBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {

        if (root==null) {
            return root.val;
        }

        java.util.List<String> strings = new java.util.ArrayList<String>();
        recursive(root, strings, "");

        int sum = 0;
        for(String string:strings) {
            Integer parsed = Integer.parseInt(string,2);
            sum += parsed;
        }
        return sum;
    }

    private void recursive(TreeNode root, java.util.List<String> strings, String content) {

        if (root.left!=null) {
            recursive(root.left, strings, content + root.val);
        }

        if (root.left==null && root.right==null) {
            strings.add(content + root.val);
            return;
        }

        if (root.right!=null) {
            recursive(root.right, strings, content + root.val);
        }



    }
}
