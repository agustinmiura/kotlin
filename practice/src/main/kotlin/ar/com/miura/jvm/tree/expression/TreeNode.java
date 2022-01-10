package ar.com.miura.jvm.tree.expression;

class TreeNode extends Node {

    String val;
    TreeNode left;
    TreeNode right;

    public TreeNode(String val) {
        this.val = val;
    }

    public int evaluate() {
        return recursive(this);
    }

    private int recursive(TreeNode node) {
        if (node.left==null && node.right==null) {
            return Integer.parseInt(node.val);
        }
        int left = recursive(node.left);
        int right = recursive(node.right);
        int result = 0;
        String operator = node.val;
        if (operator.equals("+")) {
            result = left + right;

        } else if (operator.equals("-")) {
            result = left - right;

        } else if (operator.equals("*")) {
            result = left * right;

        } else if (operator.equals("/")) {
            result = left / right;

        }

        return result;
    }

}