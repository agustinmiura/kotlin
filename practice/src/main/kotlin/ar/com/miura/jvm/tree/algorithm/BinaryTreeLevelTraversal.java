package ar.com.miura.jvm.tree.algorithm;

public class BinaryTreeLevelTraversal {
    public java.util.List<java.util.List<Integer>> levelOrder(ar.com.miura.jvm.tree.TreeNode root) {

        if (root==null) {
            return new java.util.ArrayList<java.util.List<Integer>>();
        }

        java.util.List<java.util.List<Integer>> levels = new java.util.ArrayList<java.util.List<Integer>>();

        java.util.Queue<ar.com.miura.jvm.tree.TreeNode> queue = new java.util.LinkedList<ar.com.miura.jvm.tree.TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            int size = queue.size();
            java.util.List<Integer> nodes = new java.util.ArrayList<Integer>();

            for(int i=0;i<size;i++) {

                ar.com.miura.jvm.tree.TreeNode node = queue.poll();
                nodes.add(node.getVal());
                if (node.getLeft()!=null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight()!=null) {
                    queue.offer(node.getRight());
                }

            }

            levels.add(nodes);

        }

        return levels;
    }
}
