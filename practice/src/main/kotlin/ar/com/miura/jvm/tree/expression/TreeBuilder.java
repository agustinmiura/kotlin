package ar.com.miura.jvm.tree.expression;

class TreeBuilder {

    Node buildTree(String[] postfix) {

        String operators = "+-/*";

        int size = postfix.length;
        java.util.Stack<TreeNode> stack = new java.util.Stack();
        for(int i=0;i<size;i++) {

            String value = postfix[i];
            if (operators.contains(value)) {
                TreeNode current = new TreeNode(value);
                current.right = stack.pop();
                current.left = stack.pop();
                stack.push(current);

            } else {
                stack.push(new TreeNode(value));

            }
        }
        return stack.pop();
    }
}